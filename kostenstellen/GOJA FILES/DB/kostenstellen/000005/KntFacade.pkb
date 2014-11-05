create or replace package body KntFacade is
    
    procedure chkKnt(KntId number) is
    currentClass number;
    begin
        select Cls into currentClass from Knt where id = KntId;
        if currentClass <> 126 then
            raise_application_error(-20000, 'Object not of right class! Required: 126 Actual: ' || currentClass);
        end if; 
    end chkKnt;
    
    function newKnt(KntIDVal varchar2,GrnzwrtVal number,KntstndVal number,MnmmVal number,createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select SKnt.nextVal into result from dual;
        end if;
        insert into Knt (id,Cls,KntKntID,KntGrnzwrt,KntKntstnd,KntMnmm)
            values (result,126,KntIDVal,GrnzwrtVal,KntstndVal,MnmmVal);
        return result;
    end newKnt;
    
    function newDelayedKnt return number is
    result number;
    begin
        select SKnt.nextVal into result from dual;
        return result;
    end newDelayedKnt;
    
    function getKnt(KntId number) return KntInfoColl is 
    result KntInfoColl;
    begin
        chkKnt(KntId);
        open result for select id,KntKntID,KntGrnzwrt,KntKntstnd,KntMnmm,KntSbSrvc,KntSbSrvcCls,KntThis,KntThisCls from Knt
            where id = KntId and Cls = 126;
        return result;
    end getKnt;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from Knt where id = objectId;
        return result;
    end getClass;
    procedure chkSpecKnt(KntId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Knt base, Specialization spec
             where base.id = KntId and base.Cls = spec.descendant and spec.ancestor = 126;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 126 Actual: ' || currentClass);
    end chkSpecKnt;
    
    function getKntByKntID(KntID varchar2) return KntFacade.KntAllColl is 
    result KntFacade.KntAllColl;
    begin
        open result for select id,Cls,KntKntID,KntGrnzwrt,KntKntstnd,KntMnmm,KntSbSrvc,KntSbSrvcCls,KntThis,KntThisCls from Knt where KntKntID like KntID and (id,Cls) not in (select * from DeletedObjects);
        return result;
    end getKntByKntID;
    
    procedure KntIDSet(KntId number, KntIDVal varchar2)is
    begin 
        chkSpecKnt(KntId);
        update Knt set KntKntID = KntIDVal where id = KntId;
    end KntIDSet;
    
    
    procedure GrnzwrtSet(KntId number, GrnzwrtVal number)is
    begin 
        chkSpecKnt(KntId);
        update Knt set KntGrnzwrt = GrnzwrtVal where id = KntId;
    end GrnzwrtSet;
    
    
    procedure KntstndSet(KntId number, KntstndVal number)is
    begin 
        chkSpecKnt(KntId);
        update Knt set KntKntstnd = KntstndVal where id = KntId;
    end KntstndSet;
    
    
    procedure MnmmSet(KntId number, MnmmVal number)is
    begin 
        chkSpecKnt(KntId);
        update Knt set KntMnmm = MnmmVal where id = KntId;
    end MnmmSet;
    
    
    procedure sbSrvcSet(KntId number, sbSrvcVal number, sbSrvcCls number)is
    begin 
        chkSpecKnt(KntId);
        ClassFacade.checkIfObjectExists(sbSrvcVal, sbSrvcCls);
        ClassFacade.checkHasAsDescendant(136, sbSrvcCls);
        update Knt set KntSbSrvc = sbSrvcVal where id = KntId;
        update Knt set KntSbSrvcCls = sbSrvcCls where id = KntId;
    end sbSrvcSet;
    
    
    procedure ThisSet(KntId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecKnt(KntId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(126, ThisCls);
        update Knt set KntThis = ThisVal where id = KntId;
        update Knt set KntThisCls = ThisCls where id = KntId;
    end ThisSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end KntFacade;
/


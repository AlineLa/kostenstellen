create or replace package body TrnsfrFacade is
    
    procedure chkTrnsfr(TrnsfrId number) is
    currentClass number;
    begin
        select Cls into currentClass from Trnsfr where id = TrnsfrId;
        if currentClass <> 118 then
            raise_application_error(-20000, 'Object not of right class! Required: 118 Actual: ' || currentClass);
        end if; 
    end chkTrnsfr;
    
    function newTrnsfr(SmmVal number,KntIDVal varchar2,createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select STrnsfr.nextVal into result from dual;
        end if;
        insert into Trnsfr (id,Cls,TrnsfrSmm,TrnsfrKntID)
            values (result,118,SmmVal,KntIDVal);
        return result;
    end newTrnsfr;
    
    function newDelayedTrnsfr return number is
    result number;
    begin
        select STrnsfr.nextVal into result from dual;
        return result;
    end newDelayedTrnsfr;
    
    function getTrnsfr(TrnsfrId number) return TrnsfrInfoColl is 
    result TrnsfrInfoColl;
    begin
        chkTrnsfr(TrnsfrId);
        open result for select id,TrnsfrVnKnt,TrnsfrVnKntCls,TrnsfrZKnt,TrnsfrZKntCls,TrnsfrSmm,TrnsfrKntID,TrnsfrSbSrvc,TrnsfrSbSrvcCls,TrnsfrThis,TrnsfrThisCls from Trnsfr
            where id = TrnsfrId and Cls = 118;
        return result;
    end getTrnsfr;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from Trnsfr where id = objectId;
        return result;
    end getClass;
    procedure chkSpecTrnsfr(TrnsfrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Trnsfr base, Specialization spec
             where base.id = TrnsfrId and base.Cls = spec.descendant and spec.ancestor = 118;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 118 Actual: ' || currentClass);
    end chkSpecTrnsfr;
    
    procedure vnKntSet(TrnsfrId number, vnKntVal number, vnKntCls number)is
    begin 
        chkSpecTrnsfr(TrnsfrId);
        ClassFacade.checkIfObjectExists(vnKntVal, vnKntCls);
        ClassFacade.checkHasAsDescendant(126, vnKntCls);
        update Trnsfr set TrnsfrVnKnt = vnKntVal where id = TrnsfrId;
        update Trnsfr set TrnsfrVnKntCls = vnKntCls where id = TrnsfrId;
    end vnKntSet;
    
    
    procedure zKntSet(TrnsfrId number, zKntVal number, zKntCls number)is
    begin 
        chkSpecTrnsfr(TrnsfrId);
        ClassFacade.checkIfObjectExists(zKntVal, zKntCls);
        ClassFacade.checkHasAsDescendant(126, zKntCls);
        update Trnsfr set TrnsfrZKnt = zKntVal where id = TrnsfrId;
        update Trnsfr set TrnsfrZKntCls = zKntCls where id = TrnsfrId;
    end zKntSet;
    
    
    procedure SmmSet(TrnsfrId number, SmmVal number)is
    begin 
        chkSpecTrnsfr(TrnsfrId);
        update Trnsfr set TrnsfrSmm = SmmVal where id = TrnsfrId;
    end SmmSet;
    
    
    procedure KntIDSet(TrnsfrId number, KntIDVal varchar2)is
    begin 
        chkSpecTrnsfr(TrnsfrId);
        update Trnsfr set TrnsfrKntID = KntIDVal where id = TrnsfrId;
    end KntIDSet;
    
    
    procedure sbSrvcSet(TrnsfrId number, sbSrvcVal number, sbSrvcCls number)is
    begin 
        chkSpecTrnsfr(TrnsfrId);
        ClassFacade.checkIfObjectExists(sbSrvcVal, sbSrvcCls);
        ClassFacade.checkHasAsDescendant(136, sbSrvcCls);
        update Trnsfr set TrnsfrSbSrvc = sbSrvcVal where id = TrnsfrId;
        update Trnsfr set TrnsfrSbSrvcCls = sbSrvcCls where id = TrnsfrId;
    end sbSrvcSet;
    
    
    procedure ThisSet(TrnsfrId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecTrnsfr(TrnsfrId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(118, ThisCls);
        update Trnsfr set TrnsfrThis = ThisVal where id = TrnsfrId;
        update Trnsfr set TrnsfrThisCls = ThisCls where id = TrnsfrId;
    end ThisSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end TrnsfrFacade;
/


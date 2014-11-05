create or replace package body KntFcdFacade is
    
    procedure chkKntFcd(KntFcdId number) is
    currentClass number;
    begin
        select Cls into currentClass from KntFcd where id = KntFcdId;
        if currentClass <> 127 then
            raise_application_error(-20000, 'Object not of right class! Required: 127 Actual: ' || currentClass);
        end if; 
    end chkKntFcd;
    
    function newKntFcd(createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select SKntFcd.nextVal into result from dual;
        end if;
        insert into KntFcd (id,Cls)
            values (result,127);
        return result;
    end newKntFcd;
    
    function newDelayedKntFcd return number is
    result number;
    begin
        select SKntFcd.nextVal into result from dual;
        return result;
    end newDelayedKntFcd;
    
    function getKntFcd(KntFcdId number) return KntFcdInfoColl is 
    result KntFcdInfoColl;
    begin
        chkKntFcd(KntFcdId);
        open result for select id,KntFcdSbSrvc,KntFcdSbSrvcCls,KntFcdThis,KntFcdThisCls from KntFcd
            where id = KntFcdId and Cls = 127;
        return result;
    end getKntFcd;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from KntFcd where id = objectId;
        return result;
    end getClass;
    procedure chkSpecKntFcd(KntFcdId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from KntFcd base, Specialization spec
             where base.id = KntFcdId and base.Cls = spec.descendant and spec.ancestor = 127;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 127 Actual: ' || currentClass);
    end chkSpecKntFcd;
    
    procedure sbSrvcSet(KntFcdId number, sbSrvcVal number, sbSrvcCls number)is
    begin 
        chkSpecKntFcd(KntFcdId);
        ClassFacade.checkIfObjectExists(sbSrvcVal, sbSrvcCls);
        ClassFacade.checkHasAsDescendant(136, sbSrvcCls);
        update KntFcd set KntFcdSbSrvc = sbSrvcVal where id = KntFcdId;
        update KntFcd set KntFcdSbSrvcCls = sbSrvcCls where id = KntFcdId;
    end sbSrvcSet;
    
    
    procedure ThisSet(KntFcdId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecKntFcd(KntFcdId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(127, ThisCls);
        update KntFcd set KntFcdThis = ThisVal where id = KntFcdId;
        update KntFcd set KntFcdThisCls = ThisCls where id = KntFcdId;
    end ThisSet;
    
    
    function kntnGet(KntFcdId number) return ManyServices.ManyInfoCollection is 
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecKntFcd(KntFcdId);
        open result for select kntn, Cls, id from KntFcdKntn
            where frm = KntFcdId
            order by id asc;
        return result;
    end kntnGet;
    
    function kntnAdd(KntFcdId number, kntnVal number, kntnCls number) return number is
    result number;
    begin
        chkSpecKntFcd(KntFcdId);
        ClassFacade.checkIfObjectExists(kntnVal, kntnCls);
        ClassFacade.checkHasAsDescendant(126, kntnCls);
        select SKntFcdKntn.nextVal into result from dual;
        insert into KntFcdKntn (id, frm, kntn, Cls)
        values (result, KntFcdId, kntnVal, kntnCls);
        return result;
    end kntnAdd;
    
    procedure kntnRem(kntnId number) is
    begin
        delete from KntFcdKntn where id = kntnId;
    end kntnRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end KntFcdFacade;
/


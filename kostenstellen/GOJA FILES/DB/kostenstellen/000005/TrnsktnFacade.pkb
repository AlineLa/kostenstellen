create or replace package body TrnsktnFacade is
    
    procedure chkTrnsktn(TrnsktnId number) is
    currentClass number;
    begin
        select Cls into currentClass from Trnsktn where id = TrnsktnId;
        if currentClass <> 112 then
            raise_application_error(-20000, 'Object not of right class! Required: 112 Actual: ' || currentClass);
        end if; 
    end chkTrnsktn;
    
    function newTrnsktn(createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select STrnsktn.nextVal into result from dual;
        end if;
        insert into Trnsktn (id,Cls)
            values (result,112);
        return result;
    end newTrnsktn;
    
    function newDelayedTrnsktn return number is
    result number;
    begin
        select STrnsktn.nextVal into result from dual;
        return result;
    end newDelayedTrnsktn;
    
    function getTrnsktn(TrnsktnId number) return TrnsktnInfoColl is 
    result TrnsktnInfoColl;
    begin
        chkTrnsktn(TrnsktnId);
        open result for select id,TrnsktnSbSrvc,TrnsktnSbSrvcCls,TrnsktnThis,TrnsktnThisCls from Trnsktn
            where id = TrnsktnId and Cls = 112;
        return result;
    end getTrnsktn;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from Trnsktn where id = objectId;
        return result;
    end getClass;
    procedure chkSpecTrnsktn(TrnsktnId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Trnsktn base, Specialization spec
             where base.id = TrnsktnId and base.Cls = spec.descendant and spec.ancestor = 112;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 112 Actual: ' || currentClass);
    end chkSpecTrnsktn;
    
    procedure sbSrvcSet(TrnsktnId number, sbSrvcVal number, sbSrvcCls number)is
    begin 
        chkSpecTrnsktn(TrnsktnId);
        ClassFacade.checkIfObjectExists(sbSrvcVal, sbSrvcCls);
        ClassFacade.checkHasAsDescendant(136, sbSrvcCls);
        update Trnsktn set TrnsktnSbSrvc = sbSrvcVal where id = TrnsktnId;
        update Trnsktn set TrnsktnSbSrvcCls = sbSrvcCls where id = TrnsktnId;
    end sbSrvcSet;
    
    
    procedure ThisSet(TrnsktnId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecTrnsktn(TrnsktnId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(112, ThisCls);
        update Trnsktn set TrnsktnThis = ThisVal where id = TrnsktnId;
        update Trnsktn set TrnsktnThisCls = ThisCls where id = TrnsktnId;
    end ThisSet;
    
    
    function trnsfrsGet(TrnsktnId number) return ManyServices.ManyInfoCollection is 
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecTrnsktn(TrnsktnId);
        open result for select trnsfrs, Cls, id from TrnsktnTrnsfrs
            where frm = TrnsktnId
            order by id asc;
        return result;
    end trnsfrsGet;
    
    function trnsfrsAdd(TrnsktnId number, trnsfrsVal number, trnsfrsCls number) return number is
    result number;
    begin
        chkSpecTrnsktn(TrnsktnId);
        ClassFacade.checkIfObjectExists(trnsfrsVal, trnsfrsCls);
        ClassFacade.checkHasAsDescendant(118, trnsfrsCls);
        select STrnsktnTrnsfrs.nextVal into result from dual;
        insert into TrnsktnTrnsfrs (id, frm, trnsfrs, Cls)
        values (result, TrnsktnId, trnsfrsVal, trnsfrsCls);
        return result;
    end trnsfrsAdd;
    
    procedure trnsfrsRem(trnsfrsId number) is
    begin
        delete from TrnsktnTrnsfrs where id = trnsfrsId;
    end trnsfrsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end TrnsktnFacade;
/


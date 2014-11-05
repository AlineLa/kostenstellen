create or replace package body TrnsFcdTrnsktnsFacade is
    
    procedure chkTrnsFcdTrnsktns(TrnsFcdTrnsktnsId number) is
    currentClass number;
    begin
        select Cls into currentClass from TrnsFcdTrnsktns where id = TrnsFcdTrnsktnsId;
        if currentClass <> 116 then
            raise_application_error(-20000, 'Object not of right class! Required: 116 Actual: ' || currentClass);
        end if; 
    end chkTrnsFcdTrnsktns;
    
    function newTrnsFcdTrnsktns(createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select STrnsFcdTrnsktns.nextVal into result from dual;
        end if;
        insert into TrnsFcdTrnsktns (id,Cls)
            values (result,116);
        return result;
    end newTrnsFcdTrnsktns;
    
    function newDelayedTrnsFcdTrnsktns return number is
    result number;
    begin
        select STrnsFcdTrnsktns.nextVal into result from dual;
        return result;
    end newDelayedTrnsFcdTrnsktns;
    
    function getTrnsFcdTrnsktns(TrnsFcdTrnsktnsId number) return TrnsFcdTrnsktnsInfoColl is 
    result TrnsFcdTrnsktnsInfoColl;
    begin
        chkTrnsFcdTrnsktns(TrnsFcdTrnsktnsId);
        open result for select id,TrnsFcdTrnsktnsMstr,TrnsFcdTrnsktnsMstrCls,TrnsFcdTrnsktnsThis,TrnsFcdTrnsktnsThisCls from TrnsFcdTrnsktns
            where id = TrnsFcdTrnsktnsId and Cls = 116;
        return result;
    end getTrnsFcdTrnsktns;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from TrnsFcdTrnsktns where id = objectId;
        return result;
    end getClass;
    procedure chkSpecTrnsFcdTrnsktns(TrnsFcdTrnsktnsId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from TrnsFcdTrnsktns base, Specialization spec
             where base.id = TrnsFcdTrnsktnsId and base.Cls = spec.descendant and spec.ancestor = 116;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 116 Actual: ' || currentClass);
    end chkSpecTrnsFcdTrnsktns;
    
    procedure mstrSet(TrnsFcdTrnsktnsId number, mstrVal number, mstrCls number)is
    begin 
        chkSpecTrnsFcdTrnsktns(TrnsFcdTrnsktnsId);
        ClassFacade.checkIfObjectExists(mstrVal, mstrCls);
        ClassFacade.checkHasAsDescendant(129, mstrCls);
        update TrnsFcdTrnsktns set TrnsFcdTrnsktnsMstr = mstrVal where id = TrnsFcdTrnsktnsId;
        update TrnsFcdTrnsktns set TrnsFcdTrnsktnsMstrCls = mstrCls where id = TrnsFcdTrnsktnsId;
    end mstrSet;
    
    
    procedure ThisSet(TrnsFcdTrnsktnsId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecTrnsFcdTrnsktns(TrnsFcdTrnsktnsId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(116, ThisCls);
        update TrnsFcdTrnsktns set TrnsFcdTrnsktnsThis = ThisVal where id = TrnsFcdTrnsktnsId;
        update TrnsFcdTrnsktns set TrnsFcdTrnsktnsThisCls = ThisCls where id = TrnsFcdTrnsktnsId;
    end ThisSet;
    
    
    function obsGet(TrnsFcdTrnsktnsId number) return ManyServices.ManyInfoCollection is 
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecTrnsFcdTrnsktns(TrnsFcdTrnsktnsId);
        open result for select obs, Cls, id from TrnsFcdTrnsktnsObs
            where frm = TrnsFcdTrnsktnsId
            order by id asc;
        return result;
    end obsGet;
    
    function obsAdd(TrnsFcdTrnsktnsId number, obsVal number, obsCls number) return number is
    result number;
    begin
        chkSpecTrnsFcdTrnsktns(TrnsFcdTrnsktnsId);
        ClassFacade.checkIfObjectExists(obsVal, obsCls);
        ClassFacade.checkHasAsDescendant(112, obsCls);
        select STrnsFcdTrnsktnsObs.nextVal into result from dual;
        insert into TrnsFcdTrnsktnsObs (id, frm, obs, Cls)
        values (result, TrnsFcdTrnsktnsId, obsVal, obsCls);
        return result;
    end obsAdd;
    
    procedure obsRem(obsId number) is
    begin
        delete from TrnsFcdTrnsktnsObs where id = obsId;
    end obsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end TrnsFcdTrnsktnsFacade;
/


create or replace package body TrnsFcdFacade is
    
    procedure chkTrnsFcd(TrnsFcdId number) is
    currentClass number;
    begin
        select Cls into currentClass from TrnsFcd where id = TrnsFcdId;
        if currentClass <> 129 then
            raise_application_error(-20000, 'Object not of right class! Required: 129 Actual: ' || currentClass);
        end if; 
    end chkTrnsFcd;
    
    function newTrnsFcd(createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select STrnsFcd.nextVal into result from dual;
        end if;
        insert into TrnsFcd (id,Cls)
            values (result,129);
        return result;
    end newTrnsFcd;
    
    function newDelayedTrnsFcd return number is
    result number;
    begin
        select STrnsFcd.nextVal into result from dual;
        return result;
    end newDelayedTrnsFcd;
    
    function getTrnsFcd(TrnsFcdId number) return TrnsFcdInfoColl is 
    result TrnsFcdInfoColl;
    begin
        chkTrnsFcd(TrnsFcdId);
        open result for select id,TrnsFcdTrnsktns,TrnsFcdTrnsktnsCls,TrnsFcdSbSrvc,TrnsFcdSbSrvcCls,TrnsFcdThis,TrnsFcdThisCls from TrnsFcd
            where id = TrnsFcdId and Cls = 129;
        return result;
    end getTrnsFcd;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from TrnsFcd where id = objectId;
        return result;
    end getClass;
    procedure chkSpecTrnsFcd(TrnsFcdId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from TrnsFcd base, Specialization spec
             where base.id = TrnsFcdId and base.Cls = spec.descendant and spec.ancestor = 129;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 129 Actual: ' || currentClass);
    end chkSpecTrnsFcd;
    
    procedure trnsktnsSet(TrnsFcdId number, trnsktnsVal number, trnsktnsCls number)is
    begin 
        chkSpecTrnsFcd(TrnsFcdId);
        ClassFacade.checkIfObjectExists(trnsktnsVal, trnsktnsCls);
        ClassFacade.checkHasAsDescendant(116, trnsktnsCls);
        update TrnsFcd set TrnsFcdTrnsktns = trnsktnsVal where id = TrnsFcdId;
        update TrnsFcd set TrnsFcdTrnsktnsCls = trnsktnsCls where id = TrnsFcdId;
    end trnsktnsSet;
    
    
    procedure sbSrvcSet(TrnsFcdId number, sbSrvcVal number, sbSrvcCls number)is
    begin 
        chkSpecTrnsFcd(TrnsFcdId);
        ClassFacade.checkIfObjectExists(sbSrvcVal, sbSrvcCls);
        ClassFacade.checkHasAsDescendant(136, sbSrvcCls);
        update TrnsFcd set TrnsFcdSbSrvc = sbSrvcVal where id = TrnsFcdId;
        update TrnsFcd set TrnsFcdSbSrvcCls = sbSrvcCls where id = TrnsFcdId;
    end sbSrvcSet;
    
    
    procedure ThisSet(TrnsFcdId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecTrnsFcd(TrnsFcdId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(129, ThisCls);
        update TrnsFcd set TrnsFcdThis = ThisVal where id = TrnsFcdId;
        update TrnsFcd set TrnsFcdThisCls = ThisCls where id = TrnsFcdId;
    end ThisSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end TrnsFcdFacade;
/


create or replace package body SubjFacade is
    
    procedure chkSubj(SubjId number) is
    currentClass number;
    begin
        select Cls into currentClass from Subj where id = SubjId;
        if currentClass <> 110 then
            raise_application_error(-20000, 'Object not of right class! Required: 110 Actual: ' || currentClass);
        end if; 
    end chkSubj;
    
    function newSubj(createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select SSubj.nextVal into result from dual;
        end if;
        insert into Subj (id,Cls)
            values (result,110);
        return result;
    end newSubj;
    
    function newDelayedSubj return number is
    result number;
    begin
        select SSubj.nextVal into result from dual;
        return result;
    end newDelayedSubj;
    
    function getSubj(SubjId number) return SubjInfoColl is 
    result SubjInfoColl;
    begin
        chkSubj(SubjId);
        open result for select id,SubjThis,SubjThisCls from Subj
            where id = SubjId and Cls = 110;
        return result;
    end getSubj;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from Subj where id = objectId;
        return result;
    end getClass;
    procedure chkSpecSubj(SubjId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Subj base, Specialization spec
             where base.id = SubjId and base.Cls = spec.descendant and spec.ancestor = 110;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 110 Actual: ' || currentClass);
    end chkSpecSubj;
    
    procedure ThisSet(SubjId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecSubj(SubjId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(110, ThisCls);
        update Subj set SubjThis = ThisVal where id = SubjId;
        update Subj set SubjThisCls = ThisCls where id = SubjId;
    end ThisSet;
    
    
    function obsGet(SubjId number) return ManyServices.ManyInfoCollection is 
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecSubj(SubjId);
        open result for select obs, Cls, id from SubjObs
            where frm = SubjId
            order by id asc;
        return result;
    end obsGet;
    
    function obsAdd(SubjId number, obsVal number, obsCls number) return number is
    result number;
    begin
        chkSpecSubj(SubjId);
        ClassFacade.checkIfObjectExists(obsVal, obsCls);
        ClassFacade.checkHasAsDescendant(138, obsCls);
        select SSubjObs.nextVal into result from dual;
        insert into SubjObs (id, frm, obs, Cls)
        values (result, SubjId, obsVal, obsCls);
        return result;
    end obsAdd;
    
    procedure obsRem(obsId number) is
    begin
        delete from SubjObs where id = obsId;
    end obsRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end SubjFacade;
/


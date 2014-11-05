create or replace package body ArtnMngrFacade is
    
    procedure chkArtnMngr(ArtnMngrId number) is
    currentClass number;
    begin
        select Cls into currentClass from ArtnMngr where id = ArtnMngrId;
        if currentClass <> 121 then
            raise_application_error(-20000, 'Object not of right class! Required: 121 Actual: ' || currentClass);
        end if; 
    end chkArtnMngr;
    
    function getTheArtnMngr return number is
    result number;
    begin
        select id into result from ArtnMngr where Cls = 121;
        return result;
    exception
        when no_data_found then
        begin
            select SArtnMngr.nextVal into result from dual;
            insert into ArtnMngr (id,Cls)
                values (result,121);
            return result * -1;
        end;
    end getTheArtnMngr;
    
    function getArtnMngr(ArtnMngrId number) return ArtnMngrInfoColl is 
    result ArtnMngrInfoColl;
    begin
        chkArtnMngr(ArtnMngrId);
        open result for select id,ArtnMngrSbSrvc,ArtnMngrSbSrvcCls,ArtnMngrThis,ArtnMngrThisCls from ArtnMngr
            where id = ArtnMngrId and Cls = 121;
        return result;
    end getArtnMngr;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from ArtnMngr where id = objectId;
        return result;
    end getClass;
    procedure chkSpecArtnMngr(ArtnMngrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from ArtnMngr base, Specialization spec
             where base.id = ArtnMngrId and base.Cls = spec.descendant and spec.ancestor = 121;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 121 Actual: ' || currentClass);
    end chkSpecArtnMngr;
    
    procedure sbSrvcSet(ArtnMngrId number, sbSrvcVal number, sbSrvcCls number)is
    begin 
        chkSpecArtnMngr(ArtnMngrId);
        ClassFacade.checkIfObjectExists(sbSrvcVal, sbSrvcCls);
        ClassFacade.checkHasAsDescendant(136, sbSrvcCls);
        update ArtnMngr set ArtnMngrSbSrvc = sbSrvcVal where id = ArtnMngrId;
        update ArtnMngr set ArtnMngrSbSrvcCls = sbSrvcCls where id = ArtnMngrId;
    end sbSrvcSet;
    
    
    procedure ThisSet(ArtnMngrId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecArtnMngr(ArtnMngrId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(121, ThisCls);
        update ArtnMngr set ArtnMngrThis = ThisVal where id = ArtnMngrId;
        update ArtnMngr set ArtnMngrThisCls = ThisCls where id = ArtnMngrId;
    end ThisSet;
    
    
    function artnGet(ArtnMngrId number) return ManyServices.ManyInfoCollection is 
    result ManyServices.ManyInfoCollection;
    begin
        chkSpecArtnMngr(ArtnMngrId);
        open result for select artn, Cls, id from ArtnMngrArtn
            where frm = ArtnMngrId
            order by id asc;
        return result;
    end artnGet;
    
    function artnAdd(ArtnMngrId number, artnVal number, artnCls number) return number is
    result number;
    begin
        chkSpecArtnMngr(ArtnMngrId);
        ClassFacade.checkIfObjectExists(artnVal, artnCls);
        ClassFacade.checkHasAsDescendant(125, artnCls);
        select SArtnMngrArtn.nextVal into result from dual;
        insert into ArtnMngrArtn (id, frm, artn, Cls)
        values (result, ArtnMngrId, artnVal, artnCls);
        return result;
    end artnAdd;
    
    procedure artnRem(artnId number) is
    begin
        delete from ArtnMngrArtn where id = artnId;
    end artnRem;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end ArtnMngrFacade;
/


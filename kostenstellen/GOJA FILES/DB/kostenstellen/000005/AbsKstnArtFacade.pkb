create or replace package body AbsKstnArtFacade is
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from AbsKstnArt where id = objectId;
        return result;
    end getClass;
    procedure chkSpecAbsKstnArt(AbsKstnArtId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from AbsKstnArt base, Specialization spec
             where base.id = AbsKstnArtId and base.Cls = spec.descendant and spec.ancestor = 111;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 111 Actual: ' || currentClass);
    end chkSpecAbsKstnArt;
    
    procedure sbSrvcSet(AbsKstnArtId number, sbSrvcVal number, sbSrvcCls number)is
    begin 
        chkSpecAbsKstnArt(AbsKstnArtId);
        ClassFacade.checkIfObjectExists(sbSrvcVal, sbSrvcCls);
        ClassFacade.checkHasAsDescendant(136, sbSrvcCls);
        update AbsKstnArt set AbsKstnArtSbSrvc = sbSrvcVal where id = AbsKstnArtId;
        update AbsKstnArt set AbsKstnArtSbSrvcCls = sbSrvcCls where id = AbsKstnArtId;
    end sbSrvcSet;
    
    
    procedure ThisSet(AbsKstnArtId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecAbsKstnArt(AbsKstnArtId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(111, ThisCls);
        update AbsKstnArt set AbsKstnArtThis = ThisVal where id = AbsKstnArtId;
        update AbsKstnArt set AbsKstnArtThisCls = ThisCls where id = AbsKstnArtId;
    end ThisSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end AbsKstnArtFacade;
/


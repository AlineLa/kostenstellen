create or replace package body KnkrKstnArtFacade is
    
    procedure chkSpecKnkrKstnArt(KnkrKstnArtId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from AbsKstnArt base, Specialization spec
             where base.id = KnkrKstnArtId and base.Cls = spec.descendant and spec.ancestor = 125;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 125 Actual: ' || currentClass);
    end chkSpecKnkrKstnArt;
    
    procedure spzllrAlsSet(KnkrKstnArtId number, spzllrAlsVal number, spzllrAlsCls number)is
    begin 
        chkSpecKnkrKstnArt(KnkrKstnArtId);
        ClassFacade.checkIfObjectExists(spzllrAlsVal, spzllrAlsCls);
        ClassFacade.checkHasAsDescendant(111, spzllrAlsCls);
        update AbsKstnArt set KnkrKstnArtSpzllrAls = spzllrAlsVal where id = KnkrKstnArtId;
        update AbsKstnArt set KnkrKstnArtSpzllrAlsCls = spzllrAlsCls where id = KnkrKstnArtId;
    end spzllrAlsSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end KnkrKstnArtFacade;
/


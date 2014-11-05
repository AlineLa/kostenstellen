create or replace package body AllgmnKstnFacade is
    
    procedure chkAllgmnKstn(AllgmnKstnId number) is
    currentClass number;
    begin
        select Cls into currentClass from AbsKstnArt where id = AllgmnKstnId;
        if currentClass <> 115 then
            raise_application_error(-20000, 'Object not of right class! Required: 115 Actual: ' || currentClass);
        end if; 
    end chkAllgmnKstn;
    
    function getTheAllgmnKstn return number is
    result number;
    begin
        select id into result from AbsKstnArt where Cls = 115;
        return result;
    exception
        when no_data_found then
        begin
            select SAbsKstnArt.nextVal into result from dual;
            insert into AbsKstnArt (id,Cls)
                values (result,115);
            return result * -1;
        end;
    end getTheAllgmnKstn;
    
    function getAllgmnKstn(AllgmnKstnId number) return AllgmnKstnInfoColl is 
    result AllgmnKstnInfoColl;
    begin
        chkAllgmnKstn(AllgmnKstnId);
        open result for select id,AbsKstnArtSbSrvc,AbsKstnArtSbSrvcCls,AbsKstnArtThis,AbsKstnArtThisCls,KnkrKstnArtSpzllrAls,KnkrKstnArtSpzllrAlsCls from AbsKstnArt
            where id = AllgmnKstnId and Cls = 115;
        return result;
    end getAllgmnKstn;
    
    procedure chkSpecAllgmnKstn(AllgmnKstnId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from AbsKstnArt base, Specialization spec
             where base.id = AllgmnKstnId and base.Cls = spec.descendant and spec.ancestor = 115;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 115 Actual: ' || currentClass);
    end chkSpecAllgmnKstn;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end AllgmnKstnFacade;
/


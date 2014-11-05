create or replace package body LhnKstnFacade is
    
    procedure chkLhnKstn(LhnKstnId number) is
    currentClass number;
    begin
        select Cls into currentClass from AbsKstnArt where id = LhnKstnId;
        if currentClass <> 130 then
            raise_application_error(-20000, 'Object not of right class! Required: 130 Actual: ' || currentClass);
        end if; 
    end chkLhnKstn;
    
    function getTheLhnKstn return number is
    result number;
    begin
        select id into result from AbsKstnArt where Cls = 130;
        return result;
    exception
        when no_data_found then
        begin
            select SAbsKstnArt.nextVal into result from dual;
            insert into AbsKstnArt (id,Cls)
                values (result,130);
            return result * -1;
        end;
    end getTheLhnKstn;
    
    function getLhnKstn(LhnKstnId number) return LhnKstnInfoColl is 
    result LhnKstnInfoColl;
    begin
        chkLhnKstn(LhnKstnId);
        open result for select id,AbsKstnArtSbSrvc,AbsKstnArtSbSrvcCls,AbsKstnArtThis,AbsKstnArtThisCls,KnkrKstnArtSpzllrAls,KnkrKstnArtSpzllrAlsCls from AbsKstnArt
            where id = LhnKstnId and Cls = 130;
        return result;
    end getLhnKstn;
    
    procedure chkSpecLhnKstn(LhnKstnId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from AbsKstnArt base, Specialization spec
             where base.id = LhnKstnId and base.Cls = spec.descendant and spec.ancestor = 130;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 130 Actual: ' || currentClass);
    end chkSpecLhnKstn;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end LhnKstnFacade;
/


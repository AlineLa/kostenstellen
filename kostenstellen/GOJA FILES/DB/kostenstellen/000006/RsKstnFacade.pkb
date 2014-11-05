create or replace package body RsKstnFacade is
    
    procedure chkRsKstn(RsKstnId number) is
    currentClass number;
    begin
        select Cls into currentClass from AbsKstnArt where id = RsKstnId;
        if currentClass <> 122 then
            raise_application_error(-20000, 'Object not of right class! Required: 122 Actual: ' || currentClass);
        end if; 
    end chkRsKstn;
    
    function getTheRsKstn return number is
    result number;
    begin
        select id into result from AbsKstnArt where Cls = 122;
        return result;
    exception
        when no_data_found then
        begin
            select SAbsKstnArt.nextVal into result from dual;
            insert into AbsKstnArt (id,Cls)
                values (result,122);
            return result * -1;
        end;
    end getTheRsKstn;
    
    function getRsKstn(RsKstnId number) return RsKstnInfoColl is 
    result RsKstnInfoColl;
    begin
        chkRsKstn(RsKstnId);
        open result for select id,AbsKstnArtSbSrvc,AbsKstnArtSbSrvcCls,AbsKstnArtThis,AbsKstnArtThisCls,KnkrKstnArtSpzllrAls,KnkrKstnArtSpzllrAlsCls from AbsKstnArt
            where id = RsKstnId and Cls = 122;
        return result;
    end getRsKstn;
    
    procedure chkSpecRsKstn(RsKstnId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from AbsKstnArt base, Specialization spec
             where base.id = RsKstnId and base.Cls = spec.descendant and spec.ancestor = 122;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 122 Actual: ' || currentClass);
    end chkSpecRsKstn;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end RsKstnFacade;
/


create or replace package body KstnArtWrzlFacade is
    
    procedure chkKstnArtWrzl(KstnArtWrzlId number) is
    currentClass number;
    begin
        select Cls into currentClass from AbsKstnArt where id = KstnArtWrzlId;
        if currentClass <> 128 then
            raise_application_error(-20000, 'Object not of right class! Required: 128 Actual: ' || currentClass);
        end if; 
    end chkKstnArtWrzl;
    
    function getTheKstnArtWrzl return number is
    result number;
    begin
        select id into result from AbsKstnArt where Cls = 128;
        return result;
    exception
        when no_data_found then
        begin
            select SAbsKstnArt.nextVal into result from dual;
            insert into AbsKstnArt (id,Cls)
                values (result,128);
            return result * -1;
        end;
    end getTheKstnArtWrzl;
    
    function getKstnArtWrzl(KstnArtWrzlId number) return KstnArtWrzlInfoColl is 
    result KstnArtWrzlInfoColl;
    begin
        chkKstnArtWrzl(KstnArtWrzlId);
        open result for select id,AbsKstnArtSbSrvc,AbsKstnArtSbSrvcCls,AbsKstnArtThis,AbsKstnArtThisCls from AbsKstnArt
            where id = KstnArtWrzlId and Cls = 128;
        return result;
    end getKstnArtWrzl;
    
    procedure chkSpecKstnArtWrzl(KstnArtWrzlId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from AbsKstnArt base, Specialization spec
             where base.id = KstnArtWrzlId and base.Cls = spec.descendant and spec.ancestor = 128;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 128 Actual: ' || currentClass);
    end chkSpecKstnArtWrzl;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end KstnArtWrzlFacade;
/


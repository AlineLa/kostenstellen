create or replace package RsKstnFacade is
    
    type RsKstnInfo is record (
        id number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number,
        spzllrAls number, 
        spzllrAlsCls number        
    );
    
    type RsKstnInfoColl is ref cursor return RsKstnInfo;
    
    function getTheRsKstn return number;
    function getRsKstn(RsKstnId number) return RsKstnInfoColl;
    
end RsKstnFacade;
/


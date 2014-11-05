create or replace package LhnKstnFacade is
    
    type LhnKstnInfo is record (
        id number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number,
        spzllrAls number, 
        spzllrAlsCls number        
    );
    
    type LhnKstnInfoColl is ref cursor return LhnKstnInfo;
    
    function getTheLhnKstn return number;
    function getLhnKstn(LhnKstnId number) return LhnKstnInfoColl;
    
end LhnKstnFacade;
/


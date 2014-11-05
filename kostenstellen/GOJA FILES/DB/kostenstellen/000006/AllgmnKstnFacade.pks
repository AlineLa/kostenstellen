create or replace package AllgmnKstnFacade is
    
    type AllgmnKstnInfo is record (
        id number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number,
        spzllrAls number, 
        spzllrAlsCls number        
    );
    
    type AllgmnKstnInfoColl is ref cursor return AllgmnKstnInfo;
    
    function getTheAllgmnKstn return number;
    function getAllgmnKstn(AllgmnKstnId number) return AllgmnKstnInfoColl;
    
end AllgmnKstnFacade;
/


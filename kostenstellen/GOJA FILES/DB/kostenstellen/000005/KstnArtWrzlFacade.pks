create or replace package KstnArtWrzlFacade is
    
    type KstnArtWrzlInfo is record (
        id number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number        
    );
    
    type KstnArtWrzlInfoColl is ref cursor return KstnArtWrzlInfo;
    
    function getTheKstnArtWrzl return number;
    function getKstnArtWrzl(KstnArtWrzlId number) return KstnArtWrzlInfoColl;
    
end KstnArtWrzlFacade;
/


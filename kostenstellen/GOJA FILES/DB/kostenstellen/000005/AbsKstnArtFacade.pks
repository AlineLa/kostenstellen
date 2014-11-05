create or replace package AbsKstnArtFacade is
    
    type AbsKstnArtAll is record (
        id number,
        Cls number,
        AbsKstnArtSbSrvc number,
        AbsKstnArtSbSrvcCls number,
        AbsKstnArtThis number,
        AbsKstnArtThisCls number,
        KnkrKstnArtSpzllrAls number,
        KnkrKstnArtSpzllrAlsCls number
    );
    
    type AbsKstnArtAllColl is ref cursor return AbsKstnArtAll;
    
    
    function getClass(objectId number) return number;
    procedure sbSrvcSet(AbsKstnArtId number, sbSrvcVal number, sbSrvcCls number);
    procedure ThisSet(AbsKstnArtId number, ThisVal number, ThisCls number);
    
end AbsKstnArtFacade;
/


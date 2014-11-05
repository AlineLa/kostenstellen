create or replace package KntFacade is
    
    type KntAll is record (
        id number,
        Cls number,
        KntKntID varchar2(2000),
        KntGrnzwrt number,
        KntKntstnd number,
        KntMnmm number,
        KntSbSrvc number,
        KntSbSrvcCls number,
        KntThis number,
        KntThisCls number
    );
    
    type KntAllColl is ref cursor return KntAll;
    
    
    type KntInfo is record (
        id number,
        KntID varchar2(2000),
        Grnzwrt number,
        Kntstnd number,
        Mnmm number,
        sbSrvc number, 
        sbSrvcCls number,
        This number, 
        ThisCls number        
    );
    
    type KntInfoColl is ref cursor return KntInfo;
    
    function getKnt(KntId number) return KntInfoColl;
    function newKnt(KntIDVal varchar2,GrnzwrtVal number,KntstndVal number,MnmmVal number,createMinusStorePlus number) return number;
    function newDelayedKnt return number;
    function getClass(objectId number) return number;
    function getKntByKntID(KntID varchar2) return KntFacade.KntAllColl;
    procedure KntIDSet(KntId number, KntIDVal varchar2);
    procedure GrnzwrtSet(KntId number, GrnzwrtVal number);
    procedure KntstndSet(KntId number, KntstndVal number);
    procedure MnmmSet(KntId number, MnmmVal number);
    procedure sbSrvcSet(KntId number, sbSrvcVal number, sbSrvcCls number);
    procedure ThisSet(KntId number, ThisVal number, ThisCls number);
    
end KntFacade;
/


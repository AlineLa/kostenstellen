create or replace package FndKntCMDFacade is
    
    type FndKntCMDAll is record (
        id number,
        Cls number,
        FndKntCMDKntID varchar2(2000),
        FndKntCMDInvoker number,
        FndKntCMDInvokerCls number,
        FndKntCMDCReceiver number,
        FndKntCMDCReceiverCls number,
        FndKntCMDMyCmmnDt number,
        FndKntCMDMyCmmnDtCls number
    );
    
    type FndKntCMDAllColl is ref cursor return FndKntCMDAll;
    
    
    type FndKntCMDInfo is record (
        id number,
        KntID varchar2(2000),
        invoker number, 
        invokerCls number,
        cReceiver number, 
        cReceiverCls number,
        myCmmnDt number, 
        myCmmnDtCls number        
    );
    
    type FndKntCMDInfoColl is ref cursor return FndKntCMDInfo;
    
    function getFndKntCMD(FndKntCMDId number) return FndKntCMDInfoColl;
    function newFndKntCMD(KntIDVal varchar2,createMinusStorePlus number) return number;
    function newDelayedFndKntCMD return number;
    function getClass(objectId number) return number;
    procedure KntIDSet(FndKntCMDId number, KntIDVal varchar2);
    procedure invokerSet(FndKntCMDId number, invokerVal number, invokerCls number);
    procedure cReceiverSet(FndKntCMDId number, cReceiverVal number, cReceiverCls number);
    procedure myCmmnDtSet(FndKntCMDId number, myCmmnDtVal number, myCmmnDtCls number);
    
end FndKntCMDFacade;
/


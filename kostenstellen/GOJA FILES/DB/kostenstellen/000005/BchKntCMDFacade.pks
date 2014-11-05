create or replace package BchKntCMDFacade is
    
    type BchKntCMDAll is record (
        id number,
        Cls number,
        BchKntCMDInvoker number,
        BchKntCMDInvokerCls number,
        BchKntCMDCReceiver number,
        BchKntCMDCReceiverCls number,
        BchKntCMDMyCmmnDt number,
        BchKntCMDMyCmmnDtCls number
    );
    
    type BchKntCMDAllColl is ref cursor return BchKntCMDAll;
    
    
    type BchKntCMDInfo is record (
        id number,
        invoker number, 
        invokerCls number,
        cReceiver number, 
        cReceiverCls number,
        myCmmnDt number, 
        myCmmnDtCls number        
    );
    
    type BchKntCMDInfoColl is ref cursor return BchKntCMDInfo;
    
    function getBchKntCMD(BchKntCMDId number) return BchKntCMDInfoColl;
    function newBchKntCMD(createMinusStorePlus number) return number;
    function newDelayedBchKntCMD return number;
    function getClass(objectId number) return number;
    procedure invokerSet(BchKntCMDId number, invokerVal number, invokerCls number);
    procedure cReceiverSet(BchKntCMDId number, cReceiverVal number, cReceiverCls number);
    procedure myCmmnDtSet(BchKntCMDId number, myCmmnDtVal number, myCmmnDtCls number);
    
end BchKntCMDFacade;
/


create or replace package ErzgTrnsktnCMDFacade is
    
    type ErzgTrnsktnCMDAll is record (
        id number,
        Cls number,
        ErzgTrnsktnCMDKntID varchar2(2000),
        ErzgTrnsktnCMDInvoker number,
        ErzgTrnsktnCMDInvokerCls number,
        ErzgTrnsktnCMDCReceiver number,
        ErzgTrnsktnCMDCReceiverCls number,
        ErzgTrnsktnCMDMyCmmnDt number,
        ErzgTrnsktnCMDMyCmmnDtCls number
    );
    
    type ErzgTrnsktnCMDAllColl is ref cursor return ErzgTrnsktnCMDAll;
    
    
    type ErzgTrnsktnCMDInfo is record (
        id number,
        KntID varchar2(2000),
        invoker number, 
        invokerCls number,
        cReceiver number, 
        cReceiverCls number,
        myCmmnDt number, 
        myCmmnDtCls number        
    );
    
    type ErzgTrnsktnCMDInfoColl is ref cursor return ErzgTrnsktnCMDInfo;
    
    function getErzgTrnsktnCMD(ErzgTrnsktnCMDId number) return ErzgTrnsktnCMDInfoColl;
    function newErzgTrnsktnCMD(KntIDVal varchar2,createMinusStorePlus number) return number;
    function newDelayedErzgTrnsktnCMD return number;
    function getClass(objectId number) return number;
    procedure KntIDSet(ErzgTrnsktnCMDId number, KntIDVal varchar2);
    procedure invokerSet(ErzgTrnsktnCMDId number, invokerVal number, invokerCls number);
    procedure cReceiverSet(ErzgTrnsktnCMDId number, cReceiverVal number, cReceiverCls number);
    procedure myCmmnDtSet(ErzgTrnsktnCMDId number, myCmmnDtVal number, myCmmnDtCls number);
    
end ErzgTrnsktnCMDFacade;
/


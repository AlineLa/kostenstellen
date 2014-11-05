create or replace package ErzgKntCMDFacade is
    
    type ErzgKntCMDAll is record (
        id number,
        Cls number,
        ErzgKntCMDKntID varchar2(2000),
        ErzgKntCMDKntstnd number,
        ErzgKntCMDMnmm number,
        ErzgKntCMDGrnzwrt number,
        ErzgKntCMDInvoker number,
        ErzgKntCMDInvokerCls number,
        ErzgKntCMDCReceiver number,
        ErzgKntCMDCReceiverCls number,
        ErzgKntCMDMyCmmnDt number,
        ErzgKntCMDMyCmmnDtCls number
    );
    
    type ErzgKntCMDAllColl is ref cursor return ErzgKntCMDAll;
    
    
    type ErzgKntCMDInfo is record (
        id number,
        KntID varchar2(2000),
        Kntstnd number,
        Mnmm number,
        Grnzwrt number,
        invoker number, 
        invokerCls number,
        cReceiver number, 
        cReceiverCls number,
        myCmmnDt number, 
        myCmmnDtCls number        
    );
    
    type ErzgKntCMDInfoColl is ref cursor return ErzgKntCMDInfo;
    
    function getErzgKntCMD(ErzgKntCMDId number) return ErzgKntCMDInfoColl;
    function newErzgKntCMD(KntIDVal varchar2,KntstndVal number,MnmmVal number,GrnzwrtVal number,createMinusStorePlus number) return number;
    function newDelayedErzgKntCMD return number;
    function getClass(objectId number) return number;
    procedure KntIDSet(ErzgKntCMDId number, KntIDVal varchar2);
    procedure KntstndSet(ErzgKntCMDId number, KntstndVal number);
    procedure MnmmSet(ErzgKntCMDId number, MnmmVal number);
    procedure GrnzwrtSet(ErzgKntCMDId number, GrnzwrtVal number);
    procedure invokerSet(ErzgKntCMDId number, invokerVal number, invokerCls number);
    procedure cReceiverSet(ErzgKntCMDId number, cReceiverVal number, cReceiverCls number);
    procedure myCmmnDtSet(ErzgKntCMDId number, myCmmnDtVal number, myCmmnDtCls number);
    
end ErzgKntCMDFacade;
/


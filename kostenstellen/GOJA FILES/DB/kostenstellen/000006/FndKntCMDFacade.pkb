create or replace package body FndKntCMDFacade is
    
    procedure chkFndKntCMD(FndKntCMDId number) is
    currentClass number;
    begin
        select Cls into currentClass from FndKntCMD where id = FndKntCMDId;
        if currentClass <> 114 then
            raise_application_error(-20000, 'Object not of right class! Required: 114 Actual: ' || currentClass);
        end if; 
    end chkFndKntCMD;
    
    function newFndKntCMD(KntIDVal varchar2,createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select SFndKntCMD.nextVal into result from dual;
        end if;
        insert into FndKntCMD (id,Cls,FndKntCMDKntID)
            values (result,114,KntIDVal);
        return result;
    end newFndKntCMD;
    
    function newDelayedFndKntCMD return number is
    result number;
    begin
        select SFndKntCMD.nextVal into result from dual;
        return result;
    end newDelayedFndKntCMD;
    
    function getFndKntCMD(FndKntCMDId number) return FndKntCMDInfoColl is 
    result FndKntCMDInfoColl;
    begin
        chkFndKntCMD(FndKntCMDId);
        open result for select id,FndKntCMDKntID,FndKntCMDInvoker,FndKntCMDInvokerCls,FndKntCMDCReceiver,FndKntCMDCReceiverCls,FndKntCMDMyCmmnDt,FndKntCMDMyCmmnDtCls from FndKntCMD
            where id = FndKntCMDId and Cls = 114;
        return result;
    end getFndKntCMD;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from FndKntCMD where id = objectId;
        return result;
    end getClass;
    procedure chkSpecFndKntCMD(FndKntCMDId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from FndKntCMD base, Specialization spec
             where base.id = FndKntCMDId and base.Cls = spec.descendant and spec.ancestor = 114;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 114 Actual: ' || currentClass);
    end chkSpecFndKntCMD;
    
    procedure KntIDSet(FndKntCMDId number, KntIDVal varchar2)is
    begin 
        chkSpecFndKntCMD(FndKntCMDId);
        update FndKntCMD set FndKntCMDKntID = KntIDVal where id = FndKntCMDId;
    end KntIDSet;
    
    
    procedure invokerSet(FndKntCMDId number, invokerVal number, invokerCls number)is
    begin 
        chkSpecFndKntCMD(FndKntCMDId);
        ClassFacade.checkIfObjectExists(invokerVal, invokerCls);
        ClassFacade.checkHasAsDescendant(103, invokerCls);
        update FndKntCMD set FndKntCMDInvoker = invokerVal where id = FndKntCMDId;
        update FndKntCMD set FndKntCMDInvokerCls = invokerCls where id = FndKntCMDId;
    end invokerSet;
    
    
    procedure cReceiverSet(FndKntCMDId number, cReceiverVal number, cReceiverCls number)is
    begin 
        chkSpecFndKntCMD(FndKntCMDId);
        ClassFacade.checkIfObjectExists(cReceiverVal, cReceiverCls);
        ClassFacade.checkHasAsDescendant(127, cReceiverCls);
        update FndKntCMD set FndKntCMDCReceiver = cReceiverVal where id = FndKntCMDId;
        update FndKntCMD set FndKntCMDCReceiverCls = cReceiverCls where id = FndKntCMDId;
    end cReceiverSet;
    
    
    procedure myCmmnDtSet(FndKntCMDId number, myCmmnDtVal number, myCmmnDtCls number)is
    begin 
        chkSpecFndKntCMD(FndKntCMDId);
        ClassFacade.checkIfObjectExists(myCmmnDtVal, myCmmnDtCls);
        ClassFacade.checkHasAsDescendant(124, myCmmnDtCls);
        update FndKntCMD set FndKntCMDMyCmmnDt = myCmmnDtVal where id = FndKntCMDId;
        update FndKntCMD set FndKntCMDMyCmmnDtCls = myCmmnDtCls where id = FndKntCMDId;
    end myCmmnDtSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end FndKntCMDFacade;
/


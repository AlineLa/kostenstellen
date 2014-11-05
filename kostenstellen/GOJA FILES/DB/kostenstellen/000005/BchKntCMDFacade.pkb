create or replace package body BchKntCMDFacade is
    
    procedure chkBchKntCMD(BchKntCMDId number) is
    currentClass number;
    begin
        select Cls into currentClass from BchKntCMD where id = BchKntCMDId;
        if currentClass <> 120 then
            raise_application_error(-20000, 'Object not of right class! Required: 120 Actual: ' || currentClass);
        end if; 
    end chkBchKntCMD;
    
    function newBchKntCMD(createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select SBchKntCMD.nextVal into result from dual;
        end if;
        insert into BchKntCMD (id,Cls)
            values (result,120);
        return result;
    end newBchKntCMD;
    
    function newDelayedBchKntCMD return number is
    result number;
    begin
        select SBchKntCMD.nextVal into result from dual;
        return result;
    end newDelayedBchKntCMD;
    
    function getBchKntCMD(BchKntCMDId number) return BchKntCMDInfoColl is 
    result BchKntCMDInfoColl;
    begin
        chkBchKntCMD(BchKntCMDId);
        open result for select id,BchKntCMDInvoker,BchKntCMDInvokerCls,BchKntCMDCReceiver,BchKntCMDCReceiverCls,BchKntCMDMyCmmnDt,BchKntCMDMyCmmnDtCls from BchKntCMD
            where id = BchKntCMDId and Cls = 120;
        return result;
    end getBchKntCMD;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from BchKntCMD where id = objectId;
        return result;
    end getClass;
    procedure chkSpecBchKntCMD(BchKntCMDId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from BchKntCMD base, Specialization spec
             where base.id = BchKntCMDId and base.Cls = spec.descendant and spec.ancestor = 120;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 120 Actual: ' || currentClass);
    end chkSpecBchKntCMD;
    
    procedure invokerSet(BchKntCMDId number, invokerVal number, invokerCls number)is
    begin 
        chkSpecBchKntCMD(BchKntCMDId);
        ClassFacade.checkIfObjectExists(invokerVal, invokerCls);
        ClassFacade.checkHasAsDescendant(103, invokerCls);
        update BchKntCMD set BchKntCMDInvoker = invokerVal where id = BchKntCMDId;
        update BchKntCMD set BchKntCMDInvokerCls = invokerCls where id = BchKntCMDId;
    end invokerSet;
    
    
    procedure cReceiverSet(BchKntCMDId number, cReceiverVal number, cReceiverCls number)is
    begin 
        chkSpecBchKntCMD(BchKntCMDId);
        ClassFacade.checkIfObjectExists(cReceiverVal, cReceiverCls);
        ClassFacade.checkHasAsDescendant(112, cReceiverCls);
        update BchKntCMD set BchKntCMDCReceiver = cReceiverVal where id = BchKntCMDId;
        update BchKntCMD set BchKntCMDCReceiverCls = cReceiverCls where id = BchKntCMDId;
    end cReceiverSet;
    
    
    procedure myCmmnDtSet(BchKntCMDId number, myCmmnDtVal number, myCmmnDtCls number)is
    begin 
        chkSpecBchKntCMD(BchKntCMDId);
        ClassFacade.checkIfObjectExists(myCmmnDtVal, myCmmnDtCls);
        ClassFacade.checkHasAsDescendant(124, myCmmnDtCls);
        update BchKntCMD set BchKntCMDMyCmmnDt = myCmmnDtVal where id = BchKntCMDId;
        update BchKntCMD set BchKntCMDMyCmmnDtCls = myCmmnDtCls where id = BchKntCMDId;
    end myCmmnDtSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end BchKntCMDFacade;
/


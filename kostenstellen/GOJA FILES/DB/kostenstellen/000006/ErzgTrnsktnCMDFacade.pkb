create or replace package body ErzgTrnsktnCMDFacade is
    
    procedure chkErzgTrnsktnCMD(ErzgTrnsktnCMDId number) is
    currentClass number;
    begin
        select Cls into currentClass from ErzgTrnsktnCMD where id = ErzgTrnsktnCMDId;
        if currentClass <> 113 then
            raise_application_error(-20000, 'Object not of right class! Required: 113 Actual: ' || currentClass);
        end if; 
    end chkErzgTrnsktnCMD;
    
    function newErzgTrnsktnCMD(KntIDVal varchar2,createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select SErzgTrnsktnCMD.nextVal into result from dual;
        end if;
        insert into ErzgTrnsktnCMD (id,Cls,ErzgTrnsktnCMDKntID)
            values (result,113,KntIDVal);
        return result;
    end newErzgTrnsktnCMD;
    
    function newDelayedErzgTrnsktnCMD return number is
    result number;
    begin
        select SErzgTrnsktnCMD.nextVal into result from dual;
        return result;
    end newDelayedErzgTrnsktnCMD;
    
    function getErzgTrnsktnCMD(ErzgTrnsktnCMDId number) return ErzgTrnsktnCMDInfoColl is 
    result ErzgTrnsktnCMDInfoColl;
    begin
        chkErzgTrnsktnCMD(ErzgTrnsktnCMDId);
        open result for select id,ErzgTrnsktnCMDKntID,ErzgTrnsktnCMDInvoker,ErzgTrnsktnCMDInvokerCls,ErzgTrnsktnCMDCReceiver,ErzgTrnsktnCMDCReceiverCls,ErzgTrnsktnCMDMyCmmnDt,ErzgTrnsktnCMDMyCmmnDtCls from ErzgTrnsktnCMD
            where id = ErzgTrnsktnCMDId and Cls = 113;
        return result;
    end getErzgTrnsktnCMD;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from ErzgTrnsktnCMD where id = objectId;
        return result;
    end getClass;
    procedure chkSpecErzgTrnsktnCMD(ErzgTrnsktnCMDId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from ErzgTrnsktnCMD base, Specialization spec
             where base.id = ErzgTrnsktnCMDId and base.Cls = spec.descendant and spec.ancestor = 113;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 113 Actual: ' || currentClass);
    end chkSpecErzgTrnsktnCMD;
    
    procedure KntIDSet(ErzgTrnsktnCMDId number, KntIDVal varchar2)is
    begin 
        chkSpecErzgTrnsktnCMD(ErzgTrnsktnCMDId);
        update ErzgTrnsktnCMD set ErzgTrnsktnCMDKntID = KntIDVal where id = ErzgTrnsktnCMDId;
    end KntIDSet;
    
    
    procedure invokerSet(ErzgTrnsktnCMDId number, invokerVal number, invokerCls number)is
    begin 
        chkSpecErzgTrnsktnCMD(ErzgTrnsktnCMDId);
        ClassFacade.checkIfObjectExists(invokerVal, invokerCls);
        ClassFacade.checkHasAsDescendant(103, invokerCls);
        update ErzgTrnsktnCMD set ErzgTrnsktnCMDInvoker = invokerVal where id = ErzgTrnsktnCMDId;
        update ErzgTrnsktnCMD set ErzgTrnsktnCMDInvokerCls = invokerCls where id = ErzgTrnsktnCMDId;
    end invokerSet;
    
    
    procedure cReceiverSet(ErzgTrnsktnCMDId number, cReceiverVal number, cReceiverCls number)is
    begin 
        chkSpecErzgTrnsktnCMD(ErzgTrnsktnCMDId);
        ClassFacade.checkIfObjectExists(cReceiverVal, cReceiverCls);
        ClassFacade.checkHasAsDescendant(129, cReceiverCls);
        update ErzgTrnsktnCMD set ErzgTrnsktnCMDCReceiver = cReceiverVal where id = ErzgTrnsktnCMDId;
        update ErzgTrnsktnCMD set ErzgTrnsktnCMDCReceiverCls = cReceiverCls where id = ErzgTrnsktnCMDId;
    end cReceiverSet;
    
    
    procedure myCmmnDtSet(ErzgTrnsktnCMDId number, myCmmnDtVal number, myCmmnDtCls number)is
    begin 
        chkSpecErzgTrnsktnCMD(ErzgTrnsktnCMDId);
        ClassFacade.checkIfObjectExists(myCmmnDtVal, myCmmnDtCls);
        ClassFacade.checkHasAsDescendant(124, myCmmnDtCls);
        update ErzgTrnsktnCMD set ErzgTrnsktnCMDMyCmmnDt = myCmmnDtVal where id = ErzgTrnsktnCMDId;
        update ErzgTrnsktnCMD set ErzgTrnsktnCMDMyCmmnDtCls = myCmmnDtCls where id = ErzgTrnsktnCMDId;
    end myCmmnDtSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end ErzgTrnsktnCMDFacade;
/


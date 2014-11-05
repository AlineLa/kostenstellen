create or replace package body ErzgKntCMDFacade is
    
    procedure chkErzgKntCMD(ErzgKntCMDId number) is
    currentClass number;
    begin
        select Cls into currentClass from ErzgKntCMD where id = ErzgKntCMDId;
        if currentClass <> 119 then
            raise_application_error(-20000, 'Object not of right class! Required: 119 Actual: ' || currentClass);
        end if; 
    end chkErzgKntCMD;
    
    function newErzgKntCMD(KntIDVal varchar2,KntstndVal number,MnmmVal number,GrnzwrtVal number,createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select SErzgKntCMD.nextVal into result from dual;
        end if;
        insert into ErzgKntCMD (id,Cls,ErzgKntCMDKntID,ErzgKntCMDKntstnd,ErzgKntCMDMnmm,ErzgKntCMDGrnzwrt)
            values (result,119,KntIDVal,KntstndVal,MnmmVal,GrnzwrtVal);
        return result;
    end newErzgKntCMD;
    
    function newDelayedErzgKntCMD return number is
    result number;
    begin
        select SErzgKntCMD.nextVal into result from dual;
        return result;
    end newDelayedErzgKntCMD;
    
    function getErzgKntCMD(ErzgKntCMDId number) return ErzgKntCMDInfoColl is 
    result ErzgKntCMDInfoColl;
    begin
        chkErzgKntCMD(ErzgKntCMDId);
        open result for select id,ErzgKntCMDKntID,ErzgKntCMDKntstnd,ErzgKntCMDMnmm,ErzgKntCMDGrnzwrt,ErzgKntCMDInvoker,ErzgKntCMDInvokerCls,ErzgKntCMDCReceiver,ErzgKntCMDCReceiverCls,ErzgKntCMDMyCmmnDt,ErzgKntCMDMyCmmnDtCls from ErzgKntCMD
            where id = ErzgKntCMDId and Cls = 119;
        return result;
    end getErzgKntCMD;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from ErzgKntCMD where id = objectId;
        return result;
    end getClass;
    procedure chkSpecErzgKntCMD(ErzgKntCMDId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from ErzgKntCMD base, Specialization spec
             where base.id = ErzgKntCMDId and base.Cls = spec.descendant and spec.ancestor = 119;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: 119 Actual: ' || currentClass);
    end chkSpecErzgKntCMD;
    
    procedure KntIDSet(ErzgKntCMDId number, KntIDVal varchar2)is
    begin 
        chkSpecErzgKntCMD(ErzgKntCMDId);
        update ErzgKntCMD set ErzgKntCMDKntID = KntIDVal where id = ErzgKntCMDId;
    end KntIDSet;
    
    
    procedure KntstndSet(ErzgKntCMDId number, KntstndVal number)is
    begin 
        chkSpecErzgKntCMD(ErzgKntCMDId);
        update ErzgKntCMD set ErzgKntCMDKntstnd = KntstndVal where id = ErzgKntCMDId;
    end KntstndSet;
    
    
    procedure MnmmSet(ErzgKntCMDId number, MnmmVal number)is
    begin 
        chkSpecErzgKntCMD(ErzgKntCMDId);
        update ErzgKntCMD set ErzgKntCMDMnmm = MnmmVal where id = ErzgKntCMDId;
    end MnmmSet;
    
    
    procedure GrnzwrtSet(ErzgKntCMDId number, GrnzwrtVal number)is
    begin 
        chkSpecErzgKntCMD(ErzgKntCMDId);
        update ErzgKntCMD set ErzgKntCMDGrnzwrt = GrnzwrtVal where id = ErzgKntCMDId;
    end GrnzwrtSet;
    
    
    procedure invokerSet(ErzgKntCMDId number, invokerVal number, invokerCls number)is
    begin 
        chkSpecErzgKntCMD(ErzgKntCMDId);
        ClassFacade.checkIfObjectExists(invokerVal, invokerCls);
        ClassFacade.checkHasAsDescendant(103, invokerCls);
        update ErzgKntCMD set ErzgKntCMDInvoker = invokerVal where id = ErzgKntCMDId;
        update ErzgKntCMD set ErzgKntCMDInvokerCls = invokerCls where id = ErzgKntCMDId;
    end invokerSet;
    
    
    procedure cReceiverSet(ErzgKntCMDId number, cReceiverVal number, cReceiverCls number)is
    begin 
        chkSpecErzgKntCMD(ErzgKntCMDId);
        ClassFacade.checkIfObjectExists(cReceiverVal, cReceiverCls);
        ClassFacade.checkHasAsDescendant(127, cReceiverCls);
        update ErzgKntCMD set ErzgKntCMDCReceiver = cReceiverVal where id = ErzgKntCMDId;
        update ErzgKntCMD set ErzgKntCMDCReceiverCls = cReceiverCls where id = ErzgKntCMDId;
    end cReceiverSet;
    
    
    procedure myCmmnDtSet(ErzgKntCMDId number, myCmmnDtVal number, myCmmnDtCls number)is
    begin 
        chkSpecErzgKntCMD(ErzgKntCMDId);
        ClassFacade.checkIfObjectExists(myCmmnDtVal, myCmmnDtCls);
        ClassFacade.checkHasAsDescendant(124, myCmmnDtCls);
        update ErzgKntCMD set ErzgKntCMDMyCmmnDt = myCmmnDtVal where id = ErzgKntCMDId;
        update ErzgKntCMD set ErzgKntCMDMyCmmnDtCls = myCmmnDtCls where id = ErzgKntCMDId;
    end myCmmnDtSet;
    
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end ErzgKntCMDFacade;
/


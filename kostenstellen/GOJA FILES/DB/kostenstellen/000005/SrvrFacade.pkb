create or replace package body SrvrFacade is
    
    procedure chkSrvr(SrvrId number) is
    currentClass number;
    begin
        select Cls into currentClass from Srvr where id = SrvrId;
        if currentClass <> -117 then
            raise_application_error(-20000, 'Object not of right class! Required: -117 Actual: ' || currentClass);
        end if; 
    end chkSrvr;
    
    function newSrvr(passwordVal varchar2,userVal varchar2,hackCountVal number,hackDelayVal Timestamp,createMinusStorePlus number) return number is
    result number;
    begin
        if createMinusStorePlus >  0 then
            result := createMinusStorePlus;
        else
            select SSrvr.nextVal into result from dual;
        end if;
        insert into Srvr (id,Cls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay)
            values (result,-117,passwordVal,userVal,hackCountVal,hackDelayVal);
        return result;
    end newSrvr;
    
    function newDelayedSrvr return number is
    result number;
    begin
        select SSrvr.nextVal into result from dual;
        return result;
    end newDelayedSrvr;
    
    function getSrvr(SrvrId number) return SrvrInfoColl is 
    result SrvrInfoColl;
    begin
        chkSrvr(SrvrId);
        open result for select id,SrvrArtn,SrvrArtnCls,SrvrMngr,SrvrMngrCls,SrvrTrnsktnMngr,SrvrTrnsktnMngrCls,SrvrSbSrvc,SrvrSbSrvcCls,SrvrThis,SrvrThisCls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay from Srvr
            where id = SrvrId and Cls = -117;
        return result;
    end getSrvr;
    
    function getClass(objectId number) return number is 
    result number;
    begin
        select Cls into result from Srvr where id = objectId;
        return result;
    end getClass;
    procedure chkSpecSrvr(SrvrId number) is
    currentClass number;
    begin
        select base.Cls into currentClass from Srvr base, Specialization spec
             where base.id = SrvrId and base.Cls = spec.descendant and spec.ancestor = -117;
    exception
        when no_data_found then
            raise_application_error(-20000, 'Object not of right class! Required specialization of: -117 Actual: ' || currentClass);
    end chkSpecSrvr;
    
    function getSrvrByUser(user varchar2) return SrvrFacade.SrvrAllColl is 
    result SrvrFacade.SrvrAllColl;
    begin
        open result for select id,Cls,SrvrArtn,SrvrArtnCls,SrvrMngr,SrvrMngrCls,SrvrTrnsktnMngr,SrvrTrnsktnMngrCls,SrvrSbSrvc,SrvrSbSrvcCls,SrvrThis,SrvrThisCls,SrvrPassword,SrvrUser,SrvrHackCount,SrvrHackDelay from Srvr where SrvrUser like user and (id,Cls) not in (select * from DeletedObjects);
        return result;
    end getSrvrByUser;
    
    procedure artnSet(SrvrId number, artnVal number, artnCls number)is
    begin 
        chkSpecSrvr(SrvrId);
        ClassFacade.checkIfObjectExists(artnVal, artnCls);
        ClassFacade.checkHasAsDescendant(121, artnCls);
        update Srvr set SrvrArtn = artnVal where id = SrvrId;
        update Srvr set SrvrArtnCls = artnCls where id = SrvrId;
    end artnSet;
    
    
    procedure mngrSet(SrvrId number, mngrVal number, mngrCls number)is
    begin 
        chkSpecSrvr(SrvrId);
        ClassFacade.checkIfObjectExists(mngrVal, mngrCls);
        ClassFacade.checkHasAsDescendant(127, mngrCls);
        update Srvr set SrvrMngr = mngrVal where id = SrvrId;
        update Srvr set SrvrMngrCls = mngrCls where id = SrvrId;
    end mngrSet;
    
    
    procedure trnsktnMngrSet(SrvrId number, trnsktnMngrVal number, trnsktnMngrCls number)is
    begin 
        chkSpecSrvr(SrvrId);
        ClassFacade.checkIfObjectExists(trnsktnMngrVal, trnsktnMngrCls);
        ClassFacade.checkHasAsDescendant(129, trnsktnMngrCls);
        update Srvr set SrvrTrnsktnMngr = trnsktnMngrVal where id = SrvrId;
        update Srvr set SrvrTrnsktnMngrCls = trnsktnMngrCls where id = SrvrId;
    end trnsktnMngrSet;
    
    
    procedure sbSrvcSet(SrvrId number, sbSrvcVal number, sbSrvcCls number)is
    begin 
        chkSpecSrvr(SrvrId);
        ClassFacade.checkIfObjectExists(sbSrvcVal, sbSrvcCls);
        ClassFacade.checkHasAsDescendant(136, sbSrvcCls);
        update Srvr set SrvrSbSrvc = sbSrvcVal where id = SrvrId;
        update Srvr set SrvrSbSrvcCls = sbSrvcCls where id = SrvrId;
    end sbSrvcSet;
    
    
    procedure ThisSet(SrvrId number, ThisVal number, ThisCls number)is
    begin 
        chkSpecSrvr(SrvrId);
        ClassFacade.checkIfObjectExists(ThisVal, ThisCls);
        ClassFacade.checkHasAsDescendant(-117, ThisCls);
        update Srvr set SrvrThis = ThisVal where id = SrvrId;
        update Srvr set SrvrThisCls = ThisCls where id = SrvrId;
    end ThisSet;
    
    
    procedure passwordSet(SrvrId number, passwordVal varchar2)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrPassword = passwordVal where id = SrvrId;
    end passwordSet;
    
    
    procedure userSet(SrvrId number, userVal varchar2)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrUser = userVal where id = SrvrId;
    end userSet;
    
    
    procedure hackCountSet(SrvrId number, hackCountVal number)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrHackCount = hackCountVal where id = SrvrId;
    end hackCountSet;
    
    
    procedure hackDelaySet(SrvrId number, hackDelayVal Timestamp)is
    begin 
        chkSpecSrvr(SrvrId);
        update Srvr set SrvrHackDelay = hackDelayVal where id = SrvrId;
    end hackDelaySet;
    
    
    function iGetMngr(objectId number, classId number) return ClassFacade.ObjectThisInfoCollection is
    rslt ClassFacade.ObjectThisInfoCollection;
    begin
        open rslt for select id, Cls, SrvrThis, SrvrThisCls from Srvr where SrvrMngr = objectid and SrvrMngrCls = classId  and (id,Cls) not in (select * from DeletedObjects);
        return rslt;
    end iGetMngr;
    
    function iGetTrnsktnMngr(objectId number, classId number) return ClassFacade.ObjectThisInfoCollection is
    rslt ClassFacade.ObjectThisInfoCollection;
    begin
        open rslt for select id, Cls, SrvrThis, SrvrThisCls from Srvr where SrvrTrnsktnMngr = objectid and SrvrTrnsktnMngrCls = classId  and (id,Cls) not in (select * from DeletedObjects);
        return rslt;
    end iGetTrnsktnMngr;
    
    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
end SrvrFacade;
/


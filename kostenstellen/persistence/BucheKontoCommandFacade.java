package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class BucheKontoCommandFacade{

	private String schemaName;
	private Connection con;

	public BucheKontoCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentBucheKontoCommand newBucheKontoCommand(long createMinusStorePlus) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BchKntCMDFacade.newBchKntCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BucheKontoCommand result = new BucheKontoCommand(null,null,null,id);
            if (createMinusStorePlus < 0)Cache.getTheCache().put(result);
            return (PersistentBucheKontoCommand)PersistentProxi.createProxi(id, 120);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentBucheKontoCommand newDelayedBucheKontoCommand() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".BchKntCMDFacade.newDelayedBchKntCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            BucheKontoCommand result = new BucheKontoCommand(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentBucheKontoCommand)PersistentProxi.createProxi(id, 120);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BucheKontoCommand getBucheKontoCommand(long BucheKontoCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BchKntCMDFacade.getBchKntCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, BucheKontoCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(2) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentTransaktion commandReceiver = null;
            if (obj.getLong(4) != 0)
                commandReceiver = (PersistentTransaktion)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(6) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            BucheKontoCommand result = new BucheKontoCommand(invoker,
                                                             commandReceiver,
                                                             myCommonDate,
                                                             BucheKontoCommandId);
            obj.close();
            callable.close();
            BucheKontoCommandICProxi inCache = (BucheKontoCommandICProxi)Cache.getTheCache().put(result);
            BucheKontoCommand objectInCache = (BucheKontoCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BchKntCMDFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long BucheKontoCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BchKntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, BucheKontoCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long BucheKontoCommandId, PersistentTransaktion commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BchKntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, BucheKontoCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long BucheKontoCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".BchKntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, BucheKontoCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


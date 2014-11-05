package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ErzeugeKontoCommandFacade{

	private String schemaName;
	private Connection con;

	public ErzeugeKontoCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentErzeugeKontoCommand newErzeugeKontoCommand(String KontoID,long Kontostand,long Minimum,long Grenzwert,long createMinusStorePlus) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ErzgKntCMDFacade.newErzgKntCMD(?,?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, KontoID);
            callable.setLong(3, Kontostand);
            callable.setLong(4, Minimum);
            callable.setLong(5, Grenzwert);
            callable.setLong(6, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ErzeugeKontoCommand result = new ErzeugeKontoCommand(KontoID,Kontostand,Minimum,Grenzwert,null,null,null,id);
            if (createMinusStorePlus < 0)Cache.getTheCache().put(result);
            return (PersistentErzeugeKontoCommand)PersistentProxi.createProxi(id, 119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentErzeugeKontoCommand newDelayedErzeugeKontoCommand(String KontoID,long Kontostand,long Minimum,long Grenzwert) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ErzgKntCMDFacade.newDelayedErzgKntCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ErzeugeKontoCommand result = new ErzeugeKontoCommand(KontoID,Kontostand,Minimum,Grenzwert,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentErzeugeKontoCommand)PersistentProxi.createProxi(id, 119);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ErzeugeKontoCommand getErzeugeKontoCommand(long ErzeugeKontoCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ErzgKntCMDFacade.getErzgKntCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ErzeugeKontoCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(6) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentKontoFcd commandReceiver = null;
            if (obj.getLong(8) != 0)
                commandReceiver = (PersistentKontoFcd)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(10) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            ErzeugeKontoCommand result = new ErzeugeKontoCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                 obj.getLong(3),
                                                                 obj.getLong(4),
                                                                 obj.getLong(5),
                                                                 invoker,
                                                                 commandReceiver,
                                                                 myCommonDate,
                                                                 ErzeugeKontoCommandId);
            obj.close();
            callable.close();
            ErzeugeKontoCommandICProxi inCache = (ErzeugeKontoCommandICProxi)Cache.getTheCache().put(result);
            ErzeugeKontoCommand objectInCache = (ErzeugeKontoCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ErzgKntCMDFacade.getClass(?); end;");
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
    public void KontoIDSet(long ErzeugeKontoCommandId, String KontoIDVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgKntCMDFacade.KntIDSet(?, ?); end;");
            callable.setLong(1, ErzeugeKontoCommandId);
            callable.setString(2, KontoIDVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void KontostandSet(long ErzeugeKontoCommandId, long KontostandVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgKntCMDFacade.KntstndSet(?, ?); end;");
            callable.setLong(1, ErzeugeKontoCommandId);
            callable.setLong(2, KontostandVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void MinimumSet(long ErzeugeKontoCommandId, long MinimumVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgKntCMDFacade.MnmmSet(?, ?); end;");
            callable.setLong(1, ErzeugeKontoCommandId);
            callable.setLong(2, MinimumVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void GrenzwertSet(long ErzeugeKontoCommandId, long GrenzwertVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgKntCMDFacade.GrnzwrtSet(?, ?); end;");
            callable.setLong(1, ErzeugeKontoCommandId);
            callable.setLong(2, GrenzwertVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ErzeugeKontoCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgKntCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ErzeugeKontoCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ErzeugeKontoCommandId, PersistentKontoFcd commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgKntCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ErzeugeKontoCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ErzeugeKontoCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgKntCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ErzeugeKontoCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ErzeugeTransaktionCommandFacade{

	private String schemaName;
	private Connection con;

	public ErzeugeTransaktionCommandFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentErzeugeTransaktionCommand newErzeugeTransaktionCommand(String KontoID,long createMinusStorePlus) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ErzgTrnsktnCMDFacade.newErzgTrnsktnCMD(?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, KontoID);
            callable.setLong(3, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ErzeugeTransaktionCommand result = new ErzeugeTransaktionCommand(KontoID,null,null,null,id);
            if (createMinusStorePlus < 0)Cache.getTheCache().put(result);
            return (PersistentErzeugeTransaktionCommand)PersistentProxi.createProxi(id, 113);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentErzeugeTransaktionCommand newDelayedErzeugeTransaktionCommand(String KontoID) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ErzgTrnsktnCMDFacade.newDelayedErzgTrnsktnCMD(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ErzeugeTransaktionCommand result = new ErzeugeTransaktionCommand(KontoID,null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentErzeugeTransaktionCommand)PersistentProxi.createProxi(id, 113);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ErzeugeTransaktionCommand getErzeugeTransaktionCommand(long ErzeugeTransaktionCommandId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ErzgTrnsktnCMDFacade.getErzgTrnsktnCMD(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ErzeugeTransaktionCommandId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            Invoker invoker = null;
            if (obj.getLong(3) != 0)
                invoker = (Invoker)PersistentProxi.createProxi(obj.getLong(3), obj.getLong(4));
            PersistentTransFacde commandReceiver = null;
            if (obj.getLong(5) != 0)
                commandReceiver = (PersistentTransFacde)PersistentProxi.createProxi(obj.getLong(5), obj.getLong(6));
            PersistentCommonDate myCommonDate = null;
            if (obj.getLong(7) != 0)
                myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(obj.getLong(7), obj.getLong(8));
            ErzeugeTransaktionCommand result = new ErzeugeTransaktionCommand(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                                                             invoker,
                                                                             commandReceiver,
                                                                             myCommonDate,
                                                                             ErzeugeTransaktionCommandId);
            obj.close();
            callable.close();
            ErzeugeTransaktionCommandICProxi inCache = (ErzeugeTransaktionCommandICProxi)Cache.getTheCache().put(result);
            ErzeugeTransaktionCommand objectInCache = (ErzeugeTransaktionCommand)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ErzgTrnsktnCMDFacade.getClass(?); end;");
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
    public void KontoIDSet(long ErzeugeTransaktionCommandId, String KontoIDVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgTrnsktnCMDFacade.KntIDSet(?, ?); end;");
            callable.setLong(1, ErzeugeTransaktionCommandId);
            callable.setString(2, KontoIDVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void invokerSet(long ErzeugeTransaktionCommandId, Invoker invokerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgTrnsktnCMDFacade.invokerSet(?, ?, ?); end;");
            callable.setLong(1, ErzeugeTransaktionCommandId);
            callable.setLong(2, invokerVal.getId());
            callable.setLong(3, invokerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commandReceiverSet(long ErzeugeTransaktionCommandId, PersistentTransFacde commandReceiverVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgTrnsktnCMDFacade.cReceiverSet(?, ?, ?); end;");
            callable.setLong(1, ErzeugeTransaktionCommandId);
            callable.setLong(2, commandReceiverVal.getId());
            callable.setLong(3, commandReceiverVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void myCommonDateSet(long ErzeugeTransaktionCommandId, PersistentCommonDate myCommonDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ErzgTrnsktnCMDFacade.myCmmnDtSet(?, ?, ?); end;");
            callable.setLong(1, ErzeugeTransaktionCommandId);
            callable.setLong(2, myCommonDateVal.getId());
            callable.setLong(3, myCommonDateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


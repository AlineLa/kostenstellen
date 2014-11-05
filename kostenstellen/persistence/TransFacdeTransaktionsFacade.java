package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class TransFacdeTransaktionsFacade{

	private String schemaName;
	private Connection con;

	public TransFacdeTransaktionsFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentTransFacdeTransaktions newTransFacdeTransaktions(long createMinusStorePlus) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsFcdTrnsktnsFacade.newTrnsFcdTrnsktns(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            TransFacdeTransaktions result = new TransFacdeTransaktions(null,null,id);
            if (createMinusStorePlus < 0)Cache.getTheCache().put(result);
            return (PersistentTransFacdeTransaktions)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentTransFacdeTransaktions newDelayedTransFacdeTransaktions() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsFcdTrnsktnsFacade.newDelayedTrnsFcdTrnsktns(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            TransFacdeTransaktions result = new TransFacdeTransaktions(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentTransFacdeTransaktions)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TransFacdeTransaktions getTransFacdeTransaktions(long TransFacdeTransaktionsId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsFcdTrnsktnsFacade.getTrnsFcdTrnsktns(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TransFacdeTransaktionsId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentTransFacde observer = null;
            if (obj.getLong(2) != 0)
                observer = (PersistentTransFacde)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentTransFacdeTransaktions This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentTransFacdeTransaktions)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            TransFacdeTransaktions result = new TransFacdeTransaktions(observer,
                                                                       This,
                                                                       TransFacdeTransaktionsId);
            obj.close();
            callable.close();
            TransFacdeTransaktionsICProxi inCache = (TransFacdeTransaktionsICProxi)Cache.getTheCache().put(result);
            TransFacdeTransaktions objectInCache = (TransFacdeTransaktions)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsFcdTrnsktnsFacade.getClass(?); end;");
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
    public void observerSet(long TransFacdeTransaktionsId, PersistentTransFacde observerVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsFcdTrnsktnsFacade.mstrSet(?, ?, ?); end;");
            callable.setLong(1, TransFacdeTransaktionsId);
            callable.setLong(2, observerVal.getId());
            callable.setLong(3, observerVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long observeeAdd(long TransFacdeTransaktionsId, PersistentTransaktion observeeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsFcdTrnsktnsFacade.obsAdd(?, ?, ?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, TransFacdeTransaktionsId);
            callable.setLong(3, observeeVal.getId());
            callable.setLong(4, observeeVal.getClassId());
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void observeeRem(long observeeId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsFcdTrnsktnsFacade.obsRem(?); end;");
            callable.setLong(1, observeeId);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public TransaktionList observeeGet(long TransFacdeTransaktionsId) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsFcdTrnsktnsFacade.obsGet(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TransFacdeTransaktionsId);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            TransaktionList result = new TransaktionList();
            while (list.next()) {
                result.add((PersistentTransaktion)PersistentProxi.createListEntryProxi(list.getLong(1), list.getLong(2), list.getLong(3)));
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long TransFacdeTransaktionsId, PersistentTransFacdeTransaktions ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsFcdTrnsktnsFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, TransFacdeTransaktionsId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class TransferFacade{

	private String schemaName;
	private Connection con;

	public TransferFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentTransfer newTransfer(long Summe,String KontoID,long createMinusStorePlus) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newTrnsfr(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, Summe);
            callable.setString(3, KontoID);
            callable.setLong(4, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(null,null,Summe,KontoID,null,null,id);
            if (createMinusStorePlus < 0)Cache.getTheCache().put(result);
            return (PersistentTransfer)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentTransfer newDelayedTransfer(long Summe,String KontoID) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.newDelayedTrnsfr(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Transfer result = new Transfer(null,null,Summe,KontoID,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentTransfer)PersistentProxi.createProxi(id, 118);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Transfer getTransfer(long TransferId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.getTrnsfr(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TransferId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentKonto vonKonto = null;
            if (obj.getLong(2) != 0)
                vonKonto = (PersistentKonto)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentKonto zuKonto = null;
            if (obj.getLong(4) != 0)
                zuKonto = (PersistentKonto)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            SubjInterface subService = null;
            if (obj.getLong(8) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            PersistentTransfer This = null;
            if (obj.getLong(10) != 0)
                This = (PersistentTransfer)PersistentProxi.createProxi(obj.getLong(10), obj.getLong(11));
            Transfer result = new Transfer(vonKonto,
                                           zuKonto,
                                           obj.getLong(6),
                                           obj.getString(7) == null ? "" : obj.getString(7) /* In Oracle "" = null !!! */,
                                           subService,
                                           This,
                                           TransferId);
            obj.close();
            callable.close();
            TransferICProxi inCache = (TransferICProxi)Cache.getTheCache().put(result);
            Transfer objectInCache = (Transfer)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TrnsfrFacade.getClass(?); end;");
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
    public void vonKontoSet(long TransferId, PersistentKonto vonKontoVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.vnKntSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, vonKontoVal.getId());
            callable.setLong(3, vonKontoVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void zuKontoSet(long TransferId, PersistentKonto zuKontoVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.zKntSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, zuKontoVal.getId());
            callable.setLong(3, zuKontoVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void SummeSet(long TransferId, long SummeVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.SmmSet(?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, SummeVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void KontoIDSet(long TransferId, String KontoIDVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.KntIDSet(?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setString(2, KontoIDVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long TransferId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long TransferId, PersistentTransfer ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".TrnsfrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, TransferId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


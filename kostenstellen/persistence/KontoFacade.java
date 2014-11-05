package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class KontoFacade{

	private String schemaName;
	private Connection con;

	public KontoFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentKonto newKonto(String KontoID,long Grenzwert,long Kontostand,long Minimum,long createMinusStorePlus) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".KntFacade.newKnt(?,?,?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, KontoID);
            callable.setLong(3, Grenzwert);
            callable.setLong(4, Kontostand);
            callable.setLong(5, Minimum);
            callable.setLong(6, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Konto result = new Konto(KontoID,Grenzwert,Kontostand,Minimum,null,null,id);
            if (createMinusStorePlus < 0)Cache.getTheCache().put(result);
            return (PersistentKonto)PersistentProxi.createProxi(id, 126);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentKonto newDelayedKonto(String KontoID,long Grenzwert,long Kontostand,long Minimum) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".KntFacade.newDelayedKnt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Konto result = new Konto(KontoID,Grenzwert,Kontostand,Minimum,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentKonto)PersistentProxi.createProxi(id, 126);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Konto getKonto(long KontoId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".KntFacade.getKnt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, KontoId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(6) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            PersistentKonto This = null;
            if (obj.getLong(8) != 0)
                This = (PersistentKonto)PersistentProxi.createProxi(obj.getLong(8), obj.getLong(9));
            Konto result = new Konto(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                     obj.getLong(3),
                                     obj.getLong(4),
                                     obj.getLong(5),
                                     subService,
                                     This,
                                     KontoId);
            obj.close();
            callable.close();
            KontoICProxi inCache = (KontoICProxi)Cache.getTheCache().put(result);
            Konto objectInCache = (Konto)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".KntFacade.getClass(?); end;");
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
    public KontoSearchList getKontoByKontoID(String KontoID) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".KntFacade.getKntByKntID(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setString(2, KontoID);
            callable.execute();
            ResultSet list = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            KontoSearchList result = new KontoSearchList();
            while (list.next()) {
                long classId = list.getLong(2);
                long objectId = list.getLong(1);
                PersistentKonto proxi = (PersistentKonto)PersistentProxi.createProxi(objectId, classId);
                result.add(proxi);
            }
            list.close();
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void KontoIDSet(long KontoId, String KontoIDVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KntFacade.KntIDSet(?, ?); end;");
            callable.setLong(1, KontoId);
            callable.setString(2, KontoIDVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void GrenzwertSet(long KontoId, long GrenzwertVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KntFacade.GrnzwrtSet(?, ?); end;");
            callable.setLong(1, KontoId);
            callable.setLong(2, GrenzwertVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void KontostandSet(long KontoId, long KontostandVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KntFacade.KntstndSet(?, ?); end;");
            callable.setLong(1, KontoId);
            callable.setLong(2, KontostandVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void MinimumSet(long KontoId, long MinimumVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KntFacade.MnmmSet(?, ?); end;");
            callable.setLong(1, KontoId);
            callable.setLong(2, MinimumVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long KontoId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KntFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, KontoId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long KontoId, PersistentKonto ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KntFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, KontoId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


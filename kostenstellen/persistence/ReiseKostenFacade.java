package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ReiseKostenFacade{

	private String schemaName;
	private Connection con;

	public ReiseKostenFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentReiseKosten getTheReiseKosten() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RsKstnFacade.getTheRsKstn; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentReiseKosten)PersistentProxi.createProxi(id, 122);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ReiseKosten getReiseKosten(long ReiseKostenId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".RsKstnFacade.getRsKstn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ReiseKostenId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentAbstrakteKostenArt This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentAbstrakteKostenArt)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAbstrakteKostenArt speziellerAls = null;
            if (obj.getLong(6) != 0)
                speziellerAls = (PersistentAbstrakteKostenArt)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            ReiseKosten result = new ReiseKosten(subService,
                                                 This,
                                                 speziellerAls,
                                                 ReiseKostenId);
            obj.close();
            callable.close();
            ReiseKostenICProxi inCache = (ReiseKostenICProxi)Cache.getTheCache().put(result);
            ReiseKosten objectInCache = (ReiseKosten)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


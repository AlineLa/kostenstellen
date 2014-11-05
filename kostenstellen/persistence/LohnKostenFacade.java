package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class LohnKostenFacade{

	private String schemaName;
	private Connection con;

	public LohnKostenFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentLohnKosten getTheLohnKosten() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LhnKstnFacade.getTheLhnKstn; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentLohnKosten)PersistentProxi.createProxi(id, 130);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public LohnKosten getLohnKosten(long LohnKostenId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".LhnKstnFacade.getLhnKstn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, LohnKostenId);
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
            LohnKosten result = new LohnKosten(subService,
                                               This,
                                               speziellerAls,
                                               LohnKostenId);
            obj.close();
            callable.close();
            LohnKostenICProxi inCache = (LohnKostenICProxi)Cache.getTheCache().put(result);
            LohnKosten objectInCache = (LohnKosten)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


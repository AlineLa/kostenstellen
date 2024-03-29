package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class AllgemeineKostenFacade{

	private String schemaName;
	private Connection con;

	public AllgemeineKostenFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentAllgemeineKosten getTheAllgemeineKosten() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AllgmnKstnFacade.getTheAllgmnKstn; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentAllgemeineKosten)PersistentProxi.createProxi(id, 115);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public AllgemeineKosten getAllgemeineKosten(long AllgemeineKostenId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".AllgmnKstnFacade.getAllgmnKstn(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, AllgemeineKostenId);
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
            AllgemeineKosten result = new AllgemeineKosten(subService,
                                                           This,
                                                           speziellerAls,
                                                           AllgemeineKostenId);
            obj.close();
            callable.close();
            AllgemeineKostenICProxi inCache = (AllgemeineKostenICProxi)Cache.getTheCache().put(result);
            AllgemeineKosten objectInCache = (AllgemeineKosten)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class KostenArtWurzelFacade{

	private String schemaName;
	private Connection con;

	public KostenArtWurzelFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentKostenArtWurzel getTheKostenArtWurzel() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".KstnArtWrzlFacade.getTheKstnArtWrzl; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentKostenArtWurzel)PersistentProxi.createProxi(id, 128);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public KostenArtWurzel getKostenArtWurzel(long KostenArtWurzelId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".KstnArtWrzlFacade.getKstnArtWrzl(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, KostenArtWurzelId);
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
            KostenArtWurzel result = new KostenArtWurzel(subService,
                                                         This,
                                                         KostenArtWurzelId);
            obj.close();
            callable.close();
            KostenArtWurzelICProxi inCache = (KostenArtWurzelICProxi)Cache.getTheCache().put(result);
            KostenArtWurzel objectInCache = (KostenArtWurzel)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


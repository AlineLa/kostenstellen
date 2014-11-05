package persistence;



import java.sql.*;
//import oracle.jdbc.*;

public class KonkreteKostenArtFacade{

	private String schemaName;
	private Connection con;

	public KonkreteKostenArtFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public void speziellerAlsSet(long KonkreteKostenArtId, PersistentAbstrakteKostenArt speziellerAlsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".KnkrKstnArtFacade.spzllrAlsSet(?, ?, ?); end;");
            callable.setLong(1, KonkreteKostenArtId);
            callable.setLong(2, speziellerAlsVal.getId());
            callable.setLong(3, speziellerAlsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


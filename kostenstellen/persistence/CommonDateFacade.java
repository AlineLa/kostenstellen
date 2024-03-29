package persistence;

import model.meta.*;

import java.sql.*;
//import oracle.jdbc.*;

public class CommonDateFacade{

	private String schemaName;
	private Connection con;

	public CommonDateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentCommonDate newCommonDate(java.sql.Date createDate,java.sql.Date commitDate,long createMinusStorePlus) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmnDtFacade.newCmmnDt(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setDate(2, createDate);
            callable.setDate(3, commitDate);
            callable.setLong(4, createMinusStorePlus);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CommonDate result = new CommonDate(createDate,commitDate,id);
            if (createMinusStorePlus < 0)Cache.getTheCache().put(result);
            return (PersistentCommonDate)PersistentProxi.createProxi(id, 124);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentCommonDate newDelayedCommonDate(java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmnDtFacade.newDelayedCmmnDt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            CommonDate result = new CommonDate(createDate,commitDate,id);
            Cache.getTheCache().put(result);
            return (PersistentCommonDate)PersistentProxi.createProxi(id, 124);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public CommonDate getCommonDate(long CommonDateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmnDtFacade.getCmmnDt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, CommonDateId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            CommonDate result = new CommonDate(obj.getDate(2),
                                               obj.getDate(3),
                                               CommonDateId);
            obj.close();
            callable.close();
            CommonDateICProxi inCache = (CommonDateICProxi)Cache.getTheCache().put(result);
            CommonDate objectInCache = (CommonDate)inCache.getTheObject();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".CmmnDtFacade.getClass(?); end;");
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
    public void createDateSet(long CommonDateId, java.sql.Date createDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmmnDtFacade.crtdtSet(?, ?); end;");
            callable.setLong(1, CommonDateId);
            callable.setDate(2, createDateVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void commitDateSet(long CommonDateId, java.sql.Date commitDateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".CmmnDtFacade.cmmtdtSet(?, ?); end;");
            callable.setLong(1, CommonDateId);
            callable.setDate(2, commitDateVal);
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}


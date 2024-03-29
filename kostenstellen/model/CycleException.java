
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public class CycleException extends model.UserException{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public CycleException(String message) throws persistence.PersistenceException {
        super(message);        
    }
    
    static public long getTypeId() {
        return -106;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(UserExceptionVisitor visitor) throws PersistenceException {
        visitor.handleCycleException(this);
    }
    public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCycleException(this);
    }
    public <E extends model.UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCycleException(this);
    }
    public <R, E extends model.UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCycleException(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

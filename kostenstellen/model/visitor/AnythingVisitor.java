
package model.visitor;

import persistence.*;

public interface AnythingVisitor {
    
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
}
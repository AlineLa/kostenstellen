
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> {
    
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    
}
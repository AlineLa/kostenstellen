
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> {
    
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
}


package model.visitor;

import persistence.*;

public interface ObsInterfaceVisitor {
    
    public void handleTransFacdeTransaktions(PersistentTransFacdeTransaktions transFacdeTransaktions) throws PersistenceException;
    
}

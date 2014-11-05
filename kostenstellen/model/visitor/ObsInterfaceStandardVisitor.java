
package model.visitor;

import persistence.*;

public abstract class ObsInterfaceStandardVisitor implements ObsInterfaceVisitor {
    
    public void handleTransFacdeTransaktions(PersistentTransFacdeTransaktions transFacdeTransaktions) throws PersistenceException{
        this.standardHandling(transFacdeTransaktions);
    }
    protected abstract void standardHandling(ObsInterface obsInterface) throws PersistenceException;
}

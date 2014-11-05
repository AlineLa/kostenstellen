
package model.visitor;

import persistence.*;

public abstract class UserExceptionStandardVisitor implements UserExceptionVisitor {
    
    public void handleMinimumException(model.MinimumException minimumException) throws PersistenceException{
        this.standardHandling(minimumException);
    }
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException{
        this.standardHandling(cycleException);
    }
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException{
        this.standardHandling(restrictionException);
    }
    public void handleDoubleDefinition(model.DoubleDefinition doubleDefinition) throws PersistenceException{
        this.standardHandling(doubleDefinition);
    }
    protected abstract void standardHandling(model.UserException userException) throws PersistenceException;
}

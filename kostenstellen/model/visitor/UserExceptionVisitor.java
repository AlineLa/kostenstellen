
package model.visitor;

import persistence.*;

public interface UserExceptionVisitor {
    
    public void handleMinimumException(model.MinimumException minimumException) throws PersistenceException;
    public void handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public void handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public void handleDoubleDefinition(model.DoubleDefinition doubleDefinition) throws PersistenceException;
    
}

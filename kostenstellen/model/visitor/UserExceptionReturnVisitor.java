
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleMinimumException(model.MinimumException minimumException) throws PersistenceException;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleDoubleDefinition(model.DoubleDefinition doubleDefinition) throws PersistenceException;
    
}

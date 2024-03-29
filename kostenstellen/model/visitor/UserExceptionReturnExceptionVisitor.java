
package model.visitor;

import persistence.*;

public interface UserExceptionReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleMinimumException(model.MinimumException minimumException) throws PersistenceException, E;
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException, E;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException, E;
    public R handleDoubleDefinition(model.DoubleDefinition doubleDefinition) throws PersistenceException, E;
    
}

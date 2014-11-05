
package view.visitor;

import view.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleMinimumException(MinimumException minimumException) throws ModelException;
    public R handleCycleException(CycleException cycleException) throws ModelException;
    public R handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public R handleDoubleDefinition(DoubleDefinition doubleDefinition) throws ModelException;
    
}

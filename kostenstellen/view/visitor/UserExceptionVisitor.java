
package view.visitor;

import view.*;

public interface UserExceptionVisitor {
    
    public void handleMinimumException(MinimumException minimumException) throws ModelException;
    public void handleCycleException(CycleException cycleException) throws ModelException;
    public void handleRestrictionException(RestrictionException restrictionException) throws ModelException;
    public void handleDoubleDefinition(DoubleDefinition doubleDefinition) throws ModelException;
    
}

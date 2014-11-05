
package model.visitor;

import persistence.*;

public interface TransaktionCommandReturnVisitor<R> {
    
    public R handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException;
    
}

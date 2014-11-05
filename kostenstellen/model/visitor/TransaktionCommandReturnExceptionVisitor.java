
package model.visitor;

import persistence.*;

public interface TransaktionCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException, E;
    
}

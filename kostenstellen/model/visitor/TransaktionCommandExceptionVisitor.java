
package model.visitor;

import persistence.*;

public interface TransaktionCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException, E;
    
}


package model.visitor;

import persistence.*;

public interface TransaktionCommandVisitor {
    
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException;
    
}

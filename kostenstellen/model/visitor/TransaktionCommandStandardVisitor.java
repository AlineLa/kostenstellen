
package model.visitor;

import persistence.*;

public abstract class TransaktionCommandStandardVisitor implements TransaktionCommandVisitor {
    
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException{
        this.standardHandling(bucheKontoCommand);
    }
    protected abstract void standardHandling(TransaktionCommand transaktionCommand) throws PersistenceException;
}

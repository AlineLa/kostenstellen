
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException{
        this.standardHandling(erzeugeKontoCommand);
    }
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException{
        this.standardHandling(bucheKontoCommand);
    }
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException{
        this.standardHandling(erzeugeTransaktionCommand);
    }
    public void handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException{
        this.standardHandling(findeKontoCommand);
    }
    protected abstract void standardHandling(Command command) throws PersistenceException;
}

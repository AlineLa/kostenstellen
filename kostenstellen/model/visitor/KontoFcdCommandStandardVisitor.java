
package model.visitor;

import persistence.*;

public abstract class KontoFcdCommandStandardVisitor implements KontoFcdCommandVisitor {
    
    public void handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException{
        this.standardHandling(erzeugeKontoCommand);
    }
    public void handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException{
        this.standardHandling(findeKontoCommand);
    }
    protected abstract void standardHandling(KontoFcdCommand kontoFcdCommand) throws PersistenceException;
}

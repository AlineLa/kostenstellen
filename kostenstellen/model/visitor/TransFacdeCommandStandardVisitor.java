
package model.visitor;

import persistence.*;

public abstract class TransFacdeCommandStandardVisitor implements TransFacdeCommandVisitor {
    
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException{
        this.standardHandling(erzeugeTransaktionCommand);
    }
    protected abstract void standardHandling(TransFacdeCommand transFacdeCommand) throws PersistenceException;
}

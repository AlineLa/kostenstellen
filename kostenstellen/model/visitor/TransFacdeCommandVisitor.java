
package model.visitor;

import persistence.*;

public interface TransFacdeCommandVisitor {
    
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException;
    
}

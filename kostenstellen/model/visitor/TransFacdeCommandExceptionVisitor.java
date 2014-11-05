
package model.visitor;

import persistence.*;

public interface TransFacdeCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException, E;
    
}

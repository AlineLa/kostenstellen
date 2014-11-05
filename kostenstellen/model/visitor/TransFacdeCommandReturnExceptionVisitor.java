
package model.visitor;

import persistence.*;

public interface TransFacdeCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException, E;
    
}

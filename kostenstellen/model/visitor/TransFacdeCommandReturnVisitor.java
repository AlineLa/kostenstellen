
package model.visitor;

import persistence.*;

public interface TransFacdeCommandReturnVisitor<R> {
    
    public R handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException;
    
}

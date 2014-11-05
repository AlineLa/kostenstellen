
package model.visitor;

import persistence.*;

public interface KontoFcdCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException, E;
    public void handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException, E;
    
}

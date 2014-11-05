
package model.visitor;

import persistence.*;

public interface KontoFcdCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException, E;
    public R handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException, E;
    
}

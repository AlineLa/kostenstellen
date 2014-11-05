
package model.visitor;

import persistence.*;

public interface KontoFcdCommandReturnVisitor<R> {
    
    public R handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException;
    public R handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException;
    
}

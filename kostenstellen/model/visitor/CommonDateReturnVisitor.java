
package model.visitor;

import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException;
    public R handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException;
    public R handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException;
    public R handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}

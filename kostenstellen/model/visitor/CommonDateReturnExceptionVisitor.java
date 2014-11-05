
package model.visitor;

import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException, E;
    public R handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException, E;
    public R handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException, E;
    public R handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    
}

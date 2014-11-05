
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException;
    public void handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException;
    public void handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException;
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}

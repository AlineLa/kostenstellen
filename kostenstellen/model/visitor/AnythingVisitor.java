
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends AbstrakteKostenArtVisitor,CommonDateVisitor{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException;
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException;
    public void handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleTransFacdeTransaktions(PersistentTransFacdeTransaktions transFacdeTransaktions) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public void handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException;
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException;
    public void handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleKonto(PersistentKonto konto) throws PersistenceException;
    public void handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException;
    public void handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException;
    
}

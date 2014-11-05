
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends AbstrakteKostenArtExceptionVisitor<E>,CommonDateExceptionVisitor<E>{
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public void handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException, E;
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException, E;
    public void handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleTransFacdeTransaktions(PersistentTransFacdeTransaktions transFacdeTransaktions) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException, E;
    public void handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException, E;
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException, E;
    public void handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleKonto(PersistentKonto konto) throws PersistenceException, E;
    public void handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException, E;
    public void handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException, E;
    
}

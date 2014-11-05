
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends AbstrakteKostenArtReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public R handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public R handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException, E;
    public R handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException, E;
    public R handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleTransFacdeTransaktions(PersistentTransFacdeTransaktions transFacdeTransaktions) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleTransfer(PersistentTransfer transfer) throws PersistenceException, E;
    public R handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException, E;
    public R handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException, E;
    public R handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException, E;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public R handleKonto(PersistentKonto konto) throws PersistenceException, E;
    public R handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException, E;
    public R handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException, E;
    
}

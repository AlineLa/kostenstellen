
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends AbstrakteKostenArtReturnVisitor<R> ,CommonDateReturnVisitor<R> {
    
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleSubj(PersistentSubj subj) throws PersistenceException;
    public R handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException;
    public R handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException;
    public R handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleTransFacdeTransaktions(PersistentTransFacdeTransaktions transFacdeTransaktions) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public R handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException;
    public R handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException;
    public R handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleKonto(PersistentKonto konto) throws PersistenceException;
    public R handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException;
    public R handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException;
    
}

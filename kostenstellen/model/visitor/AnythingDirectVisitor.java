
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleSubj(PersistentSubj subj) throws PersistenceException;
    
    public abstract void handleAbstrakteKostenArt(PersistentAbstrakteKostenArt abstrakteKostenArt) throws PersistenceException;
    
    public void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException{
        this.handleAbstrakteKostenArt(reiseKosten);
    }
    public void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException{
        this.handleAbstrakteKostenArt(kostenArtWurzel);
    }
    public void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException{
        this.handleAbstrakteKostenArt(allgemeineKosten);
    }
    public void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException{
        this.handleAbstrakteKostenArt(lohnKosten);
    }
    public abstract void handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException;
    
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleTransFacdeTransaktions(PersistentTransFacdeTransaktions transFacdeTransaktions) throws PersistenceException;
    
    public abstract void handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException{
        this.handleCommonDate(bucheKontoCommand);
    }
    public void handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException{
        this.handleCommonDate(erzeugeKontoCommand);
    }
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException{
        this.handleCommonDate(erzeugeTransaktionCommand);
    }
    public void handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException{
        this.handleCommonDate(findeKontoCommand);
    }
    public abstract void handleKonto(PersistentKonto konto) throws PersistenceException;
    
    public abstract void handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException;
    
    public abstract void handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException;
    
    
}

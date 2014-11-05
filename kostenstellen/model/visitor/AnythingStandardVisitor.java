
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleSubj(PersistentSubj subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException{
        this.standardHandling(transaktion);
    }
    public void handleErzeugeTransaktionCommand(PersistentErzeugeTransaktionCommand erzeugeTransaktionCommand) throws PersistenceException{
        this.standardHandling(erzeugeTransaktionCommand);
    }
    public void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException{
        this.standardHandling(allgemeineKosten);
    }
    public void handleFindeKontoCommand(PersistentFindeKontoCommand findeKontoCommand) throws PersistenceException{
        this.standardHandling(findeKontoCommand);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleTransFacdeTransaktions(PersistentTransFacdeTransaktions transFacdeTransaktions) throws PersistenceException{
        this.standardHandling(transFacdeTransaktions);
    }
    public void handleBucheKontoCommand(PersistentBucheKontoCommand bucheKontoCommand) throws PersistenceException{
        this.standardHandling(bucheKontoCommand);
    }
    public void handleErzeugeKontoCommand(PersistentErzeugeKontoCommand erzeugeKontoCommand) throws PersistenceException{
        this.standardHandling(erzeugeKontoCommand);
    }
    public void handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException{
        this.standardHandling(artenManager);
    }
    public void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException{
        this.standardHandling(reiseKosten);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException{
        this.standardHandling(kontoFcd);
    }
    public void handleKonto(PersistentKonto konto) throws PersistenceException{
        this.standardHandling(konto);
    }
    public void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException{
        this.standardHandling(kostenArtWurzel);
    }
    public void handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException{
        this.standardHandling(transFacde);
    }
    public void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException{
        this.standardHandling(lohnKosten);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}

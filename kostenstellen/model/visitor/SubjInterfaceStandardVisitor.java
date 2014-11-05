
package model.visitor;

import persistence.*;

public abstract class SubjInterfaceStandardVisitor implements SubjInterfaceVisitor {
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException{
        this.standardHandling(transaktion);
    }
    public void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException{
        this.standardHandling(allgemeineKosten);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException{
        this.standardHandling(artenManager);
    }
    public void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException{
        this.standardHandling(reiseKosten);
    }
    public void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException{
        this.standardHandling(kostenArtWurzel);
    }
    public void handleKonto(PersistentKonto konto) throws PersistenceException{
        this.standardHandling(konto);
    }
    public void handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException{
        this.standardHandling(kontoFcd);
    }
    public void handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException{
        this.standardHandling(transFacde);
    }
    public void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException{
        this.standardHandling(lohnKosten);
    }
    protected abstract void standardHandling(SubjInterface subjInterface) throws PersistenceException;
}

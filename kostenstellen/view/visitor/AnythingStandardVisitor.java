
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleTransaktion(TransaktionView transaktion) throws ModelException{
        this.standardHandling(transaktion);
    }
    public void handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException{
        this.standardHandling(allgemeineKosten);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleArtenManager(ArtenManagerView artenManager) throws ModelException{
        this.standardHandling(artenManager);
    }
    public void handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException{
        this.standardHandling(reiseKosten);
    }
    public void handleKontoFcd(KontoFcdView kontoFcd) throws ModelException{
        this.standardHandling(kontoFcd);
    }
    public void handleKonto(KontoView konto) throws ModelException{
        this.standardHandling(konto);
    }
    public void handleKostenArtWurzel(KostenArtWurzelView kostenArtWurzel) throws ModelException{
        this.standardHandling(kostenArtWurzel);
    }
    public void handleTransFacde(TransFacdeView transFacde) throws ModelException{
        this.standardHandling(transFacde);
    }
    public void handleLohnKosten(LohnKostenView lohnKosten) throws ModelException{
        this.standardHandling(lohnKosten);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}

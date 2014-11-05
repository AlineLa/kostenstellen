
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleAbstrakteKostenArt(AbstrakteKostenArtView abstrakteKostenArt) throws ModelException;
    
    public void handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException{
        this.handleAbstrakteKostenArt(reiseKosten);
    }
    public void handleKostenArtWurzel(KostenArtWurzelView kostenArtWurzel) throws ModelException{
        this.handleAbstrakteKostenArt(kostenArtWurzel);
    }
    public void handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException{
        this.handleAbstrakteKostenArt(allgemeineKosten);
    }
    public void handleLohnKosten(LohnKostenView lohnKosten) throws ModelException{
        this.handleAbstrakteKostenArt(lohnKosten);
    }
    public abstract void handleTransaktion(TransaktionView transaktion) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleTransfer(TransferView transfer) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleArtenManager(ArtenManagerView artenManager) throws ModelException;
    
    public abstract void handleKonto(KontoView konto) throws ModelException;
    
    public abstract void handleKontoFcd(KontoFcdView kontoFcd) throws ModelException;
    
    public abstract void handleTransFacde(TransFacdeView transFacde) throws ModelException;
    
    
}

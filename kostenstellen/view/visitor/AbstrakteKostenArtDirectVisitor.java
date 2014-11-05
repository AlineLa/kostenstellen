
package view.visitor;

import view.*;

public abstract class AbstrakteKostenArtDirectVisitor implements AbstrakteKostenArtVisitor {
    
    public abstract void handleKonkreteKostenArt(KonkreteKostenArtView konkreteKostenArt) throws ModelException;
    
    public void handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException{
        this.handleKonkreteKostenArt(reiseKosten);
    }
    public void handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException{
        this.handleKonkreteKostenArt(allgemeineKosten);
    }
    public void handleLohnKosten(LohnKostenView lohnKosten) throws ModelException{
        this.handleKonkreteKostenArt(lohnKosten);
    }
    public abstract void handleKostenArtWurzel(KostenArtWurzelView kostenArtWurzel) throws ModelException;
    
    
}


package view.visitor;

import view.*;

public abstract class AbstrakteKostenArtStandardVisitor implements AbstrakteKostenArtVisitor {
    
    public void handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException{
        this.standardHandling(reiseKosten);
    }
    public void handleKostenArtWurzel(KostenArtWurzelView kostenArtWurzel) throws ModelException{
        this.standardHandling(kostenArtWurzel);
    }
    public void handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException{
        this.standardHandling(allgemeineKosten);
    }
    public void handleLohnKosten(LohnKostenView lohnKosten) throws ModelException{
        this.standardHandling(lohnKosten);
    }
    protected abstract void standardHandling(AbstrakteKostenArtView abstrakteKostenArt) throws ModelException;
}

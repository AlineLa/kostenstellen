
package view.visitor;

import view.*;

public abstract class KonkreteKostenArtStandardVisitor implements KonkreteKostenArtVisitor {
    
    public void handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException{
        this.standardHandling(reiseKosten);
    }
    public void handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException{
        this.standardHandling(allgemeineKosten);
    }
    public void handleLohnKosten(LohnKostenView lohnKosten) throws ModelException{
        this.standardHandling(lohnKosten);
    }
    protected abstract void standardHandling(KonkreteKostenArtView konkreteKostenArt) throws ModelException;
}

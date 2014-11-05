
package view.visitor;

import view.*;

public interface KonkreteKostenArtVisitor {
    
    public void handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException;
    public void handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException;
    public void handleLohnKosten(LohnKostenView lohnKosten) throws ModelException;
    
}

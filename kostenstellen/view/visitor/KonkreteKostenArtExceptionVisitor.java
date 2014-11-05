
package view.visitor;

import view.*;

public interface KonkreteKostenArtExceptionVisitor<E extends view.UserException> {
    
    public void handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException, E;
    public void handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException, E;
    public void handleLohnKosten(LohnKostenView lohnKosten) throws ModelException, E;
    
}

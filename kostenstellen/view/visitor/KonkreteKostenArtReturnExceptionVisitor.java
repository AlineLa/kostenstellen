
package view.visitor;

import view.*;

public interface KonkreteKostenArtReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException, E;
    public R handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException, E;
    public R handleLohnKosten(LohnKostenView lohnKosten) throws ModelException, E;
    
}

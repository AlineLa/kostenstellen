
package view.visitor;

import view.*;

public interface KonkreteKostenArtReturnVisitor<R> {
    
    public R handleReiseKosten(ReiseKostenView reiseKosten) throws ModelException;
    public R handleAllgemeineKosten(AllgemeineKostenView allgemeineKosten) throws ModelException;
    public R handleLohnKosten(LohnKostenView lohnKosten) throws ModelException;
    
}

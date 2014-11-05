
package model.visitor;

import persistence.*;

public interface KonkreteKostenArtReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException, E;
    public R handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException, E;
    public R handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException, E;
    
}

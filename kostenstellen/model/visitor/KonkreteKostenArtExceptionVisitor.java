
package model.visitor;

import persistence.*;

public interface KonkreteKostenArtExceptionVisitor<E extends model.UserException> {
    
    public void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException, E;
    public void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException, E;
    public void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException, E;
    
}

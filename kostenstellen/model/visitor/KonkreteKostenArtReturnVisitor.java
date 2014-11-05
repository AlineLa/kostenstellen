
package model.visitor;

import persistence.*;

public interface KonkreteKostenArtReturnVisitor<R> {
    
    public R handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException;
    public R handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException;
    public R handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException;
    
}

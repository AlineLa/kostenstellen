
package model.visitor;

import persistence.*;

public interface KonkreteKostenArtVisitor {
    
    public void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException;
    public void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException;
    public void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException;
    
}


package model.visitor;

import persistence.*;

public abstract class KonkreteKostenArtStandardVisitor implements KonkreteKostenArtVisitor {
    
    public void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException{
        this.standardHandling(reiseKosten);
    }
    public void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException{
        this.standardHandling(allgemeineKosten);
    }
    public void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException{
        this.standardHandling(lohnKosten);
    }
    protected abstract void standardHandling(PersistentKonkreteKostenArt konkreteKostenArt) throws PersistenceException;
}

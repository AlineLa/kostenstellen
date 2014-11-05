
package model.visitor;

import persistence.*;

public abstract class AbstrakteKostenArtDirectVisitor implements AbstrakteKostenArtVisitor {
    
    public abstract void handleKonkreteKostenArt(PersistentKonkreteKostenArt konkreteKostenArt) throws PersistenceException;
    
    public void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException{
        this.handleKonkreteKostenArt(reiseKosten);
    }
    public void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException{
        this.handleKonkreteKostenArt(allgemeineKosten);
    }
    public void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException{
        this.handleKonkreteKostenArt(lohnKosten);
    }
    public abstract void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException;
    
    
}

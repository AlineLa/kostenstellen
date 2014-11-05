
package model.visitor;

import persistence.*;

public abstract class AbstrakteKostenArtStandardVisitor implements AbstrakteKostenArtVisitor {
    
    public void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException{
        this.standardHandling(reiseKosten);
    }
    public void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException{
        this.standardHandling(kostenArtWurzel);
    }
    public void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException{
        this.standardHandling(allgemeineKosten);
    }
    public void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException{
        this.standardHandling(lohnKosten);
    }
    protected abstract void standardHandling(PersistentAbstrakteKostenArt abstrakteKostenArt) throws PersistenceException;
}

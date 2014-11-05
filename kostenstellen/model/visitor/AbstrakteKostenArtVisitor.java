
package model.visitor;

import persistence.*;

public interface AbstrakteKostenArtVisitor extends KonkreteKostenArtVisitor{
    
    public void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException;
    
}


package model.visitor;

import persistence.*;

public interface AbstrakteKostenArtExceptionVisitor<E extends model.UserException> extends KonkreteKostenArtExceptionVisitor<E>{
    
    public void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException, E;
    
}

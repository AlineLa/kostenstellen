
package model.visitor;

import persistence.*;

public interface AbstrakteKostenArtReturnVisitor<R> extends KonkreteKostenArtReturnVisitor<R> {
    
    public R handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException;
    
}

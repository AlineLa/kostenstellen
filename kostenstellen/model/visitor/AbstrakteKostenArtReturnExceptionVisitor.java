
package model.visitor;

import persistence.*;

public interface AbstrakteKostenArtReturnExceptionVisitor<R, E extends model.UserException> extends KonkreteKostenArtReturnExceptionVisitor<R, E> {
    
    public R handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException, E;
    
}

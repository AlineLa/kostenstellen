
package view.visitor;

import view.*;

public interface AbstrakteKostenArtReturnExceptionVisitor<R, E extends view.UserException> extends KonkreteKostenArtReturnExceptionVisitor<R, E> {
    
    public R handleKostenArtWurzel(KostenArtWurzelView kostenArtWurzel) throws ModelException, E;
    
}

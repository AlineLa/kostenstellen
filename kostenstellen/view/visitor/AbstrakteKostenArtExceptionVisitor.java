
package view.visitor;

import view.*;

public interface AbstrakteKostenArtExceptionVisitor<E extends view.UserException> extends KonkreteKostenArtExceptionVisitor<E>{
    
    public void handleKostenArtWurzel(KostenArtWurzelView kostenArtWurzel) throws ModelException, E;
    
}

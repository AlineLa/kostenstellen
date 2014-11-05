
package view.visitor;

import view.*;

public interface AbstrakteKostenArtReturnVisitor<R> extends KonkreteKostenArtReturnVisitor<R> {
    
    public R handleKostenArtWurzel(KostenArtWurzelView kostenArtWurzel) throws ModelException;
    
}

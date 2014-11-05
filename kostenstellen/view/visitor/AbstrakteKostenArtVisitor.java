
package view.visitor;

import view.*;

public interface AbstrakteKostenArtVisitor extends KonkreteKostenArtVisitor{
    
    public void handleKostenArtWurzel(KostenArtWurzelView kostenArtWurzel) throws ModelException;
    
}

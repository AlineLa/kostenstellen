package view;

import view.objects.*;

import view.visitor.*;

public interface AbstrakteKostenArtView extends Anything, AbstractViewRoot {
    
    
    public void accept(AbstrakteKostenArtVisitor visitor) throws ModelException;
    public <R> R accept(AbstrakteKostenArtReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AbstrakteKostenArtExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AbstrakteKostenArtReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}


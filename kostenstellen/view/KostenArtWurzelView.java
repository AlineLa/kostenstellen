package view;

import view.visitor.*;

public interface KostenArtWurzelView extends AbstrakteKostenArtView {
    
    
    public void accept(AbstrakteKostenArtVisitor visitor) throws ModelException;
    public <R> R accept(AbstrakteKostenArtReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AbstrakteKostenArtExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AbstrakteKostenArtReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}


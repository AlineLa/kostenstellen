package view;

import view.visitor.*;

public interface KonkreteKostenArtView extends AbstrakteKostenArtView {
    
    public AbstrakteKostenArtView getSpeziellerAls()throws ModelException;
    public void setSpeziellerAls(AbstrakteKostenArtView newValue) throws ModelException ;
    
    public void accept(KonkreteKostenArtVisitor visitor) throws ModelException;
    public <R> R accept(KonkreteKostenArtReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(KonkreteKostenArtExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(KonkreteKostenArtReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}


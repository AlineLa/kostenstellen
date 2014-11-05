package view;

import view.objects.*;

import view.visitor.*;

public interface TransaktionView extends Anything, AbstractViewRoot {
    
    public java.util.Vector<TransferView> getTransfers()throws ModelException;
    public void setTransfers(java.util.Vector<TransferView> newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}


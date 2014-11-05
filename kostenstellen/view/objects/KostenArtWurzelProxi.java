package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class KostenArtWurzelProxi extends AbstrakteKostenArtProxi implements KostenArtWurzelView{
    
    public KostenArtWurzelProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public KostenArtWurzelView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        KostenArtWurzelView result$$ = new KostenArtWurzel( this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 ;
    }
    public boolean isLeaf() throws ModelException {
        return true;
    }
    public int getIndexOfChild(Object child) throws ModelException {
        
        return -1;
    }
    
    
    public void accept(AbstrakteKostenArtVisitor visitor) throws ModelException {
        visitor.handleKostenArtWurzel(this);
    }
    public <R> R accept(AbstrakteKostenArtReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKostenArtWurzel(this);
    }
    public <E extends view.UserException>  void accept(AbstrakteKostenArtExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKostenArtWurzel(this);
    }
    public <R, E extends view.UserException> R accept(AbstrakteKostenArtReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKostenArtWurzel(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleKostenArtWurzel(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKostenArtWurzel(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKostenArtWurzel(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKostenArtWurzel(this);
    }
    
    public boolean hasTransientFields(){
        return false;
    }
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}

package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TransFacdeProxi extends ViewProxi implements TransFacdeView{
    
    public TransFacdeProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public TransFacdeView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> transaktions_string = (java.util.Vector<String>)resultTable.get("transaktions");
        java.util.Vector<TransaktionView> transaktions = ViewProxi.getProxiVector(transaktions_string, connectionKey);
        TransFacdeView result$$ = new TransFacde(transaktions, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getTransaktions().size()) return new TransaktionsTransFacdeWrapper(this, originalIndex, (ViewRoot)this.getTransaktions().get(index));
        index = index - this.getTransaktions().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getTransaktions().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getTransaktions().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getTransaktionsIterator = this.getTransaktions().iterator();
        while(getTransaktionsIterator.hasNext()){
            if(getTransaktionsIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<TransaktionView> getTransaktions()throws ModelException{
        return ((TransFacde)this.getTheObject()).getTransaktions();
    }
    public void setTransaktions(java.util.Vector<TransaktionView> newValue) throws ModelException {
        ((TransFacde)this.getTheObject()).setTransaktions(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTransFacde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransFacde(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransFacde(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransFacde(this);
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

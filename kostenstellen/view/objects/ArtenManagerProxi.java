package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class ArtenManagerProxi extends ViewProxi implements ArtenManagerView{
    
    public ArtenManagerProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public ArtenManagerView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> arten_string = (java.util.Vector<String>)resultTable.get("arten");
        java.util.Vector<KonkreteKostenArtView> arten = ViewProxi.getProxiVector(arten_string, connectionKey);
        ArtenManagerView result$$ = new ArtenManager(arten, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getArten().size()) return new ArtenArtenManagerWrapper(this, originalIndex, (ViewRoot)this.getArten().get(index));
        index = index - this.getArten().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getArten().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getArten().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getArtenIterator = this.getArten().iterator();
        while(getArtenIterator.hasNext()){
            if(getArtenIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<KonkreteKostenArtView> getArten()throws ModelException{
        return ((ArtenManager)this.getTheObject()).getArten();
    }
    public void setArten(java.util.Vector<KonkreteKostenArtView> newValue) throws ModelException {
        ((ArtenManager)this.getTheObject()).setArten(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleArtenManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleArtenManager(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleArtenManager(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleArtenManager(this);
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

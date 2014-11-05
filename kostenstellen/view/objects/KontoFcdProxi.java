package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class KontoFcdProxi extends ViewProxi implements KontoFcdView{
    
    public KontoFcdProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    @SuppressWarnings("unchecked")
    public KontoFcdView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        java.util.Vector<String> konten_string = (java.util.Vector<String>)resultTable.get("konten");
        java.util.Vector<KontoView> konten = ViewProxi.getProxiVector(konten_string, connectionKey);
        KontoFcdView result$$ = new KontoFcd(konten, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index < this.getKonten().size()) return new KontenKontoFcdWrapper(this, originalIndex, (ViewRoot)this.getKonten().get(index));
        index = index - this.getKonten().size();
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getKonten().size());
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getKonten().size() == 0);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        java.util.Iterator<?> getKontenIterator = this.getKonten().iterator();
        while(getKontenIterator.hasNext()){
            if(getKontenIterator.next().equals(child)) return result;
            result = result + 1;
        }
        return -1;
    }
    
    public java.util.Vector<KontoView> getKonten()throws ModelException{
        return ((KontoFcd)this.getTheObject()).getKonten();
    }
    public void setKonten(java.util.Vector<KontoView> newValue) throws ModelException {
        ((KontoFcd)this.getTheObject()).setKonten(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleKontoFcd(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKontoFcd(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKontoFcd(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKontoFcd(this);
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

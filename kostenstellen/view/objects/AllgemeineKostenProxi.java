package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class AllgemeineKostenProxi extends KonkreteKostenArtProxi implements AllgemeineKostenView{
    
    public AllgemeineKostenProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public AllgemeineKostenView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi speziellerAls = null;
        String speziellerAls$String = (String)resultTable.get("speziellerAls");
        if (speziellerAls$String != null) {
            common.ProxiInformation speziellerAls$Info = common.RPCConstantsAndServices.createProxiInformation(speziellerAls$String);
            speziellerAls = view.objects.ViewProxi.createProxi(speziellerAls$Info,connectionKey);
            speziellerAls.setToString(speziellerAls$Info.getToString());
        }
        AllgemeineKostenView result$$ = new AllgemeineKosten((AbstrakteKostenArtView)speziellerAls, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getSpeziellerAls() != null) return new SpeziellerAlsKonkreteKostenArtWrapper(this, originalIndex, (ViewRoot)this.getSpeziellerAls());
        if(this.getSpeziellerAls() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getSpeziellerAls() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getSpeziellerAls() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSpeziellerAls() != null && this.getSpeziellerAls().equals(child)) return result;
        if(this.getSpeziellerAls() != null) result = result + 1;
        return -1;
    }
    
    
    public void accept(KonkreteKostenArtVisitor visitor) throws ModelException {
        visitor.handleAllgemeineKosten(this);
    }
    public <R> R accept(KonkreteKostenArtReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAllgemeineKosten(this);
    }
    public <E extends view.UserException>  void accept(KonkreteKostenArtExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAllgemeineKosten(this);
    }
    public <R, E extends view.UserException> R accept(KonkreteKostenArtReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAllgemeineKosten(this);
    }
    public void accept(AbstrakteKostenArtVisitor visitor) throws ModelException {
        visitor.handleAllgemeineKosten(this);
    }
    public <R> R accept(AbstrakteKostenArtReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAllgemeineKosten(this);
    }
    public <E extends view.UserException>  void accept(AbstrakteKostenArtExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAllgemeineKosten(this);
    }
    public <R, E extends view.UserException> R accept(AbstrakteKostenArtReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAllgemeineKosten(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleAllgemeineKosten(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleAllgemeineKosten(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleAllgemeineKosten(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleAllgemeineKosten(this);
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

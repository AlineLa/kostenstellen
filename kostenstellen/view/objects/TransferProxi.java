package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class TransferProxi extends ViewProxi implements TransferView{
    
    public TransferProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public TransferView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        ViewProxi vonKonto = null;
        String vonKonto$String = (String)resultTable.get("vonKonto");
        if (vonKonto$String != null) {
            common.ProxiInformation vonKonto$Info = common.RPCConstantsAndServices.createProxiInformation(vonKonto$String);
            vonKonto = view.objects.ViewProxi.createProxi(vonKonto$Info,connectionKey);
            vonKonto.setToString(vonKonto$Info.getToString());
        }
        ViewProxi zuKonto = null;
        String zuKonto$String = (String)resultTable.get("zuKonto");
        if (zuKonto$String != null) {
            common.ProxiInformation zuKonto$Info = common.RPCConstantsAndServices.createProxiInformation(zuKonto$String);
            zuKonto = view.objects.ViewProxi.createProxi(zuKonto$Info,connectionKey);
            zuKonto.setToString(zuKonto$Info.getToString());
        }
        long Summe = new Long((String)resultTable.get("Summe")).longValue();
        String KontoID = (String)resultTable.get("KontoID");
        TransferView result$$ = new Transfer((KontoView)vonKonto,(KontoView)zuKonto,(long)Summe,(String)KontoID, this.getId(), this.getClassId());
        ((ViewRoot)result$$).setToString((String) resultTable.get(common.RPCConstantsAndServices.RPCToStringFieldName));
        return result$$;
    }
    
    public int getRemoteDepth() {
        return RemoteDepth;
    }
    public ViewObjectInTree getChild(int originalIndex) throws ModelException{
        int index = originalIndex;
        if(index == 0 && this.getVonKonto() != null) return new VonKontoTransferWrapper(this, originalIndex, (ViewRoot)this.getVonKonto());
        if(this.getVonKonto() != null) index = index - 1;
        if(index == 0 && this.getZuKonto() != null) return new ZuKontoTransferWrapper(this, originalIndex, (ViewRoot)this.getZuKonto());
        if(this.getZuKonto() != null) index = index - 1;
        return null;
    }
    public int getChildCount() throws ModelException {
        return 0 
            + (this.getVonKonto() == null ? 0 : 1)
            + (this.getZuKonto() == null ? 0 : 1);
    }
    public boolean isLeaf() throws ModelException {
        if (this.object == null) return this.getLeafInfo() == 0;
        return true 
            && (this.getVonKonto() == null ? true : false)
            && (this.getZuKonto() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getVonKonto() != null && this.getVonKonto().equals(child)) return result;
        if(this.getVonKonto() != null) result = result + 1;
        if(this.getZuKonto() != null && this.getZuKonto().equals(child)) return result;
        if(this.getZuKonto() != null) result = result + 1;
        return -1;
    }
    
    public KontoView getVonKonto()throws ModelException{
        return ((Transfer)this.getTheObject()).getVonKonto();
    }
    public void setVonKonto(KontoView newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setVonKonto(newValue);
    }
    public KontoView getZuKonto()throws ModelException{
        return ((Transfer)this.getTheObject()).getZuKonto();
    }
    public void setZuKonto(KontoView newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setZuKonto(newValue);
    }
    public long getSumme()throws ModelException{
        return ((Transfer)this.getTheObject()).getSumme();
    }
    public void setSumme(long newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setSumme(newValue);
    }
    public String getKontoID()throws ModelException{
        return ((Transfer)this.getTheObject()).getKontoID();
    }
    public void setKontoID(String newValue) throws ModelException {
        ((Transfer)this.getTheObject()).setKontoID(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleTransfer(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleTransfer(this);
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

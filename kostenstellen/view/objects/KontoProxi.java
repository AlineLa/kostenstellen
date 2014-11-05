package view.objects;

import view.*;
import viewClient.*;

import view.visitor.*;

public class KontoProxi extends ViewProxi implements KontoView{
    
    public KontoProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    public KontoView getRemoteObject(java.util.HashMap<String,Object> resultTable, ExceptionAndEventHandler connectionKey) throws ModelException{
        String KontoID = (String)resultTable.get("KontoID");
        long Grenzwert = new Long((String)resultTable.get("Grenzwert")).longValue();
        long Kontostand = new Long((String)resultTable.get("Kontostand")).longValue();
        long Minimum = new Long((String)resultTable.get("Minimum")).longValue();
        KontoView result$$ = new Konto((String)KontoID,(long)Grenzwert,(long)Kontostand,(long)Minimum, this.getId(), this.getClassId());
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
    
    public String getKontoID()throws ModelException{
        return ((Konto)this.getTheObject()).getKontoID();
    }
    public void setKontoID(String newValue) throws ModelException {
        ((Konto)this.getTheObject()).setKontoID(newValue);
    }
    public long getGrenzwert()throws ModelException{
        return ((Konto)this.getTheObject()).getGrenzwert();
    }
    public void setGrenzwert(long newValue) throws ModelException {
        ((Konto)this.getTheObject()).setGrenzwert(newValue);
    }
    public long getKontostand()throws ModelException{
        return ((Konto)this.getTheObject()).getKontostand();
    }
    public void setKontostand(long newValue) throws ModelException {
        ((Konto)this.getTheObject()).setKontostand(newValue);
    }
    public long getMinimum()throws ModelException{
        return ((Konto)this.getTheObject()).getMinimum();
    }
    public void setMinimum(long newValue) throws ModelException {
        ((Konto)this.getTheObject()).setMinimum(newValue);
    }
    
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleKonto(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleKonto(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleKonto(this);
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

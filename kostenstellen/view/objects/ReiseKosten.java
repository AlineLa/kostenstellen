
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ReiseKosten extends view.objects.KonkreteKostenArt implements ReiseKostenView{
    
    
    public ReiseKosten(AbstrakteKostenArtView speziellerAls,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super((AbstrakteKostenArtView)speziellerAls,id, classId);        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    
    public void accept(KonkreteKostenArtVisitor visitor) throws ModelException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(KonkreteKostenArtReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends view.UserException>  void accept(KonkreteKostenArtExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends view.UserException> R accept(KonkreteKostenArtReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleReiseKosten(this);
    }
    public void accept(AbstrakteKostenArtVisitor visitor) throws ModelException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(AbstrakteKostenArtReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends view.UserException>  void accept(AbstrakteKostenArtExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends view.UserException> R accept(AbstrakteKostenArtReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleReiseKosten(this);
    }
    public void accept(AnythingVisitor visitor) throws ModelException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E {
         return visitor.handleReiseKosten(this);
    }
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        AbstrakteKostenArtView speziellerAls = this.getSpeziellerAls();
        if (speziellerAls != null) {
            ((ViewProxi)speziellerAls).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(speziellerAls.getClassId(), speziellerAls.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
        return true 
            && (this.getSpeziellerAls() == null ? true : false);
    }
    public int getIndexOfChild(Object child) throws ModelException {
        int result = 0;
        if(this.getSpeziellerAls() != null && this.getSpeziellerAls().equals(child)) return result;
        if(this.getSpeziellerAls() != null) result = result + 1;
        return -1;
    }
    public int getRowCount(){
        return 0 ;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
            } else {
            }
            throw new ModelException("Table index out of bounds!", -1);
        } catch (ModelException e){
            return e.getMessage();
        }
    }
    
    public boolean isRowEditable(int index){
        return true;
    }
    public void setValueAt(String newValue, int rowIndex) throws Exception {
        
    }
    public boolean hasTransientFields(){
        return false;
    }
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}

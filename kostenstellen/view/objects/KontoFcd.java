
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class KontoFcd extends ViewObject implements KontoFcdView{
    
    protected java.util.Vector<KontoView> konten;
    
    public KontoFcd(java.util.Vector<KontoView> konten,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.konten = konten;        
    }
    
    static public long getTypeId() {
        return 127;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<KontoView> getKonten()throws ModelException{
        return this.konten;
    }
    public void setKonten(java.util.Vector<KontoView> newValue) throws ModelException {
        this.konten = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> konten = this.getKonten();
        if (konten != null) {
            ViewObject.resolveVectorProxies(konten, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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

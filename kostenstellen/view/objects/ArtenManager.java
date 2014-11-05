
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class ArtenManager extends ViewObject implements ArtenManagerView{
    
    protected java.util.Vector<KonkreteKostenArtView> arten;
    
    public ArtenManager(java.util.Vector<KonkreteKostenArtView> arten,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.arten = arten;        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<KonkreteKostenArtView> getArten()throws ModelException{
        return this.arten;
    }
    public void setArten(java.util.Vector<KonkreteKostenArtView> newValue) throws ModelException {
        this.arten = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> arten = this.getArten();
        if (arten != null) {
            ViewObject.resolveVectorProxies(arten, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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

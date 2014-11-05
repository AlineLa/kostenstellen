
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class TransFacde extends ViewObject implements TransFacdeView{
    
    protected java.util.Vector<TransaktionView> transaktions;
    
    public TransFacde(java.util.Vector<TransaktionView> transaktions,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.transaktions = transaktions;        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public java.util.Vector<TransaktionView> getTransaktions()throws ModelException{
        return this.transaktions;
    }
    public void setTransaktions(java.util.Vector<TransaktionView> newValue) throws ModelException {
        this.transaktions = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        java.util.Vector<?> transaktions = this.getTransaktions();
        if (transaktions != null) {
            ViewObject.resolveVectorProxies(transaktions, resultTable);
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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

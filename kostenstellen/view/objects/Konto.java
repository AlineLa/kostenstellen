
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Konto extends ViewObject implements KontoView{
    
    protected String KontoID;
    protected long Grenzwert;
    protected long Kontostand;
    protected long Minimum;
    
    public Konto(String KontoID,long Grenzwert,long Kontostand,long Minimum,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.KontoID = KontoID;
        this.Grenzwert = Grenzwert;
        this.Kontostand = Kontostand;
        this.Minimum = Minimum;        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getKontoID()throws ModelException{
        return this.KontoID;
    }
    public void setKontoID(String newValue) throws ModelException {
        this.KontoID = newValue;
    }
    public long getGrenzwert()throws ModelException{
        return this.Grenzwert;
    }
    public void setGrenzwert(long newValue) throws ModelException {
        this.Grenzwert = newValue;
    }
    public long getKontostand()throws ModelException{
        return this.Kontostand;
    }
    public void setKontostand(long newValue) throws ModelException {
        this.Kontostand = newValue;
    }
    public long getMinimum()throws ModelException{
        return this.Minimum;
    }
    public void setMinimum(long newValue) throws ModelException {
        this.Minimum = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getKontoIDIndex() throws ModelException {
        return 0;
    }
    public int getGrenzwertIndex() throws ModelException {
        return 0 + 1;
    }
    public int getKontostandIndex() throws ModelException {
        return 0 + 1 + 1;
    }
    public int getMinimumIndex() throws ModelException {
        return 0 + 1 + 1 + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "KontoID";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "Grenzwert";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "Kontostand";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "Minimum";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return this.getKontoID();
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getGrenzwert());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getKontostand());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return new Long(getMinimum());
                rowIndex = rowIndex - 1;
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
        if(rowIndex == 0){
            this.setKontoID(newValue);
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setGrenzwert(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setKontostand(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setMinimum(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
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

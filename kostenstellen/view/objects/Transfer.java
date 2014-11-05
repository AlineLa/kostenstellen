
package view.objects;

import view.*;
import view.visitor.*;


/* Additional import section end */

public class Transfer extends ViewObject implements TransferView{
    
    protected KontoView vonKonto;
    protected KontoView zuKonto;
    protected long Summe;
    protected String KontoID;
    
    public Transfer(KontoView vonKonto,KontoView zuKonto,long Summe,String KontoID,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.vonKonto = vonKonto;
        this.zuKonto = zuKonto;
        this.Summe = Summe;
        this.KontoID = KontoID;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public KontoView getVonKonto()throws ModelException{
        return this.vonKonto;
    }
    public void setVonKonto(KontoView newValue) throws ModelException {
        this.vonKonto = newValue;
    }
    public KontoView getZuKonto()throws ModelException{
        return this.zuKonto;
    }
    public void setZuKonto(KontoView newValue) throws ModelException {
        this.zuKonto = newValue;
    }
    public long getSumme()throws ModelException{
        return this.Summe;
    }
    public void setSumme(long newValue) throws ModelException {
        this.Summe = newValue;
    }
    public String getKontoID()throws ModelException{
        return this.KontoID;
    }
    public void setKontoID(String newValue) throws ModelException {
        this.KontoID = newValue;
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
    
    public void resolveProxies(java.util.HashMap<String,Object> resultTable) throws ModelException {
        KontoView vonKonto = this.getVonKonto();
        if (vonKonto != null) {
            ((ViewProxi)vonKonto).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(vonKonto.getClassId(), vonKonto.getId())));
        }
        KontoView zuKonto = this.getZuKonto();
        if (zuKonto != null) {
            ((ViewProxi)zuKonto).setObject((ViewObject)resultTable.get(common.RPCConstantsAndServices.createHashtableKey(zuKonto.getClassId(), zuKonto.getId())));
        }
        
    }
    public void sortSetValuedFields() throws ModelException {
        
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
    public int getSummeIndex() throws ModelException {
        return 0 + (this.getVonKonto() == null ? 0 : 1) + (this.getZuKonto() == null ? 0 : 1);
    }
    public int getKontoIDIndex() throws ModelException {
        return 0 + (this.getVonKonto() == null ? 0 : 1) + (this.getZuKonto() == null ? 0 : 1) + 1;
    }
    public int getRowCount(){
        return 0 
            + 1
            + 1;
    }
    public Object getValueAt(int rowIndex, int columnIndex){
        try {
            if(columnIndex == 0){
                if(rowIndex == 0) return "Summe";
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return "KontoID";
                rowIndex = rowIndex - 1;
            } else {
                if(rowIndex == 0) return new Long(getSumme());
                rowIndex = rowIndex - 1;
                if(rowIndex == 0) return this.getKontoID();
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
            this.setSumme(Long.parseLong(newValue));
            return;
        }
        rowIndex = rowIndex - 1;
        if(rowIndex == 0){
            this.setKontoID(newValue);
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


package view.objects;

import view.*;


/* Additional import section end */

public abstract class KonkreteKostenArt extends view.objects.AbstrakteKostenArt implements KonkreteKostenArtView{
    
    protected AbstrakteKostenArtView speziellerAls;
    
    public KonkreteKostenArt(AbstrakteKostenArtView speziellerAls,long id, long classId) {
        /* Shall not be used. Objects are created on the server only */
        super(id, classId);
        this.speziellerAls = speziellerAls;        
    }
    
    public AbstrakteKostenArtView getSpeziellerAls()throws ModelException{
        return this.speziellerAls;
    }
    public void setSpeziellerAls(AbstrakteKostenArtView newValue) throws ModelException {
        this.speziellerAls = newValue;
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
    /* Start of protected part that is not overridden by persistence generator */
    
    public void setIcon(IconRenderer renderer) {
        super.setIcon(renderer);
    }
    /* End of protected part that is not overridden by persistence generator */
    
    
}

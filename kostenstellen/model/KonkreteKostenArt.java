
package model;

import persistence.*;


/* Additional import section end */

public abstract class KonkreteKostenArt extends model.AbstrakteKostenArt implements PersistentKonkreteKostenArt{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot speziellerAls = (AbstractPersistentRoot)this.getSpeziellerAls();
            if (speziellerAls != null) {
                result.put("speziellerAls", speziellerAls.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    speziellerAls.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && speziellerAls.hasEssentialFields())speziellerAls.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract KonkreteKostenArt provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAbstrakteKostenArt speziellerAls;
    
    public KonkreteKostenArt(SubjInterface subService,PersistentAbstrakteKostenArt This,PersistentAbstrakteKostenArt speziellerAls,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentAbstrakteKostenArt)This,id);
        this.speziellerAls = speziellerAls;        
    }
    
    static public long getTypeId() {
        return 125;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getSpeziellerAls() != null){
            this.getSpeziellerAls().store();
            ConnectionHandler.getTheConnectionHandler().theKonkreteKostenArtFacade.speziellerAlsSet(this.getId(), getSpeziellerAls());
        }
        
    }
    
    public PersistentAbstrakteKostenArt getSpeziellerAls() throws PersistenceException {
        return this.speziellerAls;
    }
    public void setSpeziellerAls(PersistentAbstrakteKostenArt newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.speziellerAls)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.speziellerAls = (PersistentAbstrakteKostenArt)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theKonkreteKostenArtFacade.speziellerAlsSet(this.getId(), newValue);
        }
    }
    public abstract PersistentKonkreteKostenArt getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentKonkreteKostenArt)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

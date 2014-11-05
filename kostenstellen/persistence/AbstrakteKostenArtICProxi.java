package persistence;



public abstract class AbstrakteKostenArtICProxi extends PersistentInCacheProxiOptimistic implements PersistentAbstrakteKostenArt{
    
    public AbstrakteKostenArtICProxi(long objectId) {
        super(objectId);
    }
    public AbstrakteKostenArtICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentAbstrakteKostenArt)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentAbstrakteKostenArt)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentAbstrakteKostenArt getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAbstrakteKostenArt)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAbstrakteKostenArt)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAbstrakteKostenArt)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAbstrakteKostenArt)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAbstrakteKostenArt)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAbstrakteKostenArt)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbstrakteKostenArt)this.getTheObject()).initializeOnInstantiation();
    }

    
}

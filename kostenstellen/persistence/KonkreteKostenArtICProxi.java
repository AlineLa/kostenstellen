package persistence;



public abstract class KonkreteKostenArtICProxi extends AbstrakteKostenArtICProxi implements PersistentKonkreteKostenArt{
    
    public KonkreteKostenArtICProxi(long objectId) {
        super(objectId);
    }
    public KonkreteKostenArtICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public PersistentAbstrakteKostenArt getSpeziellerAls() throws PersistenceException {
        return ((PersistentKonkreteKostenArt)this.getTheObject()).getSpeziellerAls();
    }
    public void setSpeziellerAls(PersistentAbstrakteKostenArt newValue) throws PersistenceException {
        ((PersistentKonkreteKostenArt)this.getTheObject()).setSpeziellerAls(newValue);
    }
    public abstract PersistentKonkreteKostenArt getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKonkreteKostenArt)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentKonkreteKostenArt)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKonkreteKostenArt)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentKonkreteKostenArt)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentKonkreteKostenArt)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentKonkreteKostenArt)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentKonkreteKostenArt)this.getTheObject()).initializeOnInstantiation();
    }

    
}

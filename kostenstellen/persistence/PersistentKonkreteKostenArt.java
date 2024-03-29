package persistence;


import model.visitor.*;

public interface PersistentKonkreteKostenArt extends PersistentAbstrakteKostenArt {
    
    public PersistentAbstrakteKostenArt getSpeziellerAls() throws PersistenceException ;
    public void setSpeziellerAls(PersistentAbstrakteKostenArt newValue) throws PersistenceException ;
    public abstract PersistentKonkreteKostenArt getThis() throws PersistenceException ;
    
    public void accept(KonkreteKostenArtVisitor visitor) throws PersistenceException;
    public <R> R accept(KonkreteKostenArtReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(KonkreteKostenArtExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(KonkreteKostenArtReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}


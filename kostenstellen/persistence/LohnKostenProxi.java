package persistence;



import model.visitor.*;

public class LohnKostenProxi extends KonkreteKostenArtProxi implements PersistentLohnKosten{
    
    public LohnKostenProxi(long objectId) {
        super(objectId);
    }
    public LohnKostenProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 130;
    }
    
    public PersistentLohnKosten getThis() throws PersistenceException {
        return ((PersistentLohnKosten)this.getTheObject()).getThis();
    }
    
    public void accept(KonkreteKostenArtVisitor visitor) throws PersistenceException {
        visitor.handleLohnKosten(this);
    }
    public <R> R accept(KonkreteKostenArtReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLohnKosten(this);
    }
    public <E extends model.UserException>  void accept(KonkreteKostenArtExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLohnKosten(this);
    }
    public <R, E extends model.UserException> R accept(KonkreteKostenArtReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLohnKosten(this);
    }
    public void accept(AbstrakteKostenArtVisitor visitor) throws PersistenceException {
        visitor.handleLohnKosten(this);
    }
    public <R> R accept(AbstrakteKostenArtReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLohnKosten(this);
    }
    public <E extends model.UserException>  void accept(AbstrakteKostenArtExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLohnKosten(this);
    }
    public <R, E extends model.UserException> R accept(AbstrakteKostenArtReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLohnKosten(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleLohnKosten(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLohnKosten(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLohnKosten(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLohnKosten(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLohnKosten(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLohnKosten(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLohnKosten(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLohnKosten(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLohnKosten)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLohnKosten)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLohnKosten)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentLohnKosten)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLohnKosten)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLohnKosten)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLohnKosten)this.getTheObject()).initializeOnInstantiation();
    }

    
}

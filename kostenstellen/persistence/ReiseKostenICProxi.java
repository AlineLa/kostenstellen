package persistence;



import model.visitor.*;

public class ReiseKostenICProxi extends KonkreteKostenArtICProxi implements PersistentReiseKosten{
    
    public ReiseKostenICProxi(long objectId) {
        super(objectId);
    }
    public ReiseKostenICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theReiseKostenFacade
            .getReiseKosten(this.getId());
    }
    
    public long getClassId() {
        return 122;
    }
    
    public PersistentReiseKosten getThis() throws PersistenceException {
        return ((PersistentReiseKosten)this.getTheObject()).getThis();
    }
    
    public void accept(KonkreteKostenArtVisitor visitor) throws PersistenceException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(KonkreteKostenArtReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends model.UserException>  void accept(KonkreteKostenArtExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends model.UserException> R accept(KonkreteKostenArtReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReiseKosten(this);
    }
    public void accept(AbstrakteKostenArtVisitor visitor) throws PersistenceException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(AbstrakteKostenArtReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends model.UserException>  void accept(AbstrakteKostenArtExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends model.UserException> R accept(AbstrakteKostenArtReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReiseKosten(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReiseKosten(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReiseKosten(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentReiseKosten)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentReiseKosten)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentReiseKosten)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentReiseKosten)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentReiseKosten)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentReiseKosten)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentReiseKosten)this.getTheObject()).initializeOnInstantiation();
    }

    
}

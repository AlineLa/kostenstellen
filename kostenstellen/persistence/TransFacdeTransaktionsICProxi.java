package persistence;



import model.visitor.*;

public class TransFacdeTransaktionsICProxi extends PersistentInCacheProxiOptimistic implements PersistentTransFacdeTransaktions{
    
    public TransFacdeTransaktionsICProxi(long objectId) {
        super(objectId);
    }
    public TransFacdeTransaktionsICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade
            .getTransFacdeTransaktions(this.getId());
    }
    
    public long getClassId() {
        return 116;
    }
    
    public PersistentTransFacde getObserver() throws PersistenceException {
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentTransFacde newValue) throws PersistenceException {
        ((PersistentTransFacdeTransaktions)this.getTheObject()).setObserver(newValue);
    }
    public TransFacdeTransaktions_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).getObservee();
    }
    public PersistentTransFacdeTransaktions getThis() throws PersistenceException {
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransFacdeTransaktions(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransFacdeTransaktions(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransFacdeTransaktions(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransFacdeTransaktions(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransFacdeTransaktions(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransFacdeTransaktions(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransFacdeTransaktions(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransFacdeTransaktions(this);
    }
    
    
    public void add(final PersistentTransaktion observee) 
				throws PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).add(observee);
    }
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<PersistentTransaktion,R,E> aggregtion) 
				throws E, PersistenceException{
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentTransaktion,R> aggregtion) 
				throws PersistenceException{
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).aggregate(aggregtion);
    }
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<PersistentTransaktion,E> procdure) 
				throws E, PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentTransaktion> procdure) 
				throws PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).applyToAll(procdure);
    }
    public <E extends model.UserException> void filterException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).filter(predcate);
    }
    public <E extends model.UserException> SearchListRoot<PersistentTransaktion> findAllException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).findAllException(predcate);
    }
    public SearchListRoot<PersistentTransaktion> findAll(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).findAll(predcate);
    }
    public <E extends model.UserException> PersistentTransaktion findFirstException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).findFirstException(predcate);
    }
    public PersistentTransaktion findFirst(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).findFirst(predcate);
    }
    public java.util.Iterator<PersistentTransaktion> iterator() 
				throws PersistenceException{
        return ((PersistentTransFacdeTransaktions)this.getTheObject()).iterator();
    }
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).removeFirstFailure(predcate);
    }
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransFacdeTransaktions)this.getTheObject()).update(event);
    }

    
}

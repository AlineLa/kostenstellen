package persistence;


import model.visitor.*;

public interface PersistentTransFacdeTransaktions extends Anything, ObsInterface, AbstractPersistentProxi {
    
    public PersistentTransFacde getObserver() throws PersistenceException ;
    public void setObserver(PersistentTransFacde newValue) throws PersistenceException ;
    public TransFacdeTransaktions_ObserveeProxi getObservee() throws PersistenceException ;
    public PersistentTransFacdeTransaktions getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void add(final PersistentTransaktion observee) 
				throws PersistenceException;
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<PersistentTransaktion,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<PersistentTransaktion,R> aggregtion) 
				throws PersistenceException;
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<PersistentTransaktion,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<PersistentTransaktion> procdure) 
				throws PersistenceException;
    public <E extends model.UserException> void filterException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> SearchListRoot<PersistentTransaktion> findAllException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<PersistentTransaktion> findAll(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> PersistentTransaktion findFirstException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException;
    public PersistentTransaktion findFirst(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException;
    public java.util.Iterator<PersistentTransaktion> iterator() 
				throws PersistenceException;
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}


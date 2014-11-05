
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class TransFacdeTransaktions extends PersistentObject implements PersistentTransFacdeTransaktions{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentTransFacdeTransaktions getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade.getClass(objectId);
        return (PersistentTransFacdeTransaktions)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentTransFacdeTransaktions createTransFacdeTransaktions() throws PersistenceException{
        return createTransFacdeTransaktions(false);
    }
    
    public static PersistentTransFacdeTransaktions createTransFacdeTransaktions(boolean delayed$Persistence) throws PersistenceException {
        PersistentTransFacdeTransaktions result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade
                .newDelayedTransFacdeTransaktions();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade
                .newTransFacdeTransaktions(-1);
        }
        while (!(result instanceof TransFacdeTransaktions)) result = (PersistentTransFacdeTransaktions)result.getTheObject();
        ((TransFacdeTransaktions)result).setThis(result);
        return result;
    }
    
    public TransFacdeTransaktions provideCopy() throws PersistenceException{
        TransFacdeTransaktions result = this;
        result = new TransFacdeTransaktions(this.observer, 
                                            this.This, 
                                            this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentTransFacde observer;
    protected TransFacdeTransaktions_ObserveeProxi observee;
    protected PersistentTransFacdeTransaktions This;
    
    public TransFacdeTransaktions(PersistentTransFacde observer,PersistentTransFacdeTransaktions This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = new TransFacdeTransaktions_ObserveeProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 116) ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade
            .newTransFacdeTransaktions(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade.observerSet(this.getId(), getObserver());
        }
        this.getObservee().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentTransFacde getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(PersistentTransFacde newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentTransFacde)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade.observerSet(this.getId(), newValue);
        }
    }
    public TransFacdeTransaktions_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentTransFacdeTransaktions newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentTransFacdeTransaktions)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentTransFacdeTransaktions getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransFacdeTransaktions result = (PersistentTransFacdeTransaktions)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTransFacdeTransaktions)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final PersistentTransaktion observee) 
				throws PersistenceException{
        this.getObservee().add(observee);
    }
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<PersistentTransaktion,R,E> aggregtion) 
				throws E, PersistenceException{
        return this.getObservee().aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<PersistentTransaktion,R> aggregtion) 
				throws PersistenceException{
        return this.getObservee().aggregate(aggregtion);
    }
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<PersistentTransaktion,E> procdure) 
				throws E, PersistenceException{
        this.getObservee().applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<PersistentTransaktion> procdure) 
				throws PersistenceException{
        this.getObservee().applyToAll(procdure);
    }
    public <E extends model.UserException> void filterException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().filterException(predcate);
    }
    public void filter(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        this.getObservee().filter(predcate);
    }
    public <E extends model.UserException> SearchListRoot<PersistentTransaktion> findAllException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findAllException(predcate);
    }
    public SearchListRoot<PersistentTransaktion> findAll(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        return this.getObservee().findAll(predcate);
    }
    public <E extends model.UserException> PersistentTransaktion findFirstException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findFirstException(predcate);
    }
    public PersistentTransaktion findFirst(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        return this.getObservee().findFirst(predcate);
    }
    public java.util.Iterator<PersistentTransaktion> iterator() 
				throws PersistenceException{
        return this.getObservee().iterator();
    }
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstFailure(predcate);
    }
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<PersistentTransaktion,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<PersistentTransaktion> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().transaktions_update((model.meta.TransaktionMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

package persistence;



import model.visitor.*;

public class TransaktionProxi extends PersistentProxi implements PersistentTransaktion{
    
    public TransaktionProxi(long objectId) {
        super(objectId);
    }
    public TransaktionProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 112;
    }
    
    public Transaktion_TransfersProxi getTransfers() throws PersistenceException {
        return ((PersistentTransaktion)this.getTheObject()).getTransfers();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTransaktion)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTransaktion)this.getTheObject()).setSubService(newValue);
    }
    public PersistentTransaktion getThis() throws PersistenceException {
        return ((PersistentTransaktion)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransaktion(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaktion(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaktion(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaktion(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransaktion(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaktion(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaktion(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaktion(this);
    }
    
    
    public void bucheKonto(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).bucheKonto(invoker);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).updateObservers(event);
    }
    public void bucheKonto() 
				throws model.MinimumException, PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).bucheKonto();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransaktion)this.getTheObject()).initializeOnInstantiation();
    }

    
}

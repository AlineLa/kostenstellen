package persistence;



import model.visitor.*;

public class TransFacdeProxi extends PersistentProxi implements PersistentTransFacde{
    
    public TransFacdeProxi(long objectId) {
        super(objectId);
    }
    public TransFacdeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 129;
    }
    
    public void setTransaktions(PersistentTransFacdeTransaktions newValue) throws PersistenceException {
        ((PersistentTransFacde)this.getTheObject()).setTransaktions(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTransFacde)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTransFacde)this.getTheObject()).setSubService(newValue);
    }
    public PersistentTransFacde getThis() throws PersistenceException {
        return ((PersistentTransFacde)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransFacde(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransFacde(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransFacde(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransFacde(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransFacde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransFacde(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransFacde(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransFacde(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).deregister(observee);
    }
    public void erzeugeTransaktion(final String KontoID, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).erzeugeTransaktion(KontoID, invoker);
    }
    public PersistentServer getMyTransaktionVoice() 
				throws PersistenceException{
        return ((PersistentTransFacde)this.getTheObject()).getMyTransaktionVoice();
    }
    public PersistentTransFacdeTransaktions getTransaktions() 
				throws PersistenceException{
        return ((PersistentTransFacde)this.getTheObject()).getTransaktions();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void erzeugeTransaktion(final String KontoID) 
				throws model.DoubleDefinition, PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).erzeugeTransaktion(KontoID);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).initializeOnInstantiation();
    }
    public void transaktions_update(final model.meta.TransaktionMssgs event) 
				throws PersistenceException{
        ((PersistentTransFacde)this.getTheObject()).transaktions_update(event);
    }

    
}

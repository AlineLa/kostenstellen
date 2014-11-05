package persistence;



import model.visitor.*;

public class TransferICProxi extends PersistentInCacheProxiOptimistic implements PersistentTransfer{
    
    public TransferICProxi(long objectId) {
        super(objectId);
    }
    public TransferICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTransferFacade
            .getTransfer(this.getId());
    }
    
    public long getClassId() {
        return 118;
    }
    
    public PersistentKonto getVonKonto() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getVonKonto();
    }
    public void setVonKonto(PersistentKonto newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setVonKonto(newValue);
    }
    public PersistentKonto getZuKonto() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getZuKonto();
    }
    public void setZuKonto(PersistentKonto newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setZuKonto(newValue);
    }
    public long getSumme() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getSumme();
    }
    public void setSumme(long newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setSumme(newValue);
    }
    public String getKontoID() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getKontoID();
    }
    public void setKontoID(String newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setKontoID(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTransfer)this.getTheObject()).setSubService(newValue);
    }
    public PersistentTransfer getThis() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).updateObservers(event);
    }
    public void bucheKonto() 
				throws model.MinimumException, PersistenceException{
        ((PersistentTransfer)this.getTheObject()).bucheKonto();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initializeOnInstantiation();
    }

    
}

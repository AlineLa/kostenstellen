package persistence;



import model.visitor.*;

public class KontoFcdICProxi extends PersistentInCacheProxiOptimistic implements PersistentKontoFcd{
    
    public KontoFcdICProxi(long objectId) {
        super(objectId);
    }
    public KontoFcdICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade
            .getKontoFcd(this.getId());
    }
    
    public long getClassId() {
        return 127;
    }
    
    public KontoFcd_KontenProxi getKonten() throws PersistenceException {
        return ((PersistentKontoFcd)this.getTheObject()).getKonten();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentKontoFcd)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentKontoFcd)this.getTheObject()).setSubService(newValue);
    }
    public PersistentKontoFcd getThis() throws PersistenceException {
        return ((PersistentKontoFcd)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleKontoFcd(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKontoFcd(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKontoFcd(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKontoFcd(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleKontoFcd(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKontoFcd(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKontoFcd(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKontoFcd(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).deregister(observee);
    }
    public void erzeugeKonto(final String KontoID, final long Kontostand, final long Minimum, final long Grenzwert, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).erzeugeKonto(KontoID, Kontostand, Minimum, Grenzwert, invoker);
    }
    public void findeKonto(final String KontoID, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).findeKonto(KontoID, invoker);
    }
    public PersistentServer getMyMastersVoice() 
				throws PersistenceException{
        return ((PersistentKontoFcd)this.getTheObject()).getMyMastersVoice();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void erzeugeKonto(final String KontoID, final long Kontostand, final long Minimum, final long Grenzwert) 
				throws model.DoubleDefinition, PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).erzeugeKonto(KontoID, Kontostand, Minimum, Grenzwert);
    }
    public void findeKonto(final String KontoID) 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).findeKonto(KontoID);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentKontoFcd)this.getTheObject()).initializeOnInstantiation();
    }

    
}

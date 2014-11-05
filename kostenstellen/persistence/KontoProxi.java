package persistence;



import model.visitor.*;

public class KontoProxi extends PersistentProxi implements PersistentKonto{
    
    public KontoProxi(long objectId) {
        super(objectId);
    }
    public KontoProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 126;
    }
    
    public String getKontoID() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getKontoID();
    }
    public void setKontoID(String newValue) throws PersistenceException {
        ((PersistentKonto)this.getTheObject()).setKontoID(newValue);
    }
    public long getGrenzwert() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getGrenzwert();
    }
    public void setGrenzwert(long newValue) throws PersistenceException {
        ((PersistentKonto)this.getTheObject()).setGrenzwert(newValue);
    }
    public long getKontostand() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getKontostand();
    }
    public void setKontostand(long newValue) throws PersistenceException {
        ((PersistentKonto)this.getTheObject()).setKontostand(newValue);
    }
    public long getMinimum() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getMinimum();
    }
    public void setMinimum(long newValue) throws PersistenceException {
        ((PersistentKonto)this.getTheObject()).setMinimum(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentKonto)this.getTheObject()).setSubService(newValue);
    }
    public PersistentKonto getThis() throws PersistenceException {
        return ((PersistentKonto)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleKonto(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKonto(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKonto(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleKonto(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKonto(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKonto(this);
    }
    
    
    public void credit(final long Kontostand) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).credit(Kontostand);
    }
    public void debit(final long Kontostand) 
				throws model.MinimumException, PersistenceException{
        ((PersistentKonto)this.getTheObject()).debit(Kontostand);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void creditImplementation(final long Kontostand) 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).creditImplementation(Kontostand);
    }
    public void debitImplementation(final long Kontostand) 
				throws model.MinimumException, PersistenceException{
        ((PersistentKonto)this.getTheObject()).debitImplementation(Kontostand);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentKonto)this.getTheObject()).initializeOnInstantiation();
    }

    
}

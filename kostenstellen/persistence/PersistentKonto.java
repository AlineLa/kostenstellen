package persistence;


import model.visitor.*;

public interface PersistentKonto extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public String getKontoID() throws PersistenceException ;
    public void setKontoID(String newValue) throws PersistenceException ;
    public long getGrenzwert() throws PersistenceException ;
    public void setGrenzwert(long newValue) throws PersistenceException ;
    public long getKontostand() throws PersistenceException ;
    public void setKontostand(long newValue) throws PersistenceException ;
    public long getMinimum() throws PersistenceException ;
    public void setMinimum(long newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentKonto getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void credit(final long Kontostand) 
				throws PersistenceException;
    public void debit(final long Kontostand) 
				throws model.MinimumException, PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void creditImplementation(final long Kontostand) 
				throws PersistenceException;
    public void debitImplementation(final long Kontostand) 
				throws model.MinimumException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}


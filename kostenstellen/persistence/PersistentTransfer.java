package persistence;


import model.visitor.*;

public interface PersistentTransfer extends SubjInterface, Anything, AbstractPersistentProxi {
    
    public PersistentKonto getVonKonto() throws PersistenceException ;
    public void setVonKonto(PersistentKonto newValue) throws PersistenceException ;
    public PersistentKonto getZuKonto() throws PersistenceException ;
    public void setZuKonto(PersistentKonto newValue) throws PersistenceException ;
    public long getSumme() throws PersistenceException ;
    public void setSumme(long newValue) throws PersistenceException ;
    public String getKontoID() throws PersistenceException ;
    public void setKontoID(String newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public PersistentTransfer getThis() throws PersistenceException ;
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void bucheKonto() 
				throws model.MinimumException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}


package persistence;


import model.visitor.*;

public interface PersistentServer extends Invoker, Remote, SubjInterface, Anything, AbstractPersistentProxi {
    
    public PersistentArtenManager getArten() throws PersistenceException ;
    public void setArten(PersistentArtenManager newValue) throws PersistenceException ;
    public PersistentKontoFcd getManager() throws PersistenceException ;
    public void setManager(PersistentKontoFcd newValue) throws PersistenceException ;
    public PersistentTransFacde getTransaktionManager() throws PersistenceException ;
    public void setTransaktionManager(PersistentTransFacde newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public Server_ErrorsProxi getErrors() throws PersistenceException ;
    public String getPassword() throws PersistenceException ;
    public void setPassword(String newValue) throws PersistenceException ;
    public String getUser() throws PersistenceException ;
    public void setUser(String newValue) throws PersistenceException ;
    public long getHackCount() throws PersistenceException ;
    public void setHackCount(long newValue) throws PersistenceException ;
    public java.sql.Timestamp getHackDelay() throws PersistenceException ;
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException ;
    public PersistentServer getThis() throws PersistenceException ;
    
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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
    public String server_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void bucheKonto(final PersistentKonto vonKonto, final PersistentKonto zuKonto, final long Summe) 
				throws model.MinimumException, PersistenceException;
    public void buchen(final PersistentTransaktion transaktion) 
				throws model.MinimumException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void erzeugeKonto(final String KontoID, final long Kontostand, final long Minimum, final long Grenzwert) 
				throws PersistenceException;
    public void erzeugeTransaktion(final String KontoID) 
				throws PersistenceException;
    public void findeKonto(final String KontoID) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public void hinzufügenTransfer(final PersistentTransaktion transaktion, final PersistentKonto vonKonto, final PersistentKonto zuKonto, final long Summe) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void reportErrors() 
				throws model.MinimumException, PersistenceException;
    public void schließeKonto() 
				throws PersistenceException;

}


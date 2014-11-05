package persistence;



import model.visitor.*;

public class ErzeugeTransaktionCommandICProxi extends PersistentInCacheProxi implements PersistentErzeugeTransaktionCommand{
    
    public ErzeugeTransaktionCommandICProxi(long objectId) {
        super(objectId);
    }
    public ErzeugeTransaktionCommandICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theErzeugeTransaktionCommandFacade
            .getErzeugeTransaktionCommand(this.getId());
    }
    
    public long getClassId() {
        return 113;
    }
    
    public String getKontoID() throws PersistenceException {
        return ((PersistentErzeugeTransaktionCommand)this.getTheObject()).getKontoID();
    }
    public void setKontoID(String newValue) throws PersistenceException {
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).setKontoID(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentErzeugeTransaktionCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentTransFacde getCommandReceiver() throws PersistenceException {
        return ((PersistentErzeugeTransaktionCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentTransFacde newValue) throws PersistenceException {
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentErzeugeTransaktionCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentErzeugeTransaktionCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentErzeugeTransaktionCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleErzeugeTransaktionCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErzeugeTransaktionCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErzeugeTransaktionCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErzeugeTransaktionCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleErzeugeTransaktionCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErzeugeTransaktionCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErzeugeTransaktionCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErzeugeTransaktionCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleErzeugeTransaktionCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErzeugeTransaktionCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErzeugeTransaktionCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErzeugeTransaktionCommand(this);
    }
    public void accept(TransFacdeCommandVisitor visitor) throws PersistenceException {
        visitor.handleErzeugeTransaktionCommand(this);
    }
    public <R> R accept(TransFacdeCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErzeugeTransaktionCommand(this);
    }
    public <E extends model.UserException>  void accept(TransFacdeCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErzeugeTransaktionCommand(this);
    }
    public <R, E extends model.UserException> R accept(TransFacdeCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErzeugeTransaktionCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentErzeugeTransaktionCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentErzeugeTransaktionCommand)this.getTheObject()).sendResult();
    }

    
}

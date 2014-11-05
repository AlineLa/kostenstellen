package persistence;



import model.visitor.*;

public class BucheKontoCommandProxi extends PersistentProxi implements PersistentBucheKontoCommand{
    
    public BucheKontoCommandProxi(long objectId) {
        super(objectId);
    }
    public BucheKontoCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 120;
    }
    
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentBucheKontoCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentBucheKontoCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentTransaktion getCommandReceiver() throws PersistenceException {
        return ((PersistentBucheKontoCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentTransaktion newValue) throws PersistenceException {
        ((PersistentBucheKontoCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentBucheKontoCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentBucheKontoCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentBucheKontoCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentBucheKontoCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentBucheKontoCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentBucheKontoCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleBucheKontoCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBucheKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBucheKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBucheKontoCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBucheKontoCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBucheKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBucheKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBucheKontoCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleBucheKontoCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBucheKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBucheKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBucheKontoCommand(this);
    }
    public void accept(TransaktionCommandVisitor visitor) throws PersistenceException {
        visitor.handleBucheKontoCommand(this);
    }
    public <R> R accept(TransaktionCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBucheKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(TransaktionCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBucheKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(TransaktionCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBucheKontoCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentBucheKontoCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentBucheKontoCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentBucheKontoCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentBucheKontoCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentBucheKontoCommand)this.getTheObject()).sendResult();
    }

    
}

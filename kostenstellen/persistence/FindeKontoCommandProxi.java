package persistence;



import model.visitor.*;

public class FindeKontoCommandProxi extends PersistentProxi implements PersistentFindeKontoCommand{
    
    public FindeKontoCommandProxi(long objectId) {
        super(objectId);
    }
    public FindeKontoCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 114;
    }
    
    public String getKontoID() throws PersistenceException {
        return ((PersistentFindeKontoCommand)this.getTheObject()).getKontoID();
    }
    public void setKontoID(String newValue) throws PersistenceException {
        ((PersistentFindeKontoCommand)this.getTheObject()).setKontoID(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentFindeKontoCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentFindeKontoCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentKontoFcd getCommandReceiver() throws PersistenceException {
        return ((PersistentFindeKontoCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentKontoFcd newValue) throws PersistenceException {
        ((PersistentFindeKontoCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentFindeKontoCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentFindeKontoCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentFindeKontoCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentFindeKontoCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentFindeKontoCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentFindeKontoCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleFindeKontoCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFindeKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFindeKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFindeKontoCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFindeKontoCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFindeKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFindeKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFindeKontoCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleFindeKontoCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFindeKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFindeKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFindeKontoCommand(this);
    }
    public void accept(KontoFcdCommandVisitor visitor) throws PersistenceException {
        visitor.handleFindeKontoCommand(this);
    }
    public <R> R accept(KontoFcdCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFindeKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(KontoFcdCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFindeKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(KontoFcdCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFindeKontoCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentFindeKontoCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentFindeKontoCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentFindeKontoCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentFindeKontoCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentFindeKontoCommand)this.getTheObject()).sendResult();
    }

    
}

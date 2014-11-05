package persistence;



import model.visitor.*;

public class ErzeugeKontoCommandProxi extends PersistentProxi implements PersistentErzeugeKontoCommand{
    
    public ErzeugeKontoCommandProxi(long objectId) {
        super(objectId);
    }
    public ErzeugeKontoCommandProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 119;
    }
    
    public String getKontoID() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getKontoID();
    }
    public void setKontoID(String newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setKontoID(newValue);
    }
    public long getKontostand() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getKontostand();
    }
    public void setKontostand(long newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setKontostand(newValue);
    }
    public long getMinimum() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getMinimum();
    }
    public void setMinimum(long newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setMinimum(newValue);
    }
    public long getGrenzwert() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getGrenzwert();
    }
    public void setGrenzwert(long newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setGrenzwert(newValue);
    }
    public Invoker getInvoker() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getInvoker();
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setInvoker(newValue);
    }
    public PersistentKontoFcd getCommandReceiver() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getCommandReceiver();
    }
    public void setCommandReceiver(PersistentKontoFcd newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setCommandReceiver(newValue);
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getMyCommonDate();
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setMyCommonDate(newValue);
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentErzeugeKontoCommand)this.getTheObject()).setCommitDate(newValue);
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleErzeugeKontoCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErzeugeKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErzeugeKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErzeugeKontoCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleErzeugeKontoCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErzeugeKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErzeugeKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErzeugeKontoCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleErzeugeKontoCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErzeugeKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErzeugeKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErzeugeKontoCommand(this);
    }
    public void accept(KontoFcdCommandVisitor visitor) throws PersistenceException {
        visitor.handleErzeugeKontoCommand(this);
    }
    public <R> R accept(KontoFcdCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErzeugeKontoCommand(this);
    }
    public <E extends model.UserException>  void accept(KontoFcdCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErzeugeKontoCommand(this);
    }
    public <R, E extends model.UserException> R accept(KontoFcdCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErzeugeKontoCommand(this);
    }
    
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        ((PersistentErzeugeKontoCommand)this.getTheObject()).checkException();
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentErzeugeKontoCommand)this.getTheObject()).execute();
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return ((PersistentErzeugeKontoCommand)this.getTheObject()).fetchInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentErzeugeKontoCommand)this.getTheObject()).sendException(exception);
    }
    public void sendResult() 
				throws PersistenceException{
        ((PersistentErzeugeKontoCommand)this.getTheObject()).sendResult();
    }

    
}

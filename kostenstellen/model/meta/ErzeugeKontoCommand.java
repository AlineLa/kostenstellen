
package model.meta;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ErzeugeKontoCommand extends PersistentObject implements PersistentErzeugeKontoCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentErzeugeKontoCommand getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.getClass(objectId);
        return (PersistentErzeugeKontoCommand)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentErzeugeKontoCommand createErzeugeKontoCommand(String KontoID,long Kontostand,long Minimum,long Grenzwert,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createErzeugeKontoCommand(KontoID,Kontostand,Minimum,Grenzwert,createDate,commitDate,false);
    }
    
    public static PersistentErzeugeKontoCommand createErzeugeKontoCommand(String KontoID,long Kontostand,long Minimum,long Grenzwert,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (KontoID == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentErzeugeKontoCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade
                .newDelayedErzeugeKontoCommand(KontoID,Kontostand,Minimum,Grenzwert);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade
                .newErzeugeKontoCommand(KontoID,Kontostand,Minimum,Grenzwert,-1);
        }
        result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected String KontoID;
    protected long Kontostand;
    protected long Minimum;
    protected long Grenzwert;
    protected Invoker invoker;
    protected PersistentKontoFcd commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public ErzeugeKontoCommand(String KontoID,long Kontostand,long Minimum,long Grenzwert,Invoker invoker,PersistentKontoFcd commandReceiver,PersistentCommonDate myCommonDate,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.KontoID = KontoID;
        this.Kontostand = Kontostand;
        this.Minimum = Minimum;
        this.Grenzwert = Grenzwert;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 119;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 119) ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade
            .newErzeugeKontoCommand(KontoID,Kontostand,Minimum,Grenzwert,this.getId());
        super.store();
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public String getKontoID() throws PersistenceException {
        return this.KontoID;
    }
    public void setKontoID(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.KontoIDSet(this.getId(), newValue);
        this.KontoID = newValue;
    }
    public long getKontostand() throws PersistenceException {
        return this.Kontostand;
    }
    public void setKontostand(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.KontostandSet(this.getId(), newValue);
        this.Kontostand = newValue;
    }
    public long getMinimum() throws PersistenceException {
        return this.Minimum;
    }
    public void setMinimum(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.MinimumSet(this.getId(), newValue);
        this.Minimum = newValue;
    }
    public long getGrenzwert() throws PersistenceException {
        return this.Grenzwert;
    }
    public void setGrenzwert(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.GrenzwertSet(this.getId(), newValue);
        this.Grenzwert = newValue;
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public PersistentKontoFcd getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(PersistentKontoFcd newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentKontoFcd)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theErzeugeKontoCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return this.getMyCommonDate().getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return this.getMyCommonDate().getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        this.getMyCommonDate().setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getCommandReceiver() != null) return 1;
        return 0;
    }
    
    
    
    
    // Start of section that contains operations that must be implemented.
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        try{
			this.getCommandReceiver().erzeugeKonto(this.getKontoID(), this.getKontostand(), this.getMinimum(), this.getGrenzwert());
		}
		catch(model.DoubleDefinition e){
			this.commandException = e;
		}
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

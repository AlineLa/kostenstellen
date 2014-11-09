
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class KontoFcd extends PersistentObject implements PersistentKontoFcd{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentKontoFcd getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade.getClass(objectId);
        return (PersistentKontoFcd)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentKontoFcd createKontoFcd() throws PersistenceException{
        return createKontoFcd(false);
    }
    
    public static PersistentKontoFcd createKontoFcd(boolean delayed$Persistence) throws PersistenceException {
        PersistentKontoFcd result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade
                .newDelayedKontoFcd();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade
                .newKontoFcd(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentKontoFcd createKontoFcd(boolean delayed$Persistence,PersistentKontoFcd This) throws PersistenceException {
        PersistentKontoFcd result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade
                .newDelayedKontoFcd();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade
                .newKontoFcd(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("konten", this.getKonten().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public KontoFcd provideCopy() throws PersistenceException{
        KontoFcd result = this;
        result = new KontoFcd(this.subService, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected KontoFcd_KontenProxi konten;
    protected SubjInterface subService;
    protected PersistentKontoFcd This;
    
    public KontoFcd(SubjInterface subService,PersistentKontoFcd This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.konten = new KontoFcd_KontenProxi(this);
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 127;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 127) ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade
            .newKontoFcd(this.getId());
        super.store();
        this.getKonten().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public KontoFcd_KontenProxi getKonten() throws PersistenceException {
        return this.konten;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentKontoFcd newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentKontoFcd)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentKontoFcd getThis() throws PersistenceException {
        if(this.This == null){
            PersistentKontoFcd result = (PersistentKontoFcd)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentKontoFcd)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getKonten().getLength() > 0) return 1;
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void erzeugeKonto(final String KontoID, final long Kontostand, final long Minimum, final long Grenzwert, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentErzeugeKontoCommand command = model.meta.ErzeugeKontoCommand.createErzeugeKontoCommand(KontoID, Kontostand, Minimum, Grenzwert, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void findeKonto(final String KontoID, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentFindeKontoCommand command = model.meta.FindeKontoCommand.createFindeKontoCommand(KontoID, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public PersistentServer getMyMastersVoice() 
				throws PersistenceException{
        PersistentServer result = null;
		try {
			if (result == null) result = (PersistentServer)ConnectionHandler.getTheConnectionHandler().theServerFacade
							.inverseGetManager(getThis().getId(), getThis().getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentKontoFcd)This);
		if(this.isTheSameAs(This)){
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void erzeugeKonto(final String KontoID, final long Kontostand, final long Minimum, final long Grenzwert) 
				throws model.DoubleDefinition, PersistenceException{
    	KontoSearchList existingIdentifier = Konto.getKontoByKontoID(KontoID);
    	if ( existingIdentifier.getLength() > 0) throw new DoubleDefinition("KontoID existiert schon!");
    	getThis().getKonten().add(Konto.createKonto(KontoID, Kontostand, Minimum, Grenzwert));           
    }
    public void findeKonto(final String KontoID) 
				throws PersistenceException{
        //TODO: implement method: findeKonto
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

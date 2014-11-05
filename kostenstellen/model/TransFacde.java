
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class TransFacde extends PersistentObject implements PersistentTransFacde{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentTransFacde getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade.getClass(objectId);
        return (PersistentTransFacde)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentTransFacde createTransFacde() throws PersistenceException{
        return createTransFacde(false);
    }
    
    public static PersistentTransFacde createTransFacde(boolean delayed$Persistence) throws PersistenceException {
        PersistentTransFacde result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade
                .newDelayedTransFacde();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade
                .newTransFacde(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentTransFacde createTransFacde(boolean delayed$Persistence,PersistentTransFacde This) throws PersistenceException {
        PersistentTransFacde result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade
                .newDelayedTransFacde();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade
                .newTransFacde(-1);
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
            result.put("transaktions", this.getTransaktions().getObservee().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public TransFacde provideCopy() throws PersistenceException{
        TransFacde result = this;
        result = new TransFacde(this.transaktions, 
                                this.subService, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentTransFacdeTransaktions transaktions;
    protected SubjInterface subService;
    protected PersistentTransFacde This;
    
    public TransFacde(PersistentTransFacdeTransaktions transaktions,SubjInterface subService,PersistentTransFacde This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.transaktions = transaktions;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 129) ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade
            .newTransFacde(this.getId());
        super.store();
        if(this.transaktions != null){
            this.transaktions.store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade.transaktionsSet(this.getId(), transaktions);
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public void setTransaktions(PersistentTransFacdeTransaktions newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.transaktions)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.transaktions = (PersistentTransFacdeTransaktions)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade.transaktionsSet(this.getId(), newValue);
        }
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
            ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentTransFacde newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentTransFacde)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransFacdeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentTransFacde getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransFacde result = (PersistentTransFacde)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTransFacde)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransFacde(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransFacde(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransFacde(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransFacde(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransFacde(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransFacde(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransFacde(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransFacde(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getTransaktions().getObservee().getLength() > 0) return 1;
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
    public void erzeugeTransaktion(final String KontoID, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentErzeugeTransaktionCommand command = model.meta.ErzeugeTransaktionCommand.createErzeugeTransaktionCommand(KontoID, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public PersistentServer getMyTransaktionVoice() 
				throws PersistenceException{
        PersistentServer result = null;
		try {
			if (result == null) result = (PersistentServer)ConnectionHandler.getTheConnectionHandler().theServerFacade
							.inverseGetTransaktionManager(getThis().getId(), getThis().getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public PersistentTransFacdeTransaktions getTransaktions() 
				throws PersistenceException{
        if (this.transaktions == null) {
			this.setTransaktions(model.TransFacdeTransaktions.createTransFacdeTransaktions(this.isDelayed$Persistence()));
			this.transaktions.setObserver(this);
		}
		return this.transaktions;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTransFacde)This);
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
    public void erzeugeTransaktion(final String KontoID) 
				throws model.DoubleDefinition, PersistenceException{
        //TODO: implement method: erzeugeTransaktion
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void transaktions_update(final model.meta.TransaktionMssgs event) 
				throws PersistenceException{
        //TODO: implement method: transaktions_update
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

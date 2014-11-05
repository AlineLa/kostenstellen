
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Transfer extends PersistentObject implements PersistentTransfer{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentTransfer getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theTransferFacade.getClass(objectId);
        return (PersistentTransfer)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentTransfer createTransfer() throws PersistenceException{
        return createTransfer(false);
    }
    
    public static PersistentTransfer createTransfer(boolean delayed$Persistence) throws PersistenceException {
        PersistentTransfer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newDelayedTransfer(0,"");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newTransfer(0,"",-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentTransfer createTransfer(boolean delayed$Persistence,PersistentTransfer This) throws PersistenceException {
        PersistentTransfer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newDelayedTransfer(0,"");
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newTransfer(0,"",-1);
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
            AbstractPersistentRoot vonKonto = (AbstractPersistentRoot)this.getVonKonto();
            if (vonKonto != null) {
                result.put("vonKonto", vonKonto.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    vonKonto.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && vonKonto.hasEssentialFields())vonKonto.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot zuKonto = (AbstractPersistentRoot)this.getZuKonto();
            if (zuKonto != null) {
                result.put("zuKonto", zuKonto.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    zuKonto.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && zuKonto.hasEssentialFields())zuKonto.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("Summe", new Long(this.getSumme()).toString());
            result.put("KontoID", this.getKontoID());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Transfer provideCopy() throws PersistenceException{
        Transfer result = this;
        result = new Transfer(this.vonKonto, 
                              this.zuKonto, 
                              this.Summe, 
                              this.KontoID, 
                              this.subService, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentKonto vonKonto;
    protected PersistentKonto zuKonto;
    protected long Summe;
    protected String KontoID;
    protected SubjInterface subService;
    protected PersistentTransfer This;
    
    public Transfer(PersistentKonto vonKonto,PersistentKonto zuKonto,long Summe,String KontoID,SubjInterface subService,PersistentTransfer This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.vonKonto = vonKonto;
        this.zuKonto = zuKonto;
        this.Summe = Summe;
        this.KontoID = KontoID;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 118) ConnectionHandler.getTheConnectionHandler().theTransferFacade
            .newTransfer(Summe,KontoID,this.getId());
        super.store();
        if(this.getVonKonto() != null){
            this.getVonKonto().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.vonKontoSet(this.getId(), getVonKonto());
        }
        if(this.getZuKonto() != null){
            this.getZuKonto().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.zuKontoSet(this.getId(), getZuKonto());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentKonto getVonKonto() throws PersistenceException {
        return this.vonKonto;
    }
    public void setVonKonto(PersistentKonto newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.vonKonto)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.vonKonto = (PersistentKonto)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.vonKontoSet(this.getId(), newValue);
        }
    }
    public PersistentKonto getZuKonto() throws PersistenceException {
        return this.zuKonto;
    }
    public void setZuKonto(PersistentKonto newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.zuKonto)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.zuKonto = (PersistentKonto)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.zuKontoSet(this.getId(), newValue);
        }
    }
    public long getSumme() throws PersistenceException {
        return this.Summe;
    }
    public void setSumme(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theTransferFacade.SummeSet(this.getId(), newValue);
        this.Summe = newValue;
    }
    public String getKontoID() throws PersistenceException {
        return this.KontoID;
    }
    public void setKontoID(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theTransferFacade.KontoIDSet(this.getId(), newValue);
        this.KontoID = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentTransfer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentTransfer)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentTransfer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransfer result = (PersistentTransfer)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTransfer)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getVonKonto() != null) return 1;
        if (this.getZuKonto() != null) return 1;
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
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTransfer)This);
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
    
    public void bucheKonto() 
				throws model.MinimumException, PersistenceException{
        //TODO: implement method: bucheKonto
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
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

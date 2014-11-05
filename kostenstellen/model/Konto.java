
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Konto extends PersistentObject implements PersistentKonto{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentKonto getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theKontoFacade.getClass(objectId);
        return (PersistentKonto)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentKonto createKonto(String KontoID,long Grenzwert,long Kontostand,long Minimum) throws PersistenceException{
        return createKonto(KontoID,Grenzwert,Kontostand,Minimum,false);
    }
    
    public static PersistentKonto createKonto(String KontoID,long Grenzwert,long Kontostand,long Minimum,boolean delayed$Persistence) throws PersistenceException {
        if (KontoID == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentKonto result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newDelayedKonto(KontoID,Grenzwert,Kontostand,Minimum);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newKonto(KontoID,Grenzwert,Kontostand,Minimum,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("KontoID", KontoID);
        final$$Fields.put("Grenzwert", Grenzwert);
        final$$Fields.put("Kontostand", Kontostand);
        final$$Fields.put("Minimum", Minimum);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentKonto createKonto(String KontoID,long Grenzwert,long Kontostand,long Minimum,boolean delayed$Persistence,PersistentKonto This) throws PersistenceException {
        if (KontoID == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentKonto result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newDelayedKonto(KontoID,Grenzwert,Kontostand,Minimum);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theKontoFacade
                .newKonto(KontoID,Grenzwert,Kontostand,Minimum,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("KontoID", KontoID);
        final$$Fields.put("Grenzwert", Grenzwert);
        final$$Fields.put("Kontostand", Kontostand);
        final$$Fields.put("Minimum", Minimum);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("KontoID", this.getKontoID());
            result.put("Grenzwert", new Long(this.getGrenzwert()).toString());
            result.put("Kontostand", new Long(this.getKontostand()).toString());
            result.put("Minimum", new Long(this.getMinimum()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static KontoSearchList getKontoByKontoID(String KontoID) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theKontoFacade
            .getKontoByKontoID(KontoID);
    }
    
    public Konto provideCopy() throws PersistenceException{
        Konto result = this;
        result = new Konto(this.KontoID, 
                           this.Grenzwert, 
                           this.Kontostand, 
                           this.Minimum, 
                           this.subService, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String KontoID;
    protected long Grenzwert;
    protected long Kontostand;
    protected long Minimum;
    protected SubjInterface subService;
    protected PersistentKonto This;
    
    public Konto(String KontoID,long Grenzwert,long Kontostand,long Minimum,SubjInterface subService,PersistentKonto This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.KontoID = KontoID;
        this.Grenzwert = Grenzwert;
        this.Kontostand = Kontostand;
        this.Minimum = Minimum;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 126) ConnectionHandler.getTheConnectionHandler().theKontoFacade
            .newKonto(KontoID,Grenzwert,Kontostand,Minimum,this.getId());
        super.store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getKontoID() throws PersistenceException {
        return this.KontoID;
    }
    public void setKontoID(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKontoFacade.KontoIDSet(this.getId(), newValue);
        this.KontoID = newValue;
    }
    public long getGrenzwert() throws PersistenceException {
        return this.Grenzwert;
    }
    public void setGrenzwert(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKontoFacade.GrenzwertSet(this.getId(), newValue);
        this.Grenzwert = newValue;
    }
    public long getKontostand() throws PersistenceException {
        return this.Kontostand;
    }
    public void setKontostand(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKontoFacade.KontostandSet(this.getId(), newValue);
        this.Kontostand = newValue;
    }
    public long getMinimum() throws PersistenceException {
        return this.Minimum;
    }
    public void setMinimum(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theKontoFacade.MinimumSet(this.getId(), newValue);
        this.Minimum = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentKonto newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentKonto)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theKontoFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentKonto getThis() throws PersistenceException {
        if(this.This == null){
            PersistentKonto result = (PersistentKonto)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentKonto)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleKonto(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKonto(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKonto(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleKonto(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleKonto(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleKonto(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleKonto(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void credit(final long Kontostand) 
				throws PersistenceException{
        model.meta.KontoCreditIntegerMssg event = new model.meta.KontoCreditIntegerMssg(Kontostand, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void debit(final long Kontostand) 
				throws model.MinimumException, PersistenceException{
        model.meta.KontoDebitIntegerMssg event = new model.meta.KontoDebitIntegerMssg(Kontostand, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
        this.setThis((PersistentKonto)This);
		if(this.isTheSameAs(This)){
			this.setKontoID((String)final$$Fields.get("KontoID"));
			this.setGrenzwert((Long)final$$Fields.get("Grenzwert"));
			this.setKontostand((Long)final$$Fields.get("Kontostand"));
			this.setMinimum((Long)final$$Fields.get("Minimum"));
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
    public void creditImplementation(final long Kontostand) 
				throws PersistenceException{
        //TODO: implement method: creditImplementation
        
    }
    public void debitImplementation(final long Kontostand) 
				throws model.MinimumException, PersistenceException{
        //TODO: implement method: debitImplementation
        
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

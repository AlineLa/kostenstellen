
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ReiseKosten extends model.KonkreteKostenArt implements PersistentReiseKosten{
    
    private static PersistentReiseKosten theReiseKosten = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentReiseKosten getTheReiseKosten() throws PersistenceException{
        if (theReiseKosten == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        PersistentReiseKosten proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theReiseKostenFacade.getTheReiseKosten();
                            theReiseKosten = proxi;
                        }
                        if(proxi.getId() < 0) {
                            ((AbstractPersistentRoot)proxi).setId(proxi.getId() * -1);
                            proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                            proxi.initializeOnCreation();
                        }
                    } catch (PersistenceException e){
                        exception = e;
                    }
                    synchronized ($$lock){$$lock.notify();}
                }
                PersistentReiseKosten getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theReiseKosten;
                }
            }
            synchronized ($$lock) {
                reset$For$Test = false;
                Initializer initializer = new Initializer();
                new Thread(initializer).start();
                try {$$lock.wait();}catch (InterruptedException e) {} //Need not to be interrupted
                return initializer.getResult();
            }
        }
        return theReiseKosten;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ReiseKosten provideCopy() throws PersistenceException{
        ReiseKosten result = this;
        result = new ReiseKosten(this.subService, 
                                 this.This, 
                                 this.speziellerAls, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public ReiseKosten(SubjInterface subService,PersistentAbstrakteKostenArt This,PersistentAbstrakteKostenArt speziellerAls,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentAbstrakteKostenArt)This,(PersistentAbstrakteKostenArt)speziellerAls,id);        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentReiseKosten getThis() throws PersistenceException {
        if(this.This == null){
            PersistentReiseKosten result = (PersistentReiseKosten)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentReiseKosten)this.This;
    }
    
    public void accept(KonkreteKostenArtVisitor visitor) throws PersistenceException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(KonkreteKostenArtReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends model.UserException>  void accept(KonkreteKostenArtExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends model.UserException> R accept(KonkreteKostenArtReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReiseKosten(this);
    }
    public void accept(AbstrakteKostenArtVisitor visitor) throws PersistenceException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(AbstrakteKostenArtReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends model.UserException>  void accept(AbstrakteKostenArtExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends model.UserException> R accept(AbstrakteKostenArtReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReiseKosten(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReiseKosten(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleReiseKosten(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleReiseKosten(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleReiseKosten(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleReiseKosten(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSpeziellerAls() != null) return 1;
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
        this.setThis((PersistentReiseKosten)This);
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
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setSpeziellerAls(AllgemeineKosten.getTheAllgemeineKosten());         
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

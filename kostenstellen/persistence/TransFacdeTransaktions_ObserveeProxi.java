package persistence;

import model.*;

import java.util.Iterator;

public class TransFacdeTransaktions_ObserveeProxi extends PersistentListProxi<PersistentTransaktion> {

  	private TransaktionList list;
  	private TransFacdeTransaktions owner;

  	public TransFacdeTransaktions_ObserveeProxi(TransFacdeTransaktions owner) {
    	this.owner = owner;
  	}
  	public TransaktionList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new TransaktionList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theTransFacdeTransaktionsFacade.observeeGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentTransaktion> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentTransaktion entry) throws PersistenceException {
    	if (entry != null) {
      		TransaktionList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade
        	               	.observeeAdd(owner.getId(), entry);
      		}
      		list.add((PersistentTransaktion)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		entry.register(this.owner);
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade.observeeRem(entry.getListEntryId());
    	}
    	((PersistentTransaktion)entry).deregister(this.owner);
  	}
  	public TransFacdeTransaktions_ObserveeProxi copy(TransFacdeTransaktions owner) throws PersistenceException {
  		TransFacdeTransaktions_ObserveeProxi result = new TransFacdeTransaktions_ObserveeProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentTransaktion> entries = (this.list == null ? new java.util.Vector<PersistentTransaktion>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentTransaktion current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theTransFacdeTransaktionsFacade
            	           .observeeAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}

package persistence;

import model.*;

import java.util.Iterator;

public class ArtenManager_ArtenProxi extends PersistentListProxi<PersistentKonkreteKostenArt> {

  	private KonkreteKostenArtList list;
  	private ArtenManager owner;

  	public ArtenManager_ArtenProxi(ArtenManager owner) {
    	this.owner = owner;
  	}
  	public KonkreteKostenArtList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new KonkreteKostenArtList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theArtenManagerFacade.artenGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentKonkreteKostenArt> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentKonkreteKostenArt entry) throws PersistenceException {
    	if (entry != null) {
      		KonkreteKostenArtList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theArtenManagerFacade
        	               	.artenAdd(owner.getId(), entry);
      		}
      		list.add((PersistentKonkreteKostenArt)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theArtenManagerFacade.artenRem(entry.getListEntryId());
    	}
    	
  	}
  	public ArtenManager_ArtenProxi copy(ArtenManager owner) throws PersistenceException {
  		ArtenManager_ArtenProxi result = new ArtenManager_ArtenProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentKonkreteKostenArt> entries = (this.list == null ? new java.util.Vector<PersistentKonkreteKostenArt>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentKonkreteKostenArt current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theArtenManagerFacade
            	           .artenAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}

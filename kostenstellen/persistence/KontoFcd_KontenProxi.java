package persistence;

import model.*;

import java.util.Iterator;

public class KontoFcd_KontenProxi extends PersistentListProxi<PersistentKonto> {

  	private KontoList list;
  	private KontoFcd owner;

  	public KontoFcd_KontenProxi(KontoFcd owner) {
    	this.owner = owner;
  	}
  	public KontoList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new KontoList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theKontoFcdFacade.kontenGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentKonto> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentKonto entry) throws PersistenceException {
    	if (entry != null) {
      		KontoList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade
        	               	.kontenAdd(owner.getId(), entry);
      		}
      		list.add((PersistentKonto)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade.kontenRem(entry.getListEntryId());
    	}
    	
  	}
  	public KontoFcd_KontenProxi copy(KontoFcd owner) throws PersistenceException {
  		KontoFcd_KontenProxi result = new KontoFcd_KontenProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentKonto> entries = (this.list == null ? new java.util.Vector<PersistentKonto>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentKonto current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theKontoFcdFacade
            	           .kontenAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}

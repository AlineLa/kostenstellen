package persistence;

import model.*;

import java.util.Iterator;

public class Transaktion_TransfersProxi extends PersistentListProxi<PersistentTransfer> {

  	private TransferList list;
  	private Transaktion owner;

  	public Transaktion_TransfersProxi(Transaktion owner) {
    	this.owner = owner;
  	}
  	public TransferList getList() throws PersistenceException{
    	if (this.list == null) {
      		if (this.owner.isDelayed$Persistence()) {
        		this.list = new TransferList();
      		} else {
        		this.list = ConnectionHandler
                		    .getTheConnectionHandler()
                      		.theTransaktionFacade.transfersGet(this.owner.getId());
      		}
    	}
    	return this.list;
  	}
  	public Iterator<PersistentTransfer> iterator() throws PersistenceException{
    	return this.getList().iterator(this);
  	}
  	public long getLength() throws PersistenceException{
	  	return this.getList().getLength();
  	}
  	public void add(PersistentTransfer entry) throws PersistenceException {
    	if (entry != null) {
      		TransferList list = this.getList();
      		long entryId = 0;
      		if (!this.owner.isDelayed$Persistence()) {
        		entry.store();  	
        		entryId = ConnectionHandler.getTheConnectionHandler().theTransaktionFacade
        	               	.transfersAdd(owner.getId(), entry);
      		}
      		list.add((PersistentTransfer)PersistentProxi.createListEntryProxi(entry.getId(),
            		                   entry.getClassId(),
        	    	                   entryId));
      		
    	}
  	}
  	protected void remove(PersistentListEntryProxi entry) throws PersistenceException {
    	if (!this.owner.isDelayed$Persistence()) {
      		ConnectionHandler.getTheConnectionHandler().theTransaktionFacade.transfersRem(entry.getListEntryId());
    	}
    	
  	}
  	public Transaktion_TransfersProxi copy(Transaktion owner) throws PersistenceException {
  		Transaktion_TransfersProxi result = new Transaktion_TransfersProxi(owner);
  		result.list = this.getList().copy();
  		return result;
  	}	 
  	public void store() throws PersistenceException {
  		java.util.Iterator<PersistentTransfer> entries = (this.list == null ? new java.util.Vector<PersistentTransfer>().iterator() : this.list.iterator(this));
  		while (entries.hasNext()){
  			PersistentTransfer current = entries.next();
  			current.store();
      		long entryId = ConnectionHandler.getTheConnectionHandler().theTransaktionFacade
            	           .transfersAdd(owner.getId(), current);
        	((PersistentListEntryProxi)current).setListEntryId(entryId);
		}
	}
}

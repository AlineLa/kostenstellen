package persistence;

import java.util.*;

public class TransferList {

	protected Vector<PersistentTransfer> data; //List of proxies
	protected TransferList() {
		this.data = new Vector<PersistentTransfer>();
	}
	public Iterator<PersistentTransfer> iterator(PersistentListProxi<PersistentTransfer> listProxi) {
		return new PersistentListIterator<PersistentTransfer>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentTransfer entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected TransferList copy() {
		TransferList result = new TransferList();
		result.data = (Vector<PersistentTransfer>)this.data.clone();
		return result;
	}


}



package persistence;

import java.util.*;

public class TransaktionList {

	protected Vector<PersistentTransaktion> data; //List of proxies
	protected TransaktionList() {
		this.data = new Vector<PersistentTransaktion>();
	}
	public Iterator<PersistentTransaktion> iterator(PersistentListProxi<PersistentTransaktion> listProxi) {
		return new PersistentListIterator<PersistentTransaktion>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentTransaktion entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected TransaktionList copy() {
		TransaktionList result = new TransaktionList();
		result.data = (Vector<PersistentTransaktion>)this.data.clone();
		return result;
	}


}



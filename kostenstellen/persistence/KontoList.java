package persistence;

import java.util.*;

public class KontoList  extends KontoSearchList{

	protected KontoList() {
		super();
	}
	public Iterator<PersistentKonto> iterator(PersistentListProxi<PersistentKonto> listProxi) {
		return new PersistentListIterator<PersistentKonto>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentKonto entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected KontoList copy() {
		KontoList result = new KontoList();
		result.data = (Vector<PersistentKonto>)this.data.clone();
		return result;
	}


}



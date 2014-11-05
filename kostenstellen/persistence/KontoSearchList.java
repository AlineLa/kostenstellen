package persistence;

public class KontoSearchList extends SearchListRoot<PersistentKonto> implements Iterable<PersistentKonto> {

	public KontoSearchList(SearchListRoot<PersistentKonto> list){
		super(list);
	}
	public KontoSearchList(){
		super();
	}
	
	public void add (PersistentKonto entry) {
		this.data.add(entry);
	}
	
	public void add(KontoSearchList list) throws PersistenceException{
		java.util.Iterator<PersistentKonto> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<PersistentKonto> iterator() {
		return this.data.iterator();
	}
  
}



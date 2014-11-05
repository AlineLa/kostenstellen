package persistence;

import java.util.*;

public class KonkreteKostenArtList {

	protected Vector<PersistentKonkreteKostenArt> data; //List of proxies
	protected KonkreteKostenArtList() {
		this.data = new Vector<PersistentKonkreteKostenArt>();
	}
	public Iterator<PersistentKonkreteKostenArt> iterator(PersistentListProxi<PersistentKonkreteKostenArt> listProxi) {
		return new PersistentListIterator<PersistentKonkreteKostenArt>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (PersistentKonkreteKostenArt entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	protected KonkreteKostenArtList copy() {
		KonkreteKostenArtList result = new KonkreteKostenArtList();
		result.data = (Vector<PersistentKonkreteKostenArt>)this.data.clone();
		return result;
	}


}



package persistence;

public abstract class KonkreteKostenArtListEntryProxi extends KonkreteKostenArtProxi implements PersistentKonkreteKostenArtListEntryProxi {

  long entryId;

  public KonkreteKostenArtListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}
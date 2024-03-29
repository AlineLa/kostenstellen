package persistence;

public class KostenArtWurzelListEntryProxi extends KostenArtWurzelProxi implements PersistentKostenArtWurzelListEntryProxi {

  long entryId;

  public KostenArtWurzelListEntryProxi(long objectId, long entryId) {
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
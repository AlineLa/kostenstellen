package persistence;

public class KontoListEntryProxi extends KontoProxi implements PersistentKontoListEntryProxi {

  long entryId;

  public KontoListEntryProxi(long objectId, long entryId) {
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
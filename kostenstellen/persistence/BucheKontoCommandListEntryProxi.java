package persistence;

public class BucheKontoCommandListEntryProxi extends BucheKontoCommandProxi implements PersistentBucheKontoCommandListEntryProxi {

  long entryId;

  public BucheKontoCommandListEntryProxi(long objectId, long entryId) {
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
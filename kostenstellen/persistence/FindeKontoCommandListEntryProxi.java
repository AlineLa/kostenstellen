package persistence;

public class FindeKontoCommandListEntryProxi extends FindeKontoCommandProxi implements PersistentFindeKontoCommandListEntryProxi {

  long entryId;

  public FindeKontoCommandListEntryProxi(long objectId, long entryId) {
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
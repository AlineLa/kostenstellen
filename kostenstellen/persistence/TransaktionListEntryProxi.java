package persistence;

public class TransaktionListEntryProxi extends TransaktionProxi implements PersistentTransaktionListEntryProxi {

  long entryId;

  public TransaktionListEntryProxi(long objectId, long entryId) {
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
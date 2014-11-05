package persistence;

public class TransFacdeListEntryProxi extends TransFacdeProxi implements PersistentTransFacdeListEntryProxi {

  long entryId;

  public TransFacdeListEntryProxi(long objectId, long entryId) {
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
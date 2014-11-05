package persistence;

public class TransFacdeTransaktionsListEntryProxi extends TransFacdeTransaktionsProxi implements PersistentTransFacdeTransaktionsListEntryProxi {

  long entryId;

  public TransFacdeTransaktionsListEntryProxi(long objectId, long entryId) {
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
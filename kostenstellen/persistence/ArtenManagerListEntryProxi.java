package persistence;

public class ArtenManagerListEntryProxi extends ArtenManagerProxi implements PersistentArtenManagerListEntryProxi {

  long entryId;

  public ArtenManagerListEntryProxi(long objectId, long entryId) {
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
package persistence;

public class LohnKostenListEntryProxi extends LohnKostenProxi implements PersistentLohnKostenListEntryProxi {

  long entryId;

  public LohnKostenListEntryProxi(long objectId, long entryId) {
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
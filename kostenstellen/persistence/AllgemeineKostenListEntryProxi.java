package persistence;

public class AllgemeineKostenListEntryProxi extends AllgemeineKostenProxi implements PersistentAllgemeineKostenListEntryProxi {

  long entryId;

  public AllgemeineKostenListEntryProxi(long objectId, long entryId) {
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
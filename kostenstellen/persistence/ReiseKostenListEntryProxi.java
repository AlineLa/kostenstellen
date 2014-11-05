package persistence;

public class ReiseKostenListEntryProxi extends ReiseKostenProxi implements PersistentReiseKostenListEntryProxi {

  long entryId;

  public ReiseKostenListEntryProxi(long objectId, long entryId) {
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
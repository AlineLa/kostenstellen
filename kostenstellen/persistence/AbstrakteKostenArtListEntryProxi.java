package persistence;

public abstract class AbstrakteKostenArtListEntryProxi extends AbstrakteKostenArtProxi implements PersistentAbstrakteKostenArtListEntryProxi {

  long entryId;

  public AbstrakteKostenArtListEntryProxi(long objectId, long entryId) {
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
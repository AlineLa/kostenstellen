package persistence;

public class ErzeugeTransaktionCommandListEntryProxi extends ErzeugeTransaktionCommandProxi implements PersistentErzeugeTransaktionCommandListEntryProxi {

  long entryId;

  public ErzeugeTransaktionCommandListEntryProxi(long objectId, long entryId) {
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
package persistence;

public class ErzeugeKontoCommandListEntryProxi extends ErzeugeKontoCommandProxi implements PersistentErzeugeKontoCommandListEntryProxi {

  long entryId;

  public ErzeugeKontoCommandListEntryProxi(long objectId, long entryId) {
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
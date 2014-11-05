
package modelServer;



import persistence.*;

public  class RemoteServer extends RemoteServerMaster {

	protected PersistentServer server;

	public RemoteServer(String connectionName, String userName, PersistentServer server){
		super (connectionName, userName );
        this.server = server;
	}

	protected Remote getServer(){
        return this.server;
    } 

    public synchronized java.util.HashMap<?,?> server_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentServer)this.server).server_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> bucheKonto(String vonKontoProxiString, String zuKontoProxiString, String SummeAsString){
        try {
            PersistentKonto vonKonto = (PersistentKonto)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(vonKontoProxiString));
            PersistentKonto zuKonto = (PersistentKonto)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(zuKontoProxiString));
            long Summe = new Long(SummeAsString).longValue();
            ((PersistentServer)this.server).bucheKonto(vonKonto, zuKonto, Summe);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.MinimumException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> buchen(String transaktionProxiString){
        try {
            PersistentTransaktion transaktion = (PersistentTransaktion)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transaktionProxiString));
            ((PersistentServer)this.server).buchen(transaktion);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.MinimumException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> erzeugeKonto(String KontoID, String KontostandAsString, String MinimumAsString, String GrenzwertAsString){
        try {
            long Kontostand = new Long(KontostandAsString).longValue();
            long Minimum = new Long(MinimumAsString).longValue();
            long Grenzwert = new Long(GrenzwertAsString).longValue();
            ((PersistentServer)this.server).erzeugeKonto(KontoID, Kontostand, Minimum, Grenzwert);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> erzeugeTransaktion(String KontoID){
        try {
            ((PersistentServer)this.server).erzeugeTransaktion(KontoID);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> findeKonto(String KontoID){
        try {
            ((PersistentServer)this.server).findeKonto(KontoID);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> hinzufügenTransfer(String transaktionProxiString, String vonKontoProxiString, String zuKontoProxiString, String SummeAsString){
        try {
            PersistentTransaktion transaktion = (PersistentTransaktion)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transaktionProxiString));
            PersistentKonto vonKonto = (PersistentKonto)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(vonKontoProxiString));
            PersistentKonto zuKonto = (PersistentKonto)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(zuKontoProxiString));
            long Summe = new Long(SummeAsString).longValue();
            ((PersistentServer)this.server).hinzufügenTransfer(transaktion, vonKonto, zuKonto, Summe);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> reportErrors(){
        try {
            ((PersistentServer)this.server).reportErrors();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.MinimumException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> schließeKonto(){
        try {
            ((PersistentServer)this.server).schließeKonto();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}
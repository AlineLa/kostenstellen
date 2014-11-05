package model.meta;

import persistence.PersistenceException;

public class KontoCreditIntegerMssg implements KontoDOWNMssgs,KontoUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentKonto rcvr;
    public final long Kontostand;
    
    public KontoCreditIntegerMssg(long Kontostand,
                                  persistence.PersistentKonto rcvr){
        this.Kontostand = Kontostand;
        this.rcvr = rcvr;
    }
    public void accept(KontoMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleKontoCreditIntegerMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.creditImplementation(this.Kontostand);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}

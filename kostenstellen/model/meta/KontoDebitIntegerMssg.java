package model.meta;

import persistence.PersistenceException;

public class KontoDebitIntegerMssg implements KontoDOWNMssgs,KontoUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentKonto rcvr;
    public final long Kontostand;
    
    public KontoDebitIntegerMssg(long Kontostand,
                                 persistence.PersistentKonto rcvr){
        this.Kontostand = Kontostand;
        this.rcvr = rcvr;
    }
    public void accept(KontoMssgsVisitor visitor) throws persistence.PersistenceException{
        visitor.handleKontoDebitIntegerMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.debitImplementation(this.Kontostand);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.MinimumException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.MinimumException) throw (model.MinimumException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}

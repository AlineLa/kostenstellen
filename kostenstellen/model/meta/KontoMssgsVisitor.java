package model.meta;

public interface KontoMssgsVisitor extends KontoDOWNMssgsVisitor, KontoUPMssgsVisitor {}


interface KontoDOWNMssgsVisitor  {

    public void handleKontoCreditIntegerMssg(KontoCreditIntegerMssg event) throws persistence.PersistenceException;
    public void handleKontoDebitIntegerMssg(KontoDebitIntegerMssg event) throws persistence.PersistenceException;
    
}


interface KontoUPMssgsVisitor  {

    public void handleKontoCreditIntegerMssg(KontoCreditIntegerMssg event) throws persistence.PersistenceException;
    public void handleKontoDebitIntegerMssg(KontoDebitIntegerMssg event) throws persistence.PersistenceException;
    
}

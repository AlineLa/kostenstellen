
package model.visitor;

import persistence.*;

public interface SubjInterfaceVisitor extends AbstrakteKostenArtVisitor{
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException;
    public void handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public void handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException;
    public void handleKonto(PersistentKonto konto) throws PersistenceException;
    public void handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException;
    public void handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException;
    
}

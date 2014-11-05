
package model.visitor;

import persistence.*;

public interface SubjInterfaceExceptionVisitor<E extends model.UserException> extends AbstrakteKostenArtExceptionVisitor<E>{
    
    public void handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public void handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleTransfer(PersistentTransfer transfer) throws PersistenceException, E;
    public void handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException, E;
    public void handleKonto(PersistentKonto konto) throws PersistenceException, E;
    public void handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException, E;
    public void handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException, E;
    
}

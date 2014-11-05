
package model.visitor;

import persistence.*;

public interface SubjInterfaceReturnExceptionVisitor<R, E extends model.UserException> extends AbstrakteKostenArtReturnExceptionVisitor<R, E> {
    
    public R handleSubj(PersistentSubj subj) throws PersistenceException, E;
    public R handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleTransfer(PersistentTransfer transfer) throws PersistenceException, E;
    public R handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException, E;
    public R handleKonto(PersistentKonto konto) throws PersistenceException, E;
    public R handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException, E;
    public R handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException, E;
    
}

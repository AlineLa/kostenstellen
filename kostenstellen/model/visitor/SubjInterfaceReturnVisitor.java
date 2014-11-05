
package model.visitor;

import persistence.*;

public interface SubjInterfaceReturnVisitor<R> extends AbstrakteKostenArtReturnVisitor<R> {
    
    public R handleSubj(PersistentSubj subj) throws PersistenceException;
    public R handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public R handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException;
    public R handleKonto(PersistentKonto konto) throws PersistenceException;
    public R handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException;
    public R handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException;
    
}

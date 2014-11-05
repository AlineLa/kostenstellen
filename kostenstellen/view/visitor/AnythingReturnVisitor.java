
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends AbstrakteKostenArtReturnVisitor<R> {
    
    public R handleTransaktion(TransaktionView transaktion) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleTransfer(TransferView transfer) throws ModelException;
    public R handleArtenManager(ArtenManagerView artenManager) throws ModelException;
    public R handleKonto(KontoView konto) throws ModelException;
    public R handleKontoFcd(KontoFcdView kontoFcd) throws ModelException;
    public R handleTransFacde(TransFacdeView transFacde) throws ModelException;
    
}

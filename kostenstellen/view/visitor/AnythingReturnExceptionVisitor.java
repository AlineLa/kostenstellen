
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends AbstrakteKostenArtReturnExceptionVisitor<R, E> {
    
    public R handleTransaktion(TransaktionView transaktion) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleTransfer(TransferView transfer) throws ModelException, E;
    public R handleArtenManager(ArtenManagerView artenManager) throws ModelException, E;
    public R handleKonto(KontoView konto) throws ModelException, E;
    public R handleKontoFcd(KontoFcdView kontoFcd) throws ModelException, E;
    public R handleTransFacde(TransFacdeView transFacde) throws ModelException, E;
    
}

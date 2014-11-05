
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends AbstrakteKostenArtExceptionVisitor<E>{
    
    public void handleTransaktion(TransaktionView transaktion) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleTransfer(TransferView transfer) throws ModelException, E;
    public void handleArtenManager(ArtenManagerView artenManager) throws ModelException, E;
    public void handleKonto(KontoView konto) throws ModelException, E;
    public void handleKontoFcd(KontoFcdView kontoFcd) throws ModelException, E;
    public void handleTransFacde(TransFacdeView transFacde) throws ModelException, E;
    
}


package view.visitor;

import view.*;

public interface AnythingVisitor extends AbstrakteKostenArtVisitor{
    
    public void handleTransaktion(TransaktionView transaktion) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleTransfer(TransferView transfer) throws ModelException;
    public void handleArtenManager(ArtenManagerView artenManager) throws ModelException;
    public void handleKonto(KontoView konto) throws ModelException;
    public void handleKontoFcd(KontoFcdView kontoFcd) throws ModelException;
    public void handleTransFacde(TransFacdeView transFacde) throws ModelException;
    
}

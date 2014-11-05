
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleTransaktion(PersistentTransaktion transaktion) throws PersistenceException;
    public abstract void handleAllgemeineKosten(PersistentAllgemeineKosten allgemeineKosten) throws PersistenceException;
    public abstract void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleArtenManager(PersistentArtenManager artenManager) throws PersistenceException;
    public abstract void handleReiseKosten(PersistentReiseKosten reiseKosten) throws PersistenceException;
    public abstract void handleKontoFcd(PersistentKontoFcd kontoFcd) throws PersistenceException;
    public abstract void handleKonto(PersistentKonto konto) throws PersistenceException;
    public abstract void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel) throws PersistenceException;
    public abstract void handleTransFacde(PersistentTransFacde transFacde) throws PersistenceException;
    public abstract void handleLohnKosten(PersistentLohnKosten lohnKosten) throws PersistenceException;
    
}

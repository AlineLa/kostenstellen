package model;

import persistence.*;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		result = null;
		anything.accept(this);
		if (result == null) {
			this.standardHandling(anything);
		}
		return result;
	}
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handleTransaktion(PersistentTransaktion transaktion)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleAllgemeineKosten(
			PersistentAllgemeineKosten allgemeineKosten)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTransfer(PersistentTransfer transfer)
			throws PersistenceException {
		result = transfer.getVonKonto().getId() + " --> " + transfer.getZuKonto().getId() + " :  " + transfer.getSumme();		
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		result = "";
		
	}
	@Override
	public void handleArtenManager(PersistentArtenManager artenManager)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleReiseKosten(PersistentReiseKosten reiseKosten)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleKontoFcd(PersistentKontoFcd kontoFcd)
			throws PersistenceException {
		result= "";		
	}
	@Override
	public void handleKonto(PersistentKonto konto) throws PersistenceException {
		result = konto.getKontoID() + " " + konto.getKontostand();		
	}
	@Override
	public void handleKostenArtWurzel(PersistentKostenArtWurzel kostenArtWurzel)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleTransFacde(PersistentTransFacde transFacde)
			throws PersistenceException {
		result = "";
		
	}
	@Override
	public void handleLohnKosten(PersistentLohnKosten lohnKosten)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

}

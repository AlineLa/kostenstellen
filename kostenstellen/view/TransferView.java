package view;

import view.objects.*;

import view.visitor.*;

public interface TransferView extends Anything, AbstractViewRoot {
    
    public KontoView getVonKonto()throws ModelException;
    public void setVonKonto(KontoView newValue) throws ModelException ;
    public KontoView getZuKonto()throws ModelException;
    public void setZuKonto(KontoView newValue) throws ModelException ;
    public long getSumme()throws ModelException;
    public void setSumme(long newValue) throws ModelException ;
    public String getKontoID()throws ModelException;
    public void setKontoID(String newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}


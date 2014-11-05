package view;

import view.objects.*;

import view.visitor.*;

public interface KontoView extends Anything, AbstractViewRoot {
    
    public String getKontoID()throws ModelException;
    public void setKontoID(String newValue) throws ModelException ;
    public long getGrenzwert()throws ModelException;
    public void setGrenzwert(long newValue) throws ModelException ;
    public long getKontostand()throws ModelException;
    public void setKontostand(long newValue) throws ModelException ;
    public long getMinimum()throws ModelException;
    public void setMinimum(long newValue) throws ModelException ;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}


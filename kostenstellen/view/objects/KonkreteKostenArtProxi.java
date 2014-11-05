package view.objects;

import view.*;
import viewClient.*;

public abstract class KonkreteKostenArtProxi extends AbstrakteKostenArtProxi implements KonkreteKostenArtView{
    
    public KonkreteKostenArtProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    public AbstrakteKostenArtView getSpeziellerAls()throws ModelException{
        return ((KonkreteKostenArt)this.getTheObject()).getSpeziellerAls();
    }
    public void setSpeziellerAls(AbstrakteKostenArtView newValue) throws ModelException {
        ((KonkreteKostenArt)this.getTheObject()).setSpeziellerAls(newValue);
    }
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

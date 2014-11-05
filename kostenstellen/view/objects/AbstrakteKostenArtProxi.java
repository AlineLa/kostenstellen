package view.objects;

import view.*;
import viewClient.*;

public abstract class AbstrakteKostenArtProxi extends ViewProxi implements AbstrakteKostenArtView{
    
    public AbstrakteKostenArtProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    
    
    
    public void setIcon(IconRenderer renderer){
        super.setIcon(renderer);
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

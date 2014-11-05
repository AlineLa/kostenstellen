package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface TransFacdeCommand extends  Command {
    

    public void accept(TransFacdeCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(TransFacdeCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(TransFacdeCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(TransFacdeCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}


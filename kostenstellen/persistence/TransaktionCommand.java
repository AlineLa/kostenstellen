package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface TransaktionCommand extends  Command {
    

    public void accept(TransaktionCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(TransaktionCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(TransaktionCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(TransaktionCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}


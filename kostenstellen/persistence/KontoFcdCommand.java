package persistence;

import model.visitor.*;
import model.*;


/* Additional import section end */

public interface KontoFcdCommand extends  Command {
    

    public void accept(KontoFcdCommandVisitor visitor) throws PersistenceException;
    public <R> R accept(KontoFcdCommandReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(KontoFcdCommandExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(KontoFcdCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}


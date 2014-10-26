package persistence;


/* Additional import section end */

public interface Invoker extends AbstractPersistentProxi {
    
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;

    
}


package persistence;


/* Additional import section end */

public interface TransferHierarchyHIERARCHY extends AbstractPersistentProxi {
    
    public boolean containsTransferHierarchy(final TransferHierarchyHIERARCHY part) 
				throws PersistenceException;
    public <T> T strategyTransferHierarchy(final T parameter, final TransferHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;

    
}


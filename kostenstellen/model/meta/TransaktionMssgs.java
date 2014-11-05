package model.meta;

public interface TransaktionMssgs {
    void accept(TransaktionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransaktionDOWNMssgs extends Mssgs, TransaktionMssgs{}
interface TransaktionUPMssgs extends Mssgs, TransaktionMssgs{}

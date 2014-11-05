package model.meta;

public interface KontoFcdMssgs {
    void accept(KontoFcdMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface KontoFcdDOWNMssgs extends Mssgs, KontoFcdMssgs{}
interface KontoFcdUPMssgs extends Mssgs, KontoFcdMssgs{}

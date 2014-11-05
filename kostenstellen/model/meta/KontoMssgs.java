package model.meta;

public interface KontoMssgs {
    void accept(KontoMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface KontoDOWNMssgs extends Mssgs, KontoMssgs{}
interface KontoUPMssgs extends Mssgs, KontoMssgs{}

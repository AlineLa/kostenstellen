package model.meta;

public interface ArtenManagerMssgs {
    void accept(ArtenManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ArtenManagerDOWNMssgs extends Mssgs, ArtenManagerMssgs{}
interface ArtenManagerUPMssgs extends Mssgs, ArtenManagerMssgs{}

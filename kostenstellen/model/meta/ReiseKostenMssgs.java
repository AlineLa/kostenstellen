package model.meta;

public interface ReiseKostenMssgs {
    void accept(ReiseKostenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ReiseKostenDOWNMssgs extends KonkreteKostenArtDOWNMssgs, ReiseKostenMssgs{}
interface ReiseKostenUPMssgs extends Mssgs, ReiseKostenMssgs{}

package model.meta;

public interface LohnKostenMssgs {
    void accept(LohnKostenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LohnKostenDOWNMssgs extends KonkreteKostenArtDOWNMssgs, LohnKostenMssgs{}
interface LohnKostenUPMssgs extends Mssgs, LohnKostenMssgs{}

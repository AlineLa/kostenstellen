package model.meta;

public interface AllgemeineKostenMssgs {
    void accept(AllgemeineKostenMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AllgemeineKostenDOWNMssgs extends KonkreteKostenArtDOWNMssgs, AllgemeineKostenMssgs{}
interface AllgemeineKostenUPMssgs extends Mssgs, AllgemeineKostenMssgs{}

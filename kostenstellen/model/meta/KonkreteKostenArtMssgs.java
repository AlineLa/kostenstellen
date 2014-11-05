package model.meta;

public interface KonkreteKostenArtMssgs {
    void accept(KonkreteKostenArtMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface KonkreteKostenArtDOWNMssgs extends AbstrakteKostenArtDOWNMssgs, KonkreteKostenArtMssgs{}
interface KonkreteKostenArtUPMssgs extends ReiseKostenUPMssgs, AllgemeineKostenUPMssgs, LohnKostenUPMssgs, KonkreteKostenArtMssgs{}

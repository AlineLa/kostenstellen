package model.meta;

public interface KostenArtWurzelMssgs {
    void accept(KostenArtWurzelMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface KostenArtWurzelDOWNMssgs extends AbstrakteKostenArtDOWNMssgs, KostenArtWurzelMssgs{}
interface KostenArtWurzelUPMssgs extends Mssgs, KostenArtWurzelMssgs{}

package model.meta;

public interface AbstrakteKostenArtMssgs {
    void accept(AbstrakteKostenArtMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AbstrakteKostenArtDOWNMssgs extends Mssgs, AbstrakteKostenArtMssgs{}
interface AbstrakteKostenArtUPMssgs extends KonkreteKostenArtUPMssgs, KostenArtWurzelUPMssgs, AbstrakteKostenArtMssgs{}

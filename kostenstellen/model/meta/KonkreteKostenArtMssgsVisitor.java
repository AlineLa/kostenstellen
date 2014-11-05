package model.meta;

public interface KonkreteKostenArtMssgsVisitor extends KonkreteKostenArtDOWNMssgsVisitor, KonkreteKostenArtUPMssgsVisitor {}


interface KonkreteKostenArtDOWNMssgsVisitor extends ReiseKostenDOWNMssgsVisitor, AllgemeineKostenDOWNMssgsVisitor, LohnKostenDOWNMssgsVisitor {

    
}


interface KonkreteKostenArtUPMssgsVisitor extends AbstrakteKostenArtUPMssgsVisitor {

    
}

package model.meta;

public interface ReiseKostenMssgsVisitor extends ReiseKostenDOWNMssgsVisitor, ReiseKostenUPMssgsVisitor {}


interface ReiseKostenDOWNMssgsVisitor  {

    
}


interface ReiseKostenUPMssgsVisitor extends KonkreteKostenArtUPMssgsVisitor {

    
}

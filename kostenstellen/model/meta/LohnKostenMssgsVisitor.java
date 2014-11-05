package model.meta;

public interface LohnKostenMssgsVisitor extends LohnKostenDOWNMssgsVisitor, LohnKostenUPMssgsVisitor {}


interface LohnKostenDOWNMssgsVisitor  {

    
}


interface LohnKostenUPMssgsVisitor extends KonkreteKostenArtUPMssgsVisitor {

    
}

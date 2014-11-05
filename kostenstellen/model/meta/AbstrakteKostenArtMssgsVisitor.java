package model.meta;

public interface AbstrakteKostenArtMssgsVisitor extends AbstrakteKostenArtDOWNMssgsVisitor, AbstrakteKostenArtUPMssgsVisitor {}


interface AbstrakteKostenArtDOWNMssgsVisitor extends KonkreteKostenArtDOWNMssgsVisitor, KostenArtWurzelDOWNMssgsVisitor {

    
}


interface AbstrakteKostenArtUPMssgsVisitor  {

    
}

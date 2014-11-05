package model.meta;

public interface TransFacdeMssgs {
    void accept(TransFacdeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransFacdeDOWNMssgs extends Mssgs, TransFacdeMssgs{}
interface TransFacdeUPMssgs extends Mssgs, TransFacdeMssgs{}

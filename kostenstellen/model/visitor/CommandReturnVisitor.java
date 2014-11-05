
package model.visitor;

public interface CommandReturnVisitor<R> extends TransFacdeCommandReturnVisitor<R> ,TransaktionCommandReturnVisitor<R> ,KontoFcdCommandReturnVisitor<R> {
    
    
}


package model.visitor;

public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends TransFacdeCommandReturnExceptionVisitor<R, E> ,TransaktionCommandReturnExceptionVisitor<R, E> ,KontoFcdCommandReturnExceptionVisitor<R, E> {
    
    
}

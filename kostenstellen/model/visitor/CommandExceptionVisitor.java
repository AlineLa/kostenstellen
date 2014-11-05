
package model.visitor;

public interface CommandExceptionVisitor<E extends model.UserException> extends TransFacdeCommandExceptionVisitor<E>,TransaktionCommandExceptionVisitor<E>,KontoFcdCommandExceptionVisitor<E>{
    
    
}

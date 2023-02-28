package at.ac.htlwrn.exception;

public class ProductAlreadyExistsException extends RuntimeException{
    public ProductAlreadyExistsException(String s) {
        super(s);
    }
}

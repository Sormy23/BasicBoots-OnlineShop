package at.ac.htlwrn.exception;

public class OrderAlreadyExistsException extends RuntimeException {
    public OrderAlreadyExistsException(String s) {
        super(s);
    }
}

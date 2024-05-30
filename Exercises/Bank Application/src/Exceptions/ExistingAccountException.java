package Exceptions;

public class ExistingAccountException extends Exception {
    public ExistingAccountException(String msg) {
        super(msg);
    }
}

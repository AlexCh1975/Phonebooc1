package exception;

public class ConnectionException extends Exception{
    public ConnectionException() {
    }

    public ConnectionException(String message) {
        super(String.format("%s\n", message));
    }
}

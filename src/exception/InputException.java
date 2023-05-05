package exception;

public class InputException extends RuntimeException{
    private  int length;
    private String message;
    public InputException(String message, int length) {
        super(String.format("Ввели %s позиций (%d)!\n", message, length));
        this.length = length;
    }
    public InputException(String message) {
        super(String.format("%s !\n", message));
    }
}

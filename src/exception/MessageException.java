package exception;

public class MessageException extends RuntimeException{
    public static void getMessage(String message, String value){
        System.out.println(String.format("Некорректный ввод %s (%s)!\n\n", message, value));
    }


}

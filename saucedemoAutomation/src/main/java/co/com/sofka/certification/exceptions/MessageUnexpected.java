package co.com.sofka.certification.exceptions;

public class MessageUnexpected extends Exception {

    public static final String UNEXPECTED_MESSAGE = "Unexpected message";

    public MessageUnexpected(String message, Throwable cause){
        super(message, cause);
    }

}

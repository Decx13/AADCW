package lk.ijse.gdse63.travelcw.exception;

public class CreateFailException extends Exception{
    public CreateFailException(String message , Throwable cause){
        super(message+ " : ("+ cause.getMessage(),cause);
    }
}
package fr.nikho.manhunt.exception;

public class ManhuntException extends RuntimeException {

    private String exceptionType;

    public ManhuntException() {
        super("An exception occurred ! check your config file and/or try to reload the plugin");
    }

    public ManhuntException(String msg) {
        super(msg);
    }

    public ManhuntException(String msg, String type) {
        super(msg);
        this.exceptionType = type;
    }

    public String getExceptionType() {
        return exceptionType;
    }

}

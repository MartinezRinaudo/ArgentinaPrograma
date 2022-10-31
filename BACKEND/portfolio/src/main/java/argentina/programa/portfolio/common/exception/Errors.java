package argentina.programa.portfolio.common.exception;

public enum Errors {

    USERNOTFOUND("User does not exist."),

    ELEMENTNOTFOUND("Element does not exist"),
    INVALIDUSER( "Invalid credentials"),
    WRONGELEMENT("Element is wrong"),
    USEREXIST("This user is incorrect or is already registered");

    private String message;

    private Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


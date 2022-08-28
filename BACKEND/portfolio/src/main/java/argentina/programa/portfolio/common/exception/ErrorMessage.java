package argentina.programa.portfolio.common.exception;


import java.time.LocalDate;

public class ErrorMessage {

    private LocalDate timestamp;
    private String message;

    public ErrorMessage(LocalDate timestamp, String message) {
        super();
        this.timestamp = timestamp;
        this.message = message;
    }
}

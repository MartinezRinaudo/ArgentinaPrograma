package argentina.programa.portfolio.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GenericException extends RuntimeException {

    public GenericException(String message) {
        super(message);
    }
}

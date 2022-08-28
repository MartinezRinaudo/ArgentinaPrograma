package argentina.programa.portfolio.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends GenericException {

    public BadRequestException(Errors error) {
        super(error.getMessage());
    }

}

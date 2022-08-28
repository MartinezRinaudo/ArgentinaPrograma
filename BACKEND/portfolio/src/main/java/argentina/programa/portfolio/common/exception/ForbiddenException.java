package argentina.programa.portfolio.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ForbiddenException extends GenericException {

    public ForbiddenException(Errors error) {
        super(error.getMessage());
    }

}

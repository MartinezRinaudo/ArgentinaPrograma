package argentina.programa.portfolio.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ErrorMessage returnError(Exception e){
        ErrorMessage error = new ErrorMessage(LocalDate.now(), e.getMessage());
        return error;
    }


    @ExceptionHandler({BadRequestException.class})
    @ResponseBody
    public ErrorMessage returnError(GenericException e){
        ErrorMessage error = new ErrorMessage(LocalDate.now(), e.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    @ResponseBody ErrorMessage notFound(GenericException nfe) {
        ErrorMessage error = new ErrorMessage(LocalDate.now(), nfe.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({ForbiddenException.class})
    @ResponseBody ErrorMessage forbbidenAccess(GenericException nfe) {
        ErrorMessage error = new ErrorMessage(LocalDate.now(), nfe.getMessage());
        return error;
    }
}

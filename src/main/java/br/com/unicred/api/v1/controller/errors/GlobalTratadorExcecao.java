package br.com.unicred.api.v1.controller.errors;

import br.com.unicred.api.v1.controller.errors.exception.ValidacaoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static br.com.unicred.config.Constantes.Error.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class GlobalTratadorExcecao {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErroVM processarValidacaoError(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ErroVM dto = new ErroVM(ERR_VALIDATION);
        for (FieldError fieldError : fieldErrors) {
            dto.add(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
        }
        return dto;
    }

    @ExceptionHandler(ValidacaoException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErroVM processarValidacaoException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ErroVM(ex.getMessage(), ERR_VALIDATION);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ErroVM> processarException(Exception ex) {
        log.error(ex.getMessage(), ex);
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(INTERNAL_SERVER_ERROR);
        ErroVM erroVM = new ErroVM(MSG_INTERNAL_SERVER_ERROR, ERR_INTERNAL_SERVER_ERROR);
        return builder.body(erroVM);
    }
}

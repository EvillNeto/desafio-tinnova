package dev.evilasio.desafio_tinnova.exception.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.evilasio.desafio_tinnova.exception.StandardException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(StandardException.class)
    public ResponseEntity<ExceptionDto> handleStandard(StandardException e, HttpServletRequest request) {
        HttpStatus status = e.getStatus();
        ExceptionDto error = new ExceptionDto(
                Instant.now(),
                status.value(),
                e.getName(),
                e.getMessage(),
                request.getRequestURI(),
                e.getExtraInfo());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> methodArgumentNotValidException(MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        List<ErrorDto> errors = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorDto erro = ErrorDto.builder().field(e.getField()).message(mensagem).build();
            errors.add(erro);
        });
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionDto error = new ExceptionDto(
                Instant.now(),
                status.value(),
                "MethodArgumentNotValidException",
                "erros detalhados encontrados e disponiveis no campo 'extraInfo'",
                request.getRequestURI(),
                errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleGlobal(RuntimeException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionDto error = new ExceptionDto(
                Instant.now(),
                status.value(),
                "Erro não Tratado",
                e.getMessage(),
                request.getRequestURI(),
                null);
        return ResponseEntity.status(status).body(error);
    }
}

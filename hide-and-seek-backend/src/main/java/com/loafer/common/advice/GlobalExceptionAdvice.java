package com.loafer.common.advice;

import com.aliyuncs.exceptions.ClientException;
import com.loafer.common.ErrorResponse;
import com.loafer.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * @author
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse<?>> businessExceptionHandler(BusinessException e) {
        return ResponseEntity.ok(new ErrorResponse<>(e.getStatus(), e.getMessage(), null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<?>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        String message = bindingResult.getAllErrors().stream().map(this::wrapError).collect(Collectors.joining(" | "));
        return ResponseEntity.ok(new ErrorResponse<>(HttpStatus.NOT_ACCEPTABLE, message, null));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse<?>> validationExceptionHandler(ValidationException ex) {
        return ResponseEntity.ok(new ErrorResponse<>(HttpStatus.NOT_ACCEPTABLE, ex.getMessage(), null));
    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ErrorResponse<?>> clientExceptionHandler(ClientException ex) {
        return ResponseEntity.ok(new ErrorResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse<?>> exceptionHandler(Exception e) {
        return ResponseEntity.ok(new ErrorResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null));
    }

    @ModelAttribute
    public void globalAttributes(Model model) {
        model.addAttribute("appName", "hide-and-seek");
    }

    private String wrapError(ObjectError error) {
        String result = "";
        if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            result += fieldError.getField() + ":";
        }
        result += (error.getDefaultMessage() == null ? "" : error.getDefaultMessage());
        return result;
    }

}
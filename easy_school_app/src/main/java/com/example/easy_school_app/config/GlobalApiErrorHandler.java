package com.example.easy_school_app.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.easy_school_app.models.Response;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalApiErrorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            Response response = new Response(status.toString(), ex.getBindingResult().toString());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Response> errorHandler(Exception exception) {
        Response response = new Response("500", exception.getMessage());
        return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

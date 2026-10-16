package com.adityax.homeservices.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.adityax.homeservices.dto.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler  {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new LinkedHashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error ->
        errors.putIfAbsent(
                error.getField(),
                error.getDefaultMessage()
        )
        );
		
		ApiError apiError = new ApiError(
                LocalDateTime.now(),
                400,
                "Bad Request",
                "Please correct the highlighted fields.",
                errors
        );
		
		return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(
            ResourceNotFoundException ex) {

        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                404,
                "Not Found",
                ex.getMessage(),
                Map.of()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(apiError);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleInvalidBody(
            HttpMessageNotReadableException ex) {

        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                400,
                "Bad Request",
                "Request body contains an invalid or missing value format.",
                Map.of()
        );

        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDatabaseConflict(
            DataIntegrityViolationException ex) {

        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                409,
                "Conflict",
                "The request conflicts with existing data.",
                Map.of()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleOther(Exception ex) {

        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                500,
                "Internal Server Error",
                "An unexpected error occurred.",
                Map.of()
        );

        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR
        ).body(apiError);

		
	}

}

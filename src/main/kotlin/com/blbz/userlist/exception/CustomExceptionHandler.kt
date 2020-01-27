package com.bridgelabz.fundoo_notes.exception

import com.bridgelabz.fundoo_notes.responses.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception?): ResponseEntity<Response?>? {
        val response = Response(ex!!.message, 400)
        return ResponseEntity(response, HttpStatus.BAD_GATEWAY)
    } //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public final ResponseEntity<Response> handleContraintViolation(
//    		MethodArgumentNotValidException ex, WebRequest request){
//
//    	List<String> errors =ex.getBindingResult()
//    						.getFieldErrors()
//    						.stream()
//    						.map(x -> x.getDefaultMessage())
//    						.collect(Collectors.toList());
//
//    	Response error = new Response(HttpStatus.BAD_REQUEST.value(), errors);
//    	return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
}
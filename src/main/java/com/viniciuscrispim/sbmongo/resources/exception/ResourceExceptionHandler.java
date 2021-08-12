package com.viniciuscrispim.sbmongo.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.viniciuscrispim.sbmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice // indica que a classe trata possiveis erros nas requisições
public class ResourceExceptionHandler {

	//quando acontecer a excessão ele gera o standard error e retorna
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Não encontrado",e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}

package com.lancesoft.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lancesoft.exceptions.CustomException;



@RestControllerAdvice
public class ExceptionHandlers {

	
	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(CustomException.class)
	public Map<String, String>handleBussinessException(CustomException customException)
	{
		Map<String, String>hashMap=new HashMap<String, String>();
		hashMap.put("errorMessage",customException.getMessage());
		return hashMap;
	}
	
}

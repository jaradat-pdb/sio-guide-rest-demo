package corp.pdb.sio.demo.web.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import corp.pdb.sio.demo.error.RegisteredUserDocNotFoundException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jaradat-pdb
 *
 */
@ControllerAdvice
@Slf4j
public class UserControllerAdvice {
	@ResponseBody
	@ExceptionHandler(RegisteredUserDocNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String registeredUserDocNotFoundExceptionHandler(RegisteredUserDocNotFoundException e) {
		log.error("{}", e);
		return e.getMessage();
	}
}

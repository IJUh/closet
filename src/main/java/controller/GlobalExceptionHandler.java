package controller;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import model.ErrorCode;
import model.ErrorResponse;
/**
 * ���� ���ܸ� ó���ϴ� �޼��带 ���� Ŭ����
 * ��� ���:
 * @author  Uh ImJoo
 * @version 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
   
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    	log.error("handleMethodArgumentNotValidException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException e) {
    	log.error("handleBindException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

   
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
    	log.error("handleMethodArgumentTypeMismatchException", e);
        final ErrorResponse response = ErrorResponse.of(e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * post ȣ�� ��Ŀ� ���� �߸��� ���� �� �������� ���� HTTP method ȣ�� �� ��� �߻�
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    	log.error("handleHttpRequestMethodNotSupportedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * Authentication ��ü�� �ʿ��� ������ �������� ���� ��� �߻���
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
    	log.error("handleAccessDeniedException", e);
        final ErrorResponse response = ErrorResponse.of(ErrorCode.HANDLE_ACCESS_DENIED);
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.HANDLE_ACCESS_DENIED.getStatus()));
    }
    
    /**
     * ����Ͻ��� ó���ϴ� �������� �߻��ϴ� ���ܸ� ó���ϱ� ����(Custom Exception)
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }

	
	@ExceptionHandler(Exception.class) 
	protected ResponseEntity<ErrorResponse> handleException(Exception e) { 
		log.error("handleEntityNotFoundException", e);
		final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR); 
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	/**
     * SQLException�� ó���ϱ� ���� ����ó�� �ڵ鷯
     * ���� Ŭ���� Exception���� �켱 ó���ϱ� ���ؼ� order�� ����
     */
	@ExceptionHandler({SQLException.class,DataAccessException.class})
	@Order(Ordered.HIGHEST_PRECEDENCE)
	protected ResponseEntity<ErrorResponse> handleSqlException(SQLException e) { 
		log.error("handleSqlException", e);
		final ErrorResponse response = ErrorResponse.of(e);
		return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.SQL_EXCEPTION_ERROR.getStatus())); 
	}
}
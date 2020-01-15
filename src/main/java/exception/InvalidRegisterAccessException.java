package exception;

import model.ErrorCode;

public class InvalidRegisterAccessException extends BusinessException {

	public InvalidRegisterAccessException(String message, ErrorCode errorCode) {
		super(message, ErrorCode.SIGN_UP_ACCESS_INVALID);
	}
	public InvalidRegisterAccessException(ErrorCode errorCode) {
		super(ErrorCode.SIGN_UP_ACCESS_INVALID);
	}

}

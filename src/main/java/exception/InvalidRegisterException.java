package exception;

import model.ErrorCode;

public class InvalidRegisterException extends BusinessException {

	public InvalidRegisterException(String message, ErrorCode errorCode) {
		super(message, ErrorCode.SIGN_UP_INPUT_INVALID);
	}

	public InvalidRegisterException(ErrorCode errorCode) {
		super(ErrorCode.SIGN_UP_INPUT_INVALID);
	}
}

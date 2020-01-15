package exception;

import model.ErrorCode;

public class BusinessException extends RuntimeException {

	private ErrorCode errorCode;
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}

package model;

import lombok.Getter;

public enum ErrorCode {
	// Common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Method Not Allowed"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    INTERNAL_SERVER_ERROR(500, "C007", "Internal Server Error"),
    SQL_EXCEPTION_ERROR(999, "C999", "SQL_EXCEPTION_ERROR"),

    // Member
    EMAIL_DUPLICATION(400, "M001", "Email is Duplication"),
    LOGIN_INPUT_INVALID(400, "M002", "Login input is invalid"),
    SIGN_UP_ACCESS_INVALID(400, "M003", "Sign up Access is Denied"),
    SIGN_UP_INPUT_INVALID(400, "M004", "Sign up Input is Denied"),

    // ITEM
    ITEM_NO_ALREADY_REGISTER(999, "IT001", "Item is already registered"),
    ;
    private final @Getter String code;
    
    private final @Getter String message;
    
    private @Getter int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}

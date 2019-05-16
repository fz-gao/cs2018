package cn.fvti.cs2018.ws.exception;

import lombok.Getter;

import static cn.fvti.cs2018.ws.exception.ErrorCode.SYSTEM_ERROR;

/**
 * @author gsd
 * 业务异常类
 */
@Getter
public class BusinessException extends  RuntimeException{

    private final String message;
    private final int code;

    public BusinessException(final ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

    public BusinessException(String message, int code) {
        this.message = message;
        this.code = code;
    }
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        // 默认为未知错误
        this.code = SYSTEM_ERROR.getCode();
    }
}
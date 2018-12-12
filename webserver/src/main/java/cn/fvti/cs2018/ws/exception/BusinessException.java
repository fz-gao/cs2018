package cn.fvti.cs2018.ws.exception;

/**
 * Created by gsd on 2018/12/12.
 */
import lombok.Getter;

import static cn.fvti.cs2018.ws.exception.ErrorCode.SYSTEM_ERROR;

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
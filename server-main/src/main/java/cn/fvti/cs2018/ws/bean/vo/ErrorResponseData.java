package cn.fvti.cs2018.ws.bean.vo;

import cn.fvti.cs2018.ws.exception.BusinessException;
import cn.fvti.cs2018.ws.exception.ErrorCode;
import lombok.Data;

/**
 * @author gsd
 */
@Data
public class ErrorResponseData extends ResponseData {
    public ErrorResponseData(String message) {
        super(false, ResponseData.DEFAULT_ERROR_CODE, message, null);
    }
    public ErrorResponseData(Integer code, String message) {
        super(false, code, message, null);
    }
    public ErrorResponseData(Integer code, String message, Object object) {
        super(false, code, message, object);
    }
    public static ResponseData error(BusinessException e) {
        return new ErrorResponseData(e.getCode(), e.getMessage());
    }
    public static ResponseData error(ErrorCode e) {
        return new ErrorResponseData(e.getCode(), e.getMessage());
    }
    public static ResponseData error(String message) {
        return new ErrorResponseData(message);
    }
    public static ResponseData error(Integer code, String message) {
        return new ErrorResponseData(code, message);
    }

    public static ResponseData error(Integer code, String message, Object object) {
        return new ErrorResponseData(code, message, object);
    }
}
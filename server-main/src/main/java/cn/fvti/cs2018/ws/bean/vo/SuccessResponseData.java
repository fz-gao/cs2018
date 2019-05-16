package cn.fvti.cs2018.ws.bean.vo;

/**
 * @author gsd
 */
public class SuccessResponseData extends ResponseData {

    public SuccessResponseData() {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
    }
    public SuccessResponseData(Object object) {
        super(true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, object);
    }
    public SuccessResponseData(Integer code, String message, Object object) {
        super(true, code, message, object);
    }
    public static ResponseData success(Object object) {
        return new SuccessResponseData(object);
    }
    public static ResponseData success() {
        return new SuccessResponseData();
    }
    public static ResponseData success(Integer code, String message, Object object) {
        return new SuccessResponseData(code, message, object);
    }
}

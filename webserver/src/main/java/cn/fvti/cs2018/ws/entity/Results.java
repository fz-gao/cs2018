package cn.fvti.cs2018.ws.entity;

/**
 * Created by gsd on 2018/12/12.
 */
import cn.fvti.cs2018.ws.exception.BusinessException;
import cn.fvti.cs2018.ws.exception.ErrorCode;
import com.google.gson.Gson;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by tinygao on 2017/12/9 0009.
 */
@Slf4j
@Value
public class Results<T> {
    private final static Gson gson = new Gson();
    private final T data;
    private final String msg;
    private final int code;

    public static String error(BusinessException e) {
        return gson.toJson(new Results("", e.getMessage(), e.getCode()));
    }

    public static String error(String msg, int code) {
        return gson.toJson(new Results(null,msg, code));
    }

    public static String error(ErrorCode errorCode) {
        return gson.toJson(new Results(null, errorCode.getMessage(), errorCode.getCode()));
    }

    public static String error() {
        return gson.toJson(new Results(ErrorCode.SYSTEM_ERROR.getMessage(),"", ErrorCode.SYSTEM_ERROR.getCode()));
    }

    public  static <T> String success(T data)  {
        return gson.toJson(new Results(data,"", 200));
    }

    public static String success() {
        return gson.toJson(new Results("","", 200));
    }
}
package cn.fvti.cs2018.ws.exception;

import lombok.Getter;

/**
 * Created by gsd on 2018/12/12.
 */
@Getter
public enum  ErrorCode {

    // 用户相关
    PASSWD_ERROR("密码错误!", 40003),

    SYSTEM_ERROR("系统内部错误", -1);

    private final String message;
    private final int code;
    ErrorCode(String message, int code) {
        this.code = code;
        this.message = message;
    }

}

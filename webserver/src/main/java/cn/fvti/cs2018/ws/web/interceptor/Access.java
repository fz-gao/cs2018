package cn.fvti.cs2018.ws.web.interceptor;

/**
 * Created by gsd on 2018/12/12.
 */
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {
    String value();
}

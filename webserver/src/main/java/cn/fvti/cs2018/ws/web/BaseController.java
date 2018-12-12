package cn.fvti.cs2018.ws.web;

/**
 * Created by gsd on 2018/12/12.
 */

import cn.fvti.cs2018.ws.entity.Results;
import cn.fvti.cs2018.ws.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class BaseController {
    @ExceptionHandler(BusinessException.class)
    public String processBusinessException(BusinessException ex) {
        log.error(ex.getMessage(), ex);
        return Results.error(ex);
    }

    @ExceptionHandler(Throwable.class)
    public String processThrowable(Throwable ex) {
        log.error(ex.getMessage(), ex);
        return Results.error(new BusinessException( ex.getCause().getMessage(), -1));
    }

    @ExceptionHandler(Exception.class)
    public String processException(Throwable ex) {
        log.error(ex.getMessage(), ex);
        return Results.error(new BusinessException(ex.getCause().getMessage(), -1));
    }
}

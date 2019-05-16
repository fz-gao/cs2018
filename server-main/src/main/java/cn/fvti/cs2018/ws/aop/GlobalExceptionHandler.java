package cn.fvti.cs2018.ws.aop;

import cn.fvti.cs2018.ws.bean.vo.ErrorResponseData;
import cn.fvti.cs2018.ws.bean.vo.ResponseData;
import cn.fvti.cs2018.ws.exception.BusinessException;
import cn.fvti.cs2018.ws.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author gsd
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({BindException.class})
    @ResponseBody
    public ResponseData processValidationError(BindException ex) {
        log.error(ex.getMessage(), ex);
        String result = ex
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));

        return new ErrorResponseData(400 ,result);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public ErrorResponseData processValidationError(ConstraintViolationException ex) {
        log.error(ex.getMessage(), ex);
        String result = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(","));
        return new ErrorResponseData(400 ,result);
    }
    /**
     * 拦截业务异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseData business(BusinessException e) {
        log.error("BusinessException:", e);
        return ErrorResponseData.error(e);
    }


    @ExceptionHandler({Exception.class, Throwable.class})
    @ResponseBody
    public ResponseData defaultErrorHandler(Throwable e){
        log.error("DefaultErrorHandler:", e);
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return ErrorResponseData.error(HttpStatus.NOT_FOUND.value(), e.getMessage());
        }

        return ErrorResponseData.error(ErrorCode.SYSTEM_ERROR);
    }

    /**
     * 405
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ResponseData request405(HttpRequestMethodNotSupportedException e){
        log.error("HttpRequestMethodNotSupportedException:", e);
        return ErrorResponseData.error(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getMessage());
    }


}

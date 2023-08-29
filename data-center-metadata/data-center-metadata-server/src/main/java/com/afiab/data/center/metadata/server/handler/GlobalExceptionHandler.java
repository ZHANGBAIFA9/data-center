package com.afiab.data.center.metadata.server.handler;


import com.afiab.data.center.common.core.base.domain.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 11:19
 * @Description:
 */
//@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 请求方式不支持
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    public R handleException(HttpRequestMethodNotSupportedException e) {
        logger.error("error >>>  \n   ", e);
        return R.error("10000", "不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 参数校验
     *
     * @param exception
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
        logger.error("error >>>  \n   ", exception);
        StringBuilder sb = new StringBuilder();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            sb.append(error.getField()).append(": ").
                    append(error.getDefaultMessage()).append("\n");
        }
        return R.error("10000",sb.toString());
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Object bindExceptionHandler(BindException exception) {
        logger.error("error >>>  \n   ", exception);

        StringBuilder sb = new StringBuilder();
        sb.append("参数校验不通过: \n");
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            sb.append(error.getField()).append(": ").
                    append(error.getDefaultMessage()).append("\n");
        }
        return R.error("10000", exception.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public R notFount(RuntimeException e) {
        logger.error("error >>>  \n   ", e);

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        return R.error("10000", "运行时异常:" + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        logger.error("error >>>  \n   ", e);
        return R.error("10000", e.getMessage());
    }
}

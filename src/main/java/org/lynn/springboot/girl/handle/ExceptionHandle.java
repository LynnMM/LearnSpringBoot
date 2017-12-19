package org.lynn.springboot.girl.handle;

import org.lynn.springboot.girl.domain.Result;
import org.lynn.springboot.girl.enums.ResultEnum;
import org.lynn.springboot.girl.exception.PersonException;
import org.lynn.springboot.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof PersonException){
            PersonException personException = (PersonException)e;
            return ResultUtil.error(personException.getCode(), personException.getMessage());
        }else{
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        }
    }
}

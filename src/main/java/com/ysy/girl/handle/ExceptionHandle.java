package com.ysy.girl.handle;

import com.ysy.girl.entity.Result;
import com.ysy.girl.exception.GirlException;
import com.ysy.girl.utils.ResultUtil;
import com.ysy.girl.ymlenum.ErrEnum;
import com.ysy.girl.ymlenum.PathEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获
 *
 * @author yusongyuan
 * @create 2017-12-23 14:37
 **/
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @Autowired
    private ResultUtil resultUtil;

    //声明要捕获的异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody //由于现在给浏览器返回的是json格式，上面没有@RestController
    public Result handle(Exception e){
        if(e instanceof GirlException){
            return resultUtil.error(PathEnum.RESULT.getPath(),((GirlException) e).getCode());
        }else{
            //用日志输出，系统异常，并用工具类返回指定格式的信息给浏览器
            logger.error("【系统异常】", e);
            return resultUtil.error(ErrEnum.UNKNOW_ERROR);
        }
    }

}

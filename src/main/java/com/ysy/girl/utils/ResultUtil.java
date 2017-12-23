package com.ysy.girl.utils;

import com.ysy.girl.entity.Result;
import com.ysy.girl.ymlenum.ErrEnum;
import com.ysy.girl.ymlenum.PathEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 返回结果的工具类
 *
 * @author yusongyuan
 * @create 2017-12-23 14:04
 **/
@Component
public class ResultUtil {

    @Autowired
    private Environment env; //获取配置文件信息

    public Result success(Object object){
        return new Result("right-0000", env.getProperty(PathEnum.RESULT.getPath()+"right-0000"), object);
    }

    public Result error(String errAddr, String code){
        //使用Environment动态获取配置文件的错误描述
        return  new Result(code, env.getProperty(errAddr+code), null);
    }

    //其他错误
    public Result error(ErrEnum errEnum){
        return  new Result(errEnum.getCode(), errEnum.getMsg(), null);
    }

}

package com.ysy.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpAop处理
 *
 * @author yusongyuan
 * @create 2017-12-22 13:15
 **/
@Aspect
@Component //引入到spering boot容器中
public class HttpAspect {

    //SpringFarmwork自己的日志框架
    //2017-12-22 19:22:06.947[时间]  INFO[级别] 5296[进程号] --- [nio-8099-exec-2]  [端口] com.ysy.girl.aspect.HttpAspect[方法]           : --------进入beforeLog方法：@Before
    private final static Logger loger = LoggerFactory.getLogger(HttpAspect.class);

    //@Before :表示执行前拦截
    //拦截的方法 (..)：表示无论是什么参数都会被拦截
    @Before("execution(public * com.ysy.girl.controller.GirlController.girlList(..))")
    public void doBefore(){
//        System.out.println("-------Before--------com.ysy.controller.GirlController.girlList");

    }

    //@After :表示执行后拦截
    //com.ysy.girl.controller.GirlController.*：表示拦截 GirlController的所有方法
    @After("execution(public * com.ysy.girl.controller.GirlController.*(..))")
    public void doAfter(){
//        System.out.println("-------After--------com.ysy.girl.controller.GirlController.*(..))");
    }

    //@Pointcut:表示声明一个切面，且中的语句不会执行
    @Pointcut("execution(public * com.ysy.girl.controller.GirlController.*(..))")
    public void log(){
        loger.info("--------进入log方法：@Poincut");
    }

    //该方法会在log()方法的切面Before执行
    //JoinPoint:用于获取请求的方法的具体信息
    @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
        loger.info("--------进入beforeLog方法：@Before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //请求的链接
        loger.info("url={}", request.getRequestURL());
        //请求的方式 POST GET
        loger.info("method={}", request.getMethod());
        //请求的ip
        loger.info("ip={}", request.getRemoteAddr());
        //请求的方法 getDeclaringTypeName()：类名； getName():获取方法名
        loger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //请求的参数
        loger.info("arg={}", joinPoint.getArgs());
    }

    //该方法会在log()方法的切面After执行，只是对于方法而言
    @After("log()")
    public void afterLog(){
        loger.info("--------进入afterLog方法：@After");
    }

    //对于本次请求，响应的数据
    //获取响应的数据 returning = "object" 是等于 Object object
    @AfterReturning(returning = "object" , pointcut = "log()")
    public void afterReturningLog(Object object){
        loger.info("response={}", object.toString());
    }

}

package org.lynn.springboot.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    /*//具体的某一个方法：@Before("execution(public * org.lynn.springboot.girl.controller.PersonController.personList(..))")
    //拦截PersonController下的所有方法
    @Before("execution(public * org.lynn.springboot.girl.controller.PersonController.*(..))")
    public void log(){
        System.out.println("AOP log");
    }

    @After("execution(public * org.lynn.springboot.girl.controller.PersonController.*(..))")
    public void doAfter(){
        System.out.println("AOP doAfter");
    }*/

    @Pointcut("execution(public * org.lynn.springboot.girl.controller.PersonController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //class method
        logger.info("class_method={}",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //params
        logger.info("params={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("AOP doAfter");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}", object);
    }
}

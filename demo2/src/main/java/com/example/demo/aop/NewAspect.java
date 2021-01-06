package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
@Order(101)
@Aspect
@Component
public class NewAspect {
    /**
     * 定义切入点，切入点为com.example.demo.controller中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.example.demo.controller..*(..))")
    public void allController() {
    }
    /**
     * @description  在连接点执行之前执行的通知
     */
    @Before("allController()")
    public void doBeforeGame(){
        System.out.println("before1");
    }
    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("allController()")
    public void doAfterGame(){
        System.out.println("after1");
    }
    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("allController()")
    public void doAfterReturningGame(){
        System.out.println("afterrRturn");
    }
    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("allController()")
    public void doAfterThrowingGame(){
        System.out.println("afterThrow");
    }

}

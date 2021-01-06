package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
@Aspect
@Component
public class TestAspect {
    /**
     * 定义切入点，切入点为com.example.demo.controller中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.example.demo.controller..*(..))")
    public void allController() {

    }
    /**
     * @description  使用环绕通知
     */
    @Around("allController()")
    public void doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        try{
            System.out.println("before2");
            pjp.proceed();
            System.out.println("afterrRturn2");
        }
        catch(Throwable e){
            System.out.println("afterThrow2");
        }
    }

}

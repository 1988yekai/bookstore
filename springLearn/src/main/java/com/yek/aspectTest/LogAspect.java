package com.yek.aspectTest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by yek on 2018-05-12.
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.yek.aspectTest.Action)")
    public void annotationPointCut() {
    }
    @Before("annotationPointCut()")//annotationPointCut() 表示使用 @Pointcut("@annotation(com.yek.aspectTest.Action)")
    public void beforePointCut(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Arrays.asList(args).forEach(System.out::println);
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String[] parameterNames = codeSignature.getParameterNames();
        for (int i = 0; i < parameterNames.length; i++) {
            System.out.println(parameterNames[i]+":"+args[i]);
        }
    }
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截： " + action.name());

    }

    @Before("execution(* com.yek.aspectTest.DemoMethodService.*(..))")//自定义规则拦截
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("方法规则拦截： " + method.getName());
    }
}

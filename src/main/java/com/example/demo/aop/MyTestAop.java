package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyTestAop {
    public static final String EXP = "execution(* com.example.demo.controller.*.*(..))";

    @Around(EXP)
    public Object around(ProceedingJoinPoint pjp) {
        try {
            System.out.println("前置通知");
            //执行目标对象的方法
            Object ret = pjp.proceed();
            System.out.println(ret);
            ret = "Test Around";
            System.out.println("后置通知");
            //返回值
            return ret;
        }catch(Throwable ex) {
            System.out.println("异常通知");
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("最终通知");
        }
        return null;

    }

}

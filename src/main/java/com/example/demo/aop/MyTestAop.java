package com.example.demo.aop;

import com.example.demo.domain.StatusRet;
import com.example.demo.util.StatusMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class MyTestAop {
    private static final String EXP = "execution(* com.example.demo.controller.*.*(..))";

    Map<Object,Object> map = new HashMap<Object, Object>(50);

    private static final String SYSTEM_ERROR = "2002";

    @Around(EXP)
    public Object around(ProceedingJoinPoint pjp) {
        try {
            System.out.println("前置通知");
            //执行目标对象的方法
            Object ret = pjp.proceed();
            String retStr = ret.toString();
            System.out.println(ret);
            Object o = StatusMap.getInstance().get(retStr);
            if (o == null){
                ret = new StatusRet("0000","",ret);
            }else{
                ret = new StatusRet(retStr,o.toString(),null);

            }

            System.out.println("后置通知");
            //返回值
            return ret;
        }catch(Throwable ex) {
            System.out.println("异常通知");
            System.out.println(ex.getMessage());
//            return "Around Error";
            return new StatusRet(SYSTEM_ERROR,StatusMap.getInstance().get(SYSTEM_ERROR).toString(),null);
        }finally {
            System.out.println("最终通知");
        }

    }

}

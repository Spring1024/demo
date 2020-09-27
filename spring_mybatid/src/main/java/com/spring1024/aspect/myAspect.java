package com.spring1024.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class myAspect {

    void before(){
        System.out.println("————————————程序执行前————————————");
    }
    //后置增强。切入位置的方法结束后调用

    void after(){
        System.out.println("————————————程序执行后————————————");
    }
    //环绕增强。切入位置的方法未准备运行之前就开始执行。添加ProceedingJoinPoint参数表明何时切入。
    void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法准备运行前");
        //方法执行
        joinPoint.proceed();
        System.out.println("方法运行未结束时");
        /*//调用joinPoint.getArgs()方法能够获取到方法参数，可以通过以下方式修改参数值
        int i=0;
        Object[] args=joinPoint.getArgs();
        for (Object o:args){
            System.out.println("切面输出"+o);
            //参数类型为int时。其他类型一致。
            args[i]=((int)o+10);
            i++;
            System.out.println("更改后输出为：");
        }
        joinPoint.proceed(args);*/
    }
}

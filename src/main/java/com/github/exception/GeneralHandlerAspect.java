package com.github.exception;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by chenjunlong on 2018/8/8.
 */
public class GeneralHandlerAspect {

    private ProcessCallable processCallable;
    private ExceptionCallable exceptionCallable;

    public GeneralHandlerAspect(ExceptionCallable exceptionCallable) {
        this.exceptionCallable = exceptionCallable;
    }

    public GeneralHandlerAspect(ProcessCallable processCallable, ExceptionCallable exceptionCallable) {
        this.processCallable = processCallable;
        this.exceptionCallable = exceptionCallable;
    }

    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String targetClass = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String method = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        try {
            long startTime = System.currentTimeMillis();
            Object result = proceedingJoinPoint.proceed();
            long processTimeMillis = System.currentTimeMillis() - startTime;
            if (null != processCallable) {
                processCallable.call(targetClass, method, args, result, processTimeMillis);
            }
            return result;
        } catch (Exception e) {
            return exceptionCallable.call(e, targetClass, method, args);
        }
    }

}

package com.study.mvc.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class TimeAop {
    @Pointcut("@annotation(com.study.mvc.aop.annotation.TimeAspect)")
    private void pointCut() {}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 전처리 영역
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = proceedingJoinPoint.proceed();

        // 후처리 영역
        stopWatch.stop();

        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        String className = codeSignature.getDeclaringTypeName();
        String methodName = codeSignature.getName();

        log.info("Timer: {}초 ({}.{})", stopWatch.getTotalTimeSeconds(), className, methodName);

        return result;
    }
}

package com.example.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class TransferAndAccountExceptionAspect {

    /**
     * Аспект вызываемый при выбрасывании ошибки
     * @param joinPoint место внедрения аспекта
     * @param ex экземпляр ошибки
     */
    @AfterThrowing(pointcut = "@annotation(com.example.aspects.TransferAndAccountException)", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().toString();
        System.err.println("Exception in method " + methodName + ": " + ex.getMessage());
    }
}

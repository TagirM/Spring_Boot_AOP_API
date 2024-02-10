package com.example.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class AccountsActionAspect {

    /**
     * Создание аспекта логирования старта и окончания методов с выводом информации о названии метода
     * и его параметрах, а также времени исполнения
     * @param joinPoint точка внедрения аспекта
     * @return объект аспекта
     * @throws Throwable выбрасывание объекта аспекта
     */

    @Around("@annotation(com.example.aspects.AccountsAction)")
    public Object logAccountsMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Operation with accounts is " + joinPoint.getSignature() + ", it is started");
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info("Operation with accounts is " + joinPoint.getSignature() + ", it is finished");
        log.info("Operation " + joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }
}

package com.example.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class TransferActionAspect {

    /**
     * Создание аспекта логирования старта и окончания трансфера с выводом информации о названии метода
     * и его параметрах, а также времени исполнения
     * @param joinPoint точка внедрения аспекта
     * @return объект аспекта
     * @throws Throwable выбрасывание объекта аспекта
     */

    @Around("@annotation(com.example.aspects.TransferAction)")
    public Object logTransfer(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Transfer is started by method " + joinPoint.getSignature());
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        log.info("Transfer method is success finished!");
        log.info("Transfer executed in " + executionTime + "ms");

        return proceed;
    }
}

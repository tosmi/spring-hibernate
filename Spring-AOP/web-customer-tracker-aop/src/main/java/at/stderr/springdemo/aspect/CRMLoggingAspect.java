package at.stderr.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* at.stderr.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* at.stderr.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* at.stderr.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint jp) {
        var method = jp.getSignature().toShortString();
        logger.info("=====> in @Before: calling method " + method);

        var args = jp.getArgs();
        for ( var arg : args) {
            logger.info("======> argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint jp, Object result) {
        var method = jp.getSignature().toShortString();
        logger.info("=====> in @AfterReturning: from method " + method);

        logger.info("=====> result: " + result);
    }

}

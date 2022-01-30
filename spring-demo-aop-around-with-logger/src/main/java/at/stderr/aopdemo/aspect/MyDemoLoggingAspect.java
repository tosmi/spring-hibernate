package at.stderr.aopdemo.aspect;

import at.stderr.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    
    private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Around("execution(* at.stderr.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().toString();
        logger.info("\n=====>>>> Executing @Around on method: " + method);

        var begin = System.currentTimeMillis();
        Object result = pjp.proceed();
        var end = System.currentTimeMillis();

        var duration = end - begin;
        logger.info("\n=====> Duration: " + duration / 1000.0 + "seconds");
        return result;
    }

    @After("execution(* at.stderr.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint jp) {
        String method = jp.getSignature().toString();
        logger.info("\n=====>>>> Executing @After on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* at.stderr.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint jp, Throwable exc) {
        String method = jp.getSignature().toString();
        logger.info("\n=====>>>> Executing @AfterThrowing on method: " + method);
        logger.info("\n=====>>>> The exception is: " + exc);
    }

    @AfterReturning(
            pointcut = "execution(* at.stderr.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint jp, List<Account> result) {
        String method = jp.getSignature().toString();
        logger.info("\n=====>>>> Executing @AfterReturning on method: " + method);
        logger.info("\n=====>>>> result is: " + result);

        convertAccountNamesToUpperCase(result);

        logger.info("\n=====>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account a : result) {
            a.setName(a.getName().toUpperCase());
        }
    }

    @Before("at.stderr.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        logger.info("=======>>>> Executing @Before advice on method with pointcut declaration");

        var methodSignature = (MethodSignature) theJoinPoint.getSignature();
        logger.info("Method: " + methodSignature);

        var args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            logger.info(tempArg.toString());

            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                logger.info("account name: " + theAccount.getName());
                logger.info("account level: " + theAccount.getLevel());
            }
        }


    }
}

package at.stderr.aopdemo.aspect;

import at.stderr.aopdemo.Account;
import at.stderr.aopdemo.dao.AccountDAO;
import com.google.inject.internal.util.Join;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* at.stderr.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().toString();
        System.out.println("\n=====>>>> Executing @Around on method: " + method);

        var begin = System.currentTimeMillis();
        Object result = pjp.proceed();
        var end = System.currentTimeMillis();

        var duration = end - begin;
        System.out.println("\n=====> Duration: " + duration / 1000.0 + "seconds");
        return result;
    }

    @After("execution(* at.stderr.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint jp) {
        String method = jp.getSignature().toString();
        System.out.println("\n=====>>>> Executing @After on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* at.stderr.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint jp, Throwable exc) {
        String method = jp.getSignature().toString();
        System.out.println("\n=====>>>> Executing @AfterThrowing on method: " + method);
        System.out.println("\n=====>>>> The exception is: " + exc);
    }

    @AfterReturning(
            pointcut = "execution(* at.stderr.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint jp, List<Account> result) {
        String method = jp.getSignature().toString();
        System.out.println("\n=====>>>> Executing @AfterReturning on method: " + method);
        System.out.println("\n=====>>>> result is: " + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account a : result) {
            a.setName(a.getName().toUpperCase());
        }
    }

    @Before("at.stderr.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("=======>>>> Executing @Before advice on method with pointcut declaration");

        var methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        var args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }


    }
}

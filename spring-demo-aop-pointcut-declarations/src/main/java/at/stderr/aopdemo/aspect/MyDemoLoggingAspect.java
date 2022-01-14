package at.stderr.aopdemo.aspect;

import at.stderr.aopdemo.dao.AccountDAO;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* at.stderr.aopdemo.dao.*.*(..))")
    private void forDAOPackage() { /* Empty because of Pointcut */ }

    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=======>>>> Executing @Before advice on method with pointcut declaration");
    }

    @Before("forDAOPackage()")
    public void beforeApiAnalytics() {
        System.out.println("\n=======>>>> Performing API analytics");
    }
}

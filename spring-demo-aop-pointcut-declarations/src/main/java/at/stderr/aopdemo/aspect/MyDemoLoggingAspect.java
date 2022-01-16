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

    @Pointcut("execution(* at.stderr.aopdemo.dao.*.get*(..))")
    private void getter() { /* Empty because of Pointcut */ }

    @Pointcut("execution(* at.stderr.aopdemo.dao.*.set*(..))")
    private void setter() { /* Empty because of Pointcut */ }

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter() { /* Empty because of Pointcut */ }

    // @Before("forDAOPackage()")
    @Before("forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("=======>>>> Executing @Before advice on method with pointcut declaration");
    }

    // @Before("forDAOPackage()")
    @Before("forDAOPackageNoGetterSetter()")
    public void beforeApiAnalytics() {
        System.out.println("=======>>>> Performing API analytics");
    }

    @Before("forDAOPackageNoGetterSetter()")
    public void withoutGetterSetter() {
        System.out.println("=======>>>> Advice without Getter/Setter");
    }
}

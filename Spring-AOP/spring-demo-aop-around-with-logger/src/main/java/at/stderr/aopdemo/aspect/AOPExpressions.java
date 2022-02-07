package at.stderr.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

    @Pointcut("execution(* at.stderr.aopdemo.dao.*.*(..))")
    public void forDAOPackage() { /* Empty because of Pointcut */ }

    @Pointcut("execution(* at.stderr.aopdemo.dao.*.get*(..))")
    public void getter() { /* Empty because of Pointcut */ }

    @Pointcut("execution(* at.stderr.aopdemo.dao.*.set*(..))")
    public void setter() { /* Empty because of Pointcut */ }

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter() { /* Empty because of Pointcut */ }
}

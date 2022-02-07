package at.stderr.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAPIAnalyticsAspect {

    @Before("at.stderr.aopdemo.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("=======>>>> Performing API analytics");
    }

}

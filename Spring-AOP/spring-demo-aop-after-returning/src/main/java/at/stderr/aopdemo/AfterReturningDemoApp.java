package at.stderr.aopdemo;

import at.stderr.aopdemo.dao.AccountDAO;
import at.stderr.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DemoConfig.class);
        var accountDAO = context.getBean("accountDAO", AccountDAO.class);

        var accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("---");
        System.out.println(accounts);
        System.out.println("\n");

        context.close();
    }
}

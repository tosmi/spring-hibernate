package at.stderr.aopdemo;

import at.stderr.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DemoConfig.class);
        var accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = null;
        try {
            boolean tripwire = true;
            accounts = accountDAO.findAccounts(tripwire);
        } catch (Exception exc) {
            System.out.println("\n\nMain program ... caught exception: " + exc);
        }

        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("---");
        System.out.println(accounts);
        System.out.println("\n");

        context.close();
    }
}

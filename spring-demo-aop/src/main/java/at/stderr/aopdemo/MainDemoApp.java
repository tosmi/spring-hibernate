package at.stderr.aopdemo;

import at.stderr.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DemoConfig.class);
         var accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();
        context.close();
    }
}

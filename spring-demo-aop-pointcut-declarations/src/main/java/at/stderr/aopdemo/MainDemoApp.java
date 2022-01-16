package at.stderr.aopdemo;

import at.stderr.aopdemo.dao.AccountDAO;
import at.stderr.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DemoConfig.class);
        var accountDAO = context.getBean("accountDAO", AccountDAO.class);
        var membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        var account = new Account();
        account.setName("Toni");

        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        accountDAO.setName("foo");
        accountDAO.setServiceCode("1234");

        var name = accountDAO.getName();
        var code = accountDAO.getServiceCode();


        membershipDAO.addMemberShipAccount();
        membershipDAO.goToSleep();

        context.close();
    }
}

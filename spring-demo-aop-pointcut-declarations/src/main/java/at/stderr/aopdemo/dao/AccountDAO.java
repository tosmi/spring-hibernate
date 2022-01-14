package at.stderr.aopdemo.dao;

import at.stderr.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, Boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT " + account.getName());
    }

    public Boolean doWork() {
        System.out.println(getClass() + ": do Work");
        return true;
    }
}

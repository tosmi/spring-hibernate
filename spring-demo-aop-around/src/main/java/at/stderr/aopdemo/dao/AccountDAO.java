package at.stderr.aopdemo.dao;

import at.stderr.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripwire) {

        if(tripwire) {
            throw new RuntimeException("No soup for you!!!");
        }
        var myAccounts = new ArrayList<Account>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    public String getName() {
        System.out.println(getClass() + " in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account account, Boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT " + account.getName());
    }

    public Boolean doWork() {
        System.out.println(getClass() + ": do Work");
        return true;
    }
}

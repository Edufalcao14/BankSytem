import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private HashMap<Long,BankAccount> accountMap;

    public BankSystem(Map accountList) {
        this.accountMap = new HashMap<>();
    }
    public void addAccount(Person holder , Date openingDate , long accountNumber,
                           String accountType, String tutor, long companyNumber , boolean isWorking) {
        BankAccount account = new BankAccount(holder, openingDate, accountNumber);
        if (accountType.equals("underage")){
            account= new underageAccount(holder,openingDate,accountNumber,tutor);
        }else if (accountType.equals("Professional")){
            account = new ProfessionalAccount(holder,openingDate,accountNumber, companyNumber);
        }else
            account = new PersonnalAccount(holder,openingDate,accountNumber,isWorking);
        accountMap.put(accountNumber,account);
    }

    public BankAccount findAccount(long accountNumber) {
        if (accountMap.containsKey(accountNumber)){
            return accountMap.get(accountNumber);
        }
        return null;
    }
    public void deposit(Long accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account " + accountNumber + " does not exist.");
        }
    }
    public void withdraw(Long accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account " + accountNumber + " does not exist.");
        }
    }
    public void transfer(Long fromAccountNumber, Long toAccountNumber, double amount) {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            fromAccount.transfer(toAccount, amount);
        } else {
            System.out.println("One or more accounts do not exist.");
        }
    }
}

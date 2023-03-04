import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private HashMap<Long, BankAccount> accountMap;

    public BankSystem(Map accountList) {
        this.accountMap = new HashMap<>();
    }

    public void addPersonalAccount(BankAccount account, long accountNumber, boolean isWorking) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (account.getAccountType()!='P') throw new IllegalArgumentException("You can only add personal accounts on this option");
        account = new PersonalAccount(account.getHolder(), account.getOpeningDate(), account.getAccountNumber(), 'P', isWorking);
        accountNumber = account.getAccountNumber();

        accountMap.put(accountNumber, account);
    }

    public void addUnderageAccount(BankAccount account, long accountNumber, String tutor) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (account.getAccountType()!='U') throw new IllegalArgumentException("You can only add underage accounts on this option");
        account = new UnderageAccount(account.getHolder(), account.getOpeningDate(), account.getAccountNumber(), 'U', tutor);
        accountNumber = account.getAccountNumber();

        accountMap.put(accountNumber, account);

    }

    public void addBusinessAccount(BankAccount account, long accountNumber, int companyNumber) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (account.getAccountType()!='B') throw new IllegalArgumentException("You can only add business accounts on this option");
        account = new BusinessAccount(account.getHolder(), account.getOpeningDate(), account.getAccountNumber(), 'B', companyNumber);
        accountNumber = account.getAccountNumber();
        accountMap.put(account.getAccountNumber(), account);
    }


    public BankAccount findAccount(long accountNumber) {
        if (accountMap.containsKey(accountNumber)) {
            return accountMap.get(accountNumber);
        }
        return null;
    }

    public void deposit(Long accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " does not exist.");

        } else {
            account.deposit(amount);
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

import java.util.Date;
import java.util.Objects;

public class BankAccount {
    private Person holder;
    private Date openingDate;
    private long accountNumber;
    private double balance;
    private char accountType;

    public BankAccount(Person holder, Date openingDate, long accountNumber, char accountType) {
       if (accountType != 'P'&& accountType != 'U'&& accountType != 'B') throw new IllegalArgumentException("acccount type  must be or P or U or B");
        this.holder = holder;
        this.openingDate = openingDate;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0;
    }

    public Person getHolder() {
        return holder;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public char getAccountType() {
        return accountType;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Deposit money to this account
     * @param amount amount to Deposit
     */
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "deposit in account " + accountNumber);
    }

    /**
     * withdraw money to this account
     * @param amount amount to withdraw
     * @throws IllegalArgumentException if insufficient balance in account
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance in account" + accountNumber);
        }
        balance -= amount;
        System.out.println(amount + "withdraw from account " + accountNumber);
    }

    /**
     * transfert money to this account to the another account
     * verify the account have enought founds to transfert
     * @param amount amount to transfert
     * @param toAccount account to transfert
     * @throws IllegalArgumentException if amount<0 || account == null
     */
    public void transfer(BankAccount toAccount , double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount cannot be 0 or negative");
        if (toAccount==null) throw new IllegalArgumentException("account cannot be null");

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance in account" + accountNumber);
        }else
            balance -= amount;
            toAccount.deposit(amount);
        System.out.println(amount + " transferred from account " + accountNumber + " to account " + toAccount.getAccountNumber());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;
        return getAccountNumber() == that.getAccountNumber() && getAccountType() == that.getAccountType() && getHolder().equals(that.getHolder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHolder(), getOpeningDate(), getAccountNumber(), getBalance());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "holder=" + holder +
                ", openingDate=" + openingDate +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}
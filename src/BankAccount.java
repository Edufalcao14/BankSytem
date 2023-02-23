import java.util.Date;
import java.util.Objects;

public class BankAccount {
    private Person holder;
    private Date openingDate;
    private long accountNumber;
    private double balance;

    public BankAccount(Person holder, Date openingDate, long accountNumber) {
        this.holder = holder;
        this.openingDate = openingDate;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public Person getHolder() {
        return holder;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;
        return getAccountNumber() == that.getAccountNumber() && Double.compare(that.getBalance(), getBalance()) == 0 && Objects.equals(getHolder(), that.getHolder()) && Objects.equals(getOpeningDate(), that.getOpeningDate());
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
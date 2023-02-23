import java.util.Date;
import java.util.Objects;

public class PersonnalAccount extends BankAccount{

    private boolean isWorking;
    private int freeTransactions;
    private double transactionsFee;


    public PersonnalAccount(Person holder, Date openingDate, long accountNumber, double transactionsFee , boolean isWorking) {
        super(holder, openingDate, accountNumber);
        this.isWorking = isWorking;
        this.freeTransactions = 10;
        this.transactionsFee = transactionsFee;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public int getFreeTransactions() {
        return freeTransactions;
    }

    public double getTransactionsFee() {
        return transactionsFee;
    }

    public void setTransactionsFee(double transactionsFee) {
        this.transactionsFee = transactionsFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonnalAccount that)) return false;
        if (!super.equals(o)) return false;
        return isWorking() == that.isWorking();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWorking());
    }

    @Override
    public String toString() {
        return "underageAccount{" +
                "isWorking=" + isWorking +
                '}';
    }
}

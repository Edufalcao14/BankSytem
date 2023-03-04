import java.util.Date;
import java.util.Objects;

public class PersonalAccount extends BankAccount{

    private boolean isWorking;
    private int freeTransactions;
    private double transactionsFee;


    public PersonalAccount(Person holder, Date openingDate, long accountNumber, char accountType , boolean isWorking) {
        super(holder, openingDate, accountNumber,accountType);
        this.isWorking = isWorking;
        this.freeTransactions = 10;
        this.transactionsFee = 0.02; // 2% of the transaction value
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
        if (!(o instanceof PersonalAccount that)) return false;
        if (!super.equals(o)) return false;
        return isWorking() == that.isWorking();
    }

    /**
     * Deposit money to this account
     * @param amount amount to withdraw
     * @throws IllegalArgumentException if insufficient balance in account
     */
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    /**
     * withdraw money to this account
     *Personnal account are only allowed to withdraw 1500$ per day
     * @param amount amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if (amount>amount) throw new IllegalArgumentException("You cannot withdraw more than 1500$ per day");
        super.withdraw(amount);
    }

    /**
     * Transfert of money this account to another account
     *Personnal Account are only allowed to transfert 20 000$ per day
     * @param amount amount to withdraw
     */
    @Override
    public void transfer(BankAccount toAccount, double amount) {
        if (amount>amount) throw new IllegalArgumentException("You cannot transfert more than 20 000$ per day");
        super.transfer(toAccount, amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWorking());
    }

    @Override
    public String toString() {
        return "Personal Account : " + "\n" +
                "Holder=" + super.getHolder() + "\n" +
                "Opening Date=" + super.getOpeningDate() + "\n" +
                "Account Number=" + super.getAccountNumber() + "\n" +
                "Balance = " + getBalance() + "\n" +
                "Account Type : "+ getAccountType() + "\n" +
                "Is Working ? " + isWorking ;
    }
}

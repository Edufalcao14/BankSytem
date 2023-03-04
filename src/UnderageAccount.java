import java.util.Date;
import java.util.Objects;

public class UnderageAccount extends BankAccount {

    private String tutor;
    private double transactionsFee;

    public UnderageAccount(Person holder, Date openingDate, long accountNumber, char accountType, String tutor) {
        super(holder, openingDate, accountNumber , accountType);
        this.tutor=tutor;
        this.transactionsFee= 0;
    }

    public String getTutor() {
        return tutor;
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
     *Clients are only allowed to withdraw 500$ per day
     * @param amount amount to withdraw
     * @throws IllegalArgumentException if insufficient balance in account
     */
    @Override
    public void withdraw(double amount) {
        if (amount>500) throw new IllegalArgumentException("you cannot withdraw more than 500$ per day");
        super.withdraw(amount);
    }

    /**
     * Transfer money to this account
     *Underage Account are only allowed to transfert 500$ per day
     * @param amount amount to withdraw
     * @throws IllegalArgumentException if insufficient balance in account
     */
    @Override
    public void transfer(BankAccount toAccount, double amount) {
        if (amount>500) throw new IllegalArgumentException("you cannot transfert more than 500$ per day");
        super.transfer(toAccount, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnderageAccount that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getTutor(), that.getTutor());
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTutor());
    }

    @Override
    public String toString() {
        return "Under Age Account : " + "\n" +
                "Holder=" + super.getHolder() + "\n" +
                "Opening Date=" + super.getOpeningDate() + "\n" +
                "Account Number=" + super.getAccountNumber() + "\n" +
                "Balance = " + getBalance()+
                "Account Type : "+ super.getAccountType() + "\n" +
                "Tutor =" + tutor ;
    }
}


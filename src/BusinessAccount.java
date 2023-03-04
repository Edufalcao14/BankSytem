import java.util.Date;

public class BusinessAccount extends BankAccount {
    private int companyNumber;
    private double overdraftlimit;

    private double transactionsFee;

    public BusinessAccount(Person holder, Date openingDate, long accountNumber, char accountType, int companyNumber) {
        super(holder, openingDate, accountNumber, accountType);
        this.companyNumber = companyNumber;
        this.overdraftlimit = 5000;
        this.transactionsFee = 0.035; // 3,5%  of the transaction value
    }

    public double getOverdraftLimit() {
        return overdraftlimit;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public double getTransactionsFee() {
        return transactionsFee;
    }

    public void setTransactionsFee(double transactionsFee) {
        this.transactionsFee = transactionsFee;
    }

    /**
     * Add the desired amount to the account within the overdraft limit
     * verify if overdraft limit is respected
     * @param amount desired amount
     * @throws IllegalArgumentException if amount<0
     */
    public void overdraft (double amount){
        if(amount< 0) throw new IllegalArgumentException("amount must be positive");
        if (amount<=overdraftlimit){
            deposit(amount);
        }
        throw new IllegalArgumentException("You cannot use more than you overdraft limit :" + overdraftlimit);
    }

    /**
     * Transfer money  off  this account to another account
     * Bussiness account are allowed to transfert unlimited amount per day
     * @param amount amount to withdraw
     */
    @Override
    public void transfer(BankAccount toAccount, double amount) {
        super.transfer(toAccount, amount);
    }
    /**
     * Deposit money to this account
     * @param amount amount to withdraw
     */
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }
    /**
     * Withdraw money to this account
     *Bussiness account are only allowed to withdraw 10 000$ per day
     * @param amount amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 10000) throw new IllegalArgumentException("You cannot withdraw more than 5000 per day");
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "Business Account : " + "\n" +
                " Holder=" + super.getHolder() + "\n" +
                "Opening Date=" + super.getOpeningDate() + "\n" +
                "Account Number=" + super.getAccountNumber() + "\n" +
                "Balance = " + getBalance() +
                "Account Type : " + super.getAccountType() + "\n" +
                "Company Number=" + companyNumber + "\n" ;
    }
}

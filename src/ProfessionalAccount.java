import java.awt.image.BandCombineOp;
import java.util.Date;
import java.util.Objects;

public class ProfessionalAccount extends BankAccount {
    private long companyNumber;
    private double overdraftlimit;

    private double transactionsFee;

    public ProfessionalAccount(Person holder, Date openingDate, long accountNumber , long companyNumber ) {
        super(holder, openingDate, accountNumber);
        this.companyNumber = companyNumber;
        this.overdraftlimit = 5000;
        this.transactionsFee =0.035 ; // 3,5%  of the transaction value
    }

    public double getOverdraftlimit() {
        return overdraftlimit;
    }

    public void setTransactionsFee(double transactionsFee) {
        this.transactionsFee = transactionsFee;
    }

    @Override
    public String toString() {
        return "ProfessionalAccount{" +
                "companyNumber=" + companyNumber +
                '}';
    }
}

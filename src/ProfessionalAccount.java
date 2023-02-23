import java.awt.image.BandCombineOp;
import java.util.Date;
import java.util.Objects;

public class ProfessionalAccount extends BankAccount {
    private long companyNumber;
    private double overdraftlimit;

    private double transactionsFee;

    public ProfessionalAccount(Person holder, Date openingDate, long accountNumber , long companyNumber , double transactionsFee) {
        super(holder, openingDate, accountNumber);
        this.companyNumber = companyNumber;
        this.overdraftlimit = 5000;
        this.transactionsFee = transactionsFee;
    }

    public double getOverdraftlimit() {
        return overdraftlimit;
    }


    @Override
    public String toString() {
        return "ProfessionalAccount{" +
                "companyNumber=" + companyNumber +
                '}';
    }
}

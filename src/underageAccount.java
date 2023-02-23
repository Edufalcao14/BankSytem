import java.util.Date;
import java.util.Objects;

public class underageAccount extends BankAccount {

    private String tutor;
    private double transactionsFee;

    public underageAccount(Person holder, Date openingDate, long accountNumber, String tutor, double transactionsFee) {
        super(holder, openingDate, accountNumber);
        this.tutor=tutor;
        this.transactionsFee= 0;
    }

    public String getTutor() {
        return tutor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof underageAccount that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getTutor(), that.getTutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTutor());
    }
}

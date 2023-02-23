import java.util.Date;

public class Person {
    private String firstname;
    private String lastName;
    private long idNumber;
    private Adress address;
    private Date birthDate;

    public Person(String firstname, String lastName, long idNumber, Adress address, Date birthDate) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public Adress getAddress() {
        return address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber=" + idNumber +
                ", address=" + address +
                ", birthDate=" + birthDate +
                '}';
    }
}

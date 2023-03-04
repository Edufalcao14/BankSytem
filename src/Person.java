import java.util.Date;

public class Person {
    private String firstname;
    private String lastName;
    private int idNumber;
    private Adress address;
    private Date birthDate;

    public Person(String firstname, String lastName, int idNumber, Adress address, Date birthDate) {
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

    public int getIdNumber() {
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
        return "Person : " + '\'' +
                "Firstname='" + firstname + "\n" +
                ", lastName='" + lastName + "\n" +
                ", idNumber=" + idNumber + "\n" +
                ", address=" + address + "\n" +
                ", birthDate=" + birthDate + "\n" ;
    }
}

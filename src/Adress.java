public class Adress {
    private String street, city,zipCode;
    private int number;


    private Adress(String street, int number, String city,String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", number=" + number +
                '}';
    }
}

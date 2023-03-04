import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
public class MainBankSystemTest {
    public static void main(String[] args) {

        //---------------------------------Add 3 accoutns to test --------------------------------
        Adress ad1 = new Adress("Streeet 1",12,"Brussels","1080-20");
        Adress ad2 = new Adress("Streeet 2",32,"Antwerpen","1190-20");
        Date d1 = new Date(10/111/1970);
        Date d2 = new Date(10/111/1990);
        Person p1 = new Person("John", "Doe", 278732278,ad1,d1);
        Person p2 = new Person("Jane", "Doe",287398977, ad2,d2);
        Person p3 = new Person("Drake", "Doe",287398977, ad2,d2);
        BankAccount a1 = new BankAccount(p1, new Date(), 123456789, 'P');

        PersonalAccount a2 = new PersonalAccount(p2, new Date(), 234567890L, 'P', true);
        BusinessAccount a3 = new BusinessAccount(p1, new Date(), 345678901L, 'B', 1234567890);
        UnderageAccount a4 = new UnderageAccount(p3, new Date(), 456789012L, 'U', "John Doe"+"\n");
        System.out.println(a2);
        // -------------------------------- Menu test --------------------------------

        Scanner scanner = new Scanner(System.in);
            int options;

            do {
                System.out.println("---------------------Bank Account System--------------------------");
                System.out.println();
                System.out.println("1 -> Add an Personnal Account");
                System.out.println("2 -> Add an Professional Account");
                System.out.println("3 -> Add an Under Age Account");
                System.out.println("4 -> Find an account");
                System.out.println("5 -> Transfer Money");
                System.out.println("6 -> Deposit Money");
                System.out.println("7 -> Withdraw Money");


                options = scanner.nextInt();
                switch (options) {
                    case 1:
                        addPersonalAccount();
                        break;
                    case 2:
                        addBusinessAccount();
                        break;
                    case 3:
                        addUnderage();
                        break;
                    case 4:
                        findAccount();
                        break;
                    case 5:
                        trasfert();
                        break;
                    case 6:
                        deposit();
                        break;
                    case 7:
                        withdraw();
                        break;
                }
            } while (options >= 1 && options <= 2);

        }
    private static  BankSystem bankSystem = new BankSystem(new HashMap<>());
    private static Long randomNumberLong() {
        long leftLimit = 1L;
        long rightLimit = 999999L;
        long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        for (int i = 0; i < 7 ; i++) {
            generatedLong+=generatedLong;
        }
        return  generatedLong;
    }
        private static void addPersonalAccount(){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Fill in all the fields with your information");
            System.out.println("Your First name :");
            String firstName = scanner.nextLine();
            System.out.println("Your Last name :");
            String lastName = scanner.nextLine();
            System.out.println("Your id Number : ");
            int idNumber = scanner.nextInt();
            System.out.println("Your Birthday :");
            System.out.println("Year :");
            int yearDate = scanner.nextInt();
            System.out.println("month :");
            int monthDate = scanner.nextInt();
            System.out.println("day :");
            int dayDate = scanner.nextInt();
            Date birthday = new Date(yearDate, monthDate, dayDate);
            System.out.println("Your Adress :");
            String space1 = scanner.nextLine();
            System.out.println("city :");
            String city = scanner.nextLine();
            System.out.println("Street :");
            String street = scanner.nextLine();
            System.out.println("zipCode :");
            String zipCode = scanner.nextLine();
            System.out.println("number :");
            int number = scanner.nextInt();
            Adress adress = new Adress(street,number,city,zipCode);
            Person person = new Person(firstName,lastName,idNumber,adress,birthday);

            Long accountNumber = MainBankSystemTest.randomNumberLong();
            Date dateNow =  Date.from(Instant.now());
            char accountType = 'P';
            BankAccount account = new BankAccount(person,dateNow,accountNumber,accountType);
            System.out.println("Are you working ? ");
            Boolean isWorking = scanner.nextBoolean();
            PersonalAccount personalAccount = new PersonalAccount(account.getHolder(),account.getOpeningDate(),account.getAccountNumber(),account.getAccountType(),isWorking);
            System.out.println("Your information ");
            System.out.println(personalAccount.toString());

            bankSystem.addPersonalAccount(account,account.getAccountNumber(),isWorking);
        }
        private static void addBusinessAccount(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Fill in all the fields with your information");
            System.out.println("Your First name :");
            String firstName = scanner.nextLine();
            System.out.println("Your Last name :");
            String lastName = scanner.nextLine();
            System.out.println("Your id Number : ");
            int idNumber = scanner.nextInt();
            System.out.println("Your Birthday :");
            System.out.println("Year :");
            int yearDate = scanner.nextInt();
            System.out.println("month :");
            int monthDate = scanner.nextInt();
            System.out.println("day :");
            int dayDate = scanner.nextInt();
            Date birthday = new Date(yearDate, monthDate, dayDate);
            System.out.println("Your Adress :");
            String space1 = scanner.nextLine();
            System.out.println("city :");
            String city = scanner.nextLine();
            System.out.println("Street :");
            String street = scanner.nextLine();
            System.out.println("zipCode :");
            String zipCode = scanner.nextLine();
            System.out.println("number :");
            int number = scanner.nextInt();
            Adress adress = new Adress(street,number,city,zipCode);
            Person person = new Person(firstName,lastName,idNumber,adress,birthday);

            Long accountNumber = MainBankSystemTest.randomNumberLong();
            Date dateNow =  Date.from(Instant.now());
            char accountType = 'B';
            BankAccount account = new BankAccount(person,dateNow,accountNumber,accountType);
            System.out.println("Company Number ? ");
            int companyNumber = scanner.nextInt();
            BusinessAccount businessAccount = new BusinessAccount(account.getHolder(),account.getOpeningDate(),account.getAccountNumber(),account.getAccountType(),companyNumber);
            System.out.println("Your information ");
            System.out.println(businessAccount.toString());
            
            bankSystem.addBusinessAccount(account,account.getAccountNumber(),companyNumber);
        }
        private static void addUnderage(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Fill in all the fields with your information");
            System.out.println("Your First name :");
            String firstName = scanner.nextLine();
            System.out.println("Your Last name :");
            String lastName = scanner.nextLine();
            System.out.println("Your id Number : ");
            int idNumber = scanner.nextInt();
            System.out.println("Your Birthday :");
            System.out.println("Year :");
            int yearDate = scanner.nextInt();
            System.out.println("month :");
            int monthDate = scanner.nextInt();
            System.out.println("day :");
            int dayDate = scanner.nextInt();
            Date birthday = new Date(yearDate, monthDate, dayDate);
            System.out.println("Your Adress :");
            String space1 = scanner.nextLine();
            System.out.println("city :");
            String city = scanner.nextLine();
            System.out.println("Street :");
            String street = scanner.nextLine();
            System.out.println("zipCode :");
            String zipCode = scanner.nextLine();
            System.out.println("number :");
            int number = scanner.nextInt();
            Adress adress = new Adress(street,number,city,zipCode);
            Person person = new Person(firstName,lastName,idNumber,adress,birthday);

            Long accountNumber = MainBankSystemTest.randomNumberLong();
            Date dateNow =  Date.from(Instant.now());
            char accountType = 'U';
            BankAccount account = new BankAccount(person,dateNow,accountNumber,accountType);
            System.out.println("Tutor ? ");
            String tutor = scanner.nextLine();
            UnderageAccount underageAccount = new UnderageAccount(account.getHolder(),account.getOpeningDate(),account.getAccountNumber(),account.getAccountType(),tutor);
            System.out.println("Your information ");
            System.out.println(underageAccount.toString());

            bankSystem.addUnderageAccount(account,account.getAccountNumber(),tutor);
        }
    private static void findAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the account number where you want to look up the information ?");
        Long accountNumber = scanner.nextLong();
        System.out.println(bankSystem.findAccount(accountNumber));
    }
    private static void trasfert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please inform the account you want to transfer the money from: ");
        long accountNumber = scanner.nextLong();
        System.out.println("Please inform the account you want to transfer the money to: ");
        long accountNumberTo = scanner.nextLong();
        System.out.println("Please inform the amount you want to transfer ");
        double amount = scanner.nextDouble();
        bankSystem.transfer(accountNumber,accountNumberTo,amount);
    }
    private static void deposit(){

    }
    private static void withdraw(){

    }
}

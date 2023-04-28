import java.util.Scanner;
 interface Salary {
    double salaryToPay(double hours, double rate);

    default double salaryForOvertime(double hours, double rate) {
        if (hours > 40) {
            double overtimeHours = hours - 40;
            double overtimeRate = rate * 1.5;
            return overtimeHours * overtimeRate;
        }
        return 0.0;
    }

    static int Bonus(int yearsOfExperience) {

        if(yearsOfExperience >= 5) {
            return 100;
        }
        else {
            return 0;
        }
    }

}
class Person {
    private String surname;
    private String firstName;
    private String street;
    private String zipCode;
    private String city;

    public Person() {

    }

    public Person(String surname, String firstName, String street, String zipCode, String city) {
        this.surname = surname;
        this.firstName = firstName;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    //Method for initialization
    public void initialize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your surname: ");
        this.surname = scanner.nextLine();
        System.out.println("Enter your first name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter your street: ");
        this.street = scanner.nextLine();
        System.out.println("Enter your zip code: ");
        this.zipCode = scanner.nextLine();
        System.out.println("Enter your city: ");
        this.city = scanner.nextLine();
    }

    //Method for displaying datas
    public void print() {
        System.out.println("Your surname is :" + this.surname);
        System.out.println("Your first name is :" + this.firstName);
        System.out.println("Your street name is :" + this.street);
        System.out.println("Your zip code is :" + this.zipCode);
        System.out.println("Your city is :" + this.city);
    }

    class Staff extends Person implements Salary {
        private String education;
        private String position;
        private double hours;
        private double rate;
        private int yearsOfExperience;


        public Staff() {

        }

        public Staff(String education, String position) {
            this.education = education;
            this.position = position;
            this.hours = hours;
            this.rate = rate;
            this.yearsOfExperience = yearsOfExperience;
        }

        public void initialize1() {
            super.initialize();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your education : ");
            this.education = scanner.nextLine();
            System.out.println("Enter your position : ");
            this.position = scanner.nextLine();
            System.out.print("Enter hours worked: ");
            this.hours = scanner.nextDouble();
            System.out.print("Enter hourly rate: ");
            this.rate = scanner.nextDouble();
            System.out.print("Enter years of experience: ");
            this.yearsOfExperience = scanner.nextInt();
        }

        public void print1() {
            super.print();
            System.out.println("Your education is :" + this.education);
            System.out.println("Your position is :" + this.position);
            System.out.println("Hours worked: " + this.hours);
            System.out.println("Hourly rate: " + this.rate);
            System.out.println("Years of experience: " + this.yearsOfExperience);
            System.out.println("Base salary: " + salaryToPay(hours, rate));
            System.out.println("Overtime pay: " + salaryForOvertime(hours, rate));
            System.out.println("Bonus eligible: " + Salary.Bonus(yearsOfExperience));
        }

        @Override
        public double salaryToPay(double hours, double rate) {
            return hours * rate;
        }

    }

    public class Main {
        public void main(String[] args) {
            Staff staff = new Staff();
            staff.initialize1();
            staff.print1();
        }

    }
}

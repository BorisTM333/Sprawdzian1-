class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private int age;
    private String email;
    private boolean isWorking;

    public Employee(String firstName, String lastName, String position, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
        this.email = email;
        this.isWorking = false;
    }

    public void login() {
        System.out.println(firstName + " " + lastName + " zalogował się do systemu.");
        isWorking = true;
    }

    public void startWork() {
        if (!isWorking) {
            System.out.println(firstName + " " + lastName + " rozpoczął pracę.");
            isWorking = true;
        } else {
            System.out.println(firstName + " " + lastName + " już pracuje.");
        }
    }

    public void finishWork() {
        if (isWorking) {
            System.out.println(firstName + " " + lastName + " zakończył pracę.");
            isWorking = false;
        } else {
            System.out.println(firstName + " " + lastName + " nie pracuje.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

class Manager extends Employee {
    private String department;
    private int subordinateCount;
    private boolean isLoggedIn;

    public Manager(String firstName, String lastName, String position, String email, int age, String department, int subordinateCount) {
        super(firstName, lastName, position, email, age);
        this.department = department;
        this.subordinateCount = subordinateCount;
        this.isLoggedIn = false;
    }

    public void assignTask(String employeeName, String task) {
        System.out.println("Menedżer " + getFirstName() + " " + getLastName() + " przydzielił zadanie \"" + task + "\" pracownikowi " + employeeName + ".");
    }

    public void reviewReports() {
        System.out.println("Menedżer " + getFirstName() + " " + getLastName() + " przegląda raporty.");
    }

    public void displayManagerInfo() {
        System.out.println("Menedżer: " + getFirstName() + " " + getLastName());
        System.out.println("Dział: " + department);
        System.out.println("Liczba niewolników: " + subordinateCount);
        System.out.println("Status zalogowania: " + (isLoggedIn ? "Zalogowany" : "Nie zalogowany"));
    }

    public void login() {
        super.login();
        isLoggedIn = true;
    }

    public void logout() {
        System.out.println(getFirstName() + " " + getLastName() + " wylogował się z systemu.");
        isLoggedIn = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Janek", "Czarny", "Mechanik", "murzyn420@wp.pl", 30);
        employee.login();
        employee.startWork();
        employee.finishWork();

        Manager manager = new Manager("Stachu", "Czarniejszy", "Wyższy-Mechanik", "watafak@gmeijl.pl", 35, "Naprawa", 5);
        manager.login();
        manager.assignTask("Janek Czarny", "Naprawa silnika mercedesa SLS");
        manager.reviewReports();
        manager.displayManagerInfo();
        manager.logout();
    }
}

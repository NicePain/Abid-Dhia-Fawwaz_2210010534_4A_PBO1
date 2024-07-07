package employeemanagement;

import java.util.Scanner;
import java.util.InputMismatchException;

// 1. Class 
class Employee {
    // 3. Atribut dan encapsulation
    private String name;
    private int age;
    private String position;

    // 4. Constructor
    public Employee(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    // 5. Mutator (setter)
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // 6. Accessor (getter)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    // 9. Polymorphism
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Position: " + position);
    }
}

// 8. Inheritance
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int age, String position, int teamSize) {
        super(name, age, position);
        this.teamSize = teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    // 9. Polymorphism (Overriding)
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Team Size: " + teamSize);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee[] employees = new Employee[10]; // 13. Array
        int employeeCount = 0;

        while (true) { // 11. Perulangan
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            // 10. Seleksi
            switch (option) {
                case 1:
                    try {
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter position: ");
                        String position = scanner.next();
                        System.out.print("Is this employee a manager? (yes/no): ");
                        String isManager = scanner.next();

                        if (isManager.equalsIgnoreCase("yes")) {
                            System.out.print("Enter team size: ");
                            int teamSize = scanner.nextInt();
                            employees[employeeCount++] = new Manager(name, age, position, teamSize);
                        } else {
                            employees[employeeCount++] = new Employee(name, age, position);
                        }
                    } catch (InputMismatchException e) { // 14. Error Handling
                        System.out.println("Invalid input, please try again.");
                        scanner.next(); // clear the invalid input
                    }
                    break;
                case 2:
                    for (int i = 0; i < employeeCount; i++) {
                        employees[i].displayInfo();
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}

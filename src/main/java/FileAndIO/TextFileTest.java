package FileAndIO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class TextFileTest {


    public static void main(String[] args) throws IOException {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Harry Hacker", 35500d, LocalDate.of(1989, 10, 1));
        employees[1] = new Employee("Carl Cracker", 75000d, LocalDate.of(1987, 12, 15));
        employees[2] = new Employee("Tony Tester", 30000d, LocalDate.of(1990, 3, 15));

        try (var out = new PrintWriter(
                System.getProperty("user.dir") + "/IOPractice/employeeList.bat",
                StandardCharsets.UTF_8
        )) {
            writeData(employees, out);
        }

        try (var in = new Scanner(
                new FileInputStream(
                        System.getProperty("user.dir") +
                                "/IOPractice/employeeList.bat"
                ),
                StandardCharsets.UTF_8
        )) {
            Employee[] readResult = readData(in);
            for (Employee employee : readResult) {
                System.out.println(employee);
            }
        }
    }


    private static void writeData(Employee[] employees, PrintWriter out) {
        out.println(employees.length);

        for (Employee employee : employees) {
            Employee.writeEmployee(out, employee);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = Employee.readEmployee(in);
        }
        return employees;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Employee {
        private String name;
        private Double salary;
        private LocalDate date;

        public static void writeEmployee(PrintWriter writer, Employee e) {
            String result = e.getName() + "|" + e.getSalary() + "|" + e.getDate();
            writer.println(result);
        }

        public static Employee readEmployee(Scanner in) {
            String line = in.nextLine();
            String[] tokens = line.split("\\|");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            LocalDate hireDate = LocalDate.parse(tokens[2]);
            int year = hireDate.getYear();
            int month = hireDate.getMonthValue();
            int day = hireDate.getDayOfMonth();
            return new Employee(
                    name, salary, LocalDate.of(year, month, day)
            );
        }
    }
}


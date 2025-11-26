package org.ies.tierno.company.readers;

import org.ies.tierno.company.model.Department;
import org.ies.tierno.company.model.Employee;

import java.util.Scanner;

public class DepartmentReader {
    private final Scanner scanner;
    private final EmployeeReader employeeReader;

    public DepartmentReader(Scanner scanner, EmployeeReader employeeReader) {
        this.scanner = scanner;
        this.employeeReader = employeeReader;
    }

    public Department read() {
        System.out.println("Introduce la información del departamento:");
        System.out.println("Nombre:");
        String name = scanner.nextLine();
        System.out.println("Presupuesto:");
        double budget = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Cuantos empleados hay en este departamento?");
        int numberOfEmployees = scanner.nextInt();
        scanner.nextLine();
        while (numberOfEmployees < 0) {
            System.out.println("Opcion invalida.Enter para continuar....");
            scanner.nextLine();
            System.out.println("Cuantos empleados hay en este departamento?");
            numberOfEmployees = scanner.nextInt();
            scanner.nextLine();
        }
        Employee[] employees = new Employee[numberOfEmployees];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = employeeReader.read();
        }
        return new Department(name, budget, employees);
    }
}

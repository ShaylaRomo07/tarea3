package org.ies.tierno.company.readers;

import org.ies.tierno.company.model.Company;
import org.ies.tierno.company.model.Department;

import java.util.Scanner;

public class CompanyReader {
    private final Scanner scanner;
    private final DepartmentReader departmentReader;

    public CompanyReader(Scanner scanner, DepartmentReader departmentReader) {
        this.scanner = scanner;
        this.departmentReader = departmentReader;
    }

    public Company read() {
        System.out.println("Introduce la informacion de la compañia");
        System.out.println("Nombre:");
        String name = scanner.nextLine();
        System.out.println("CIF:");
        String cif = scanner.nextLine();
        System.out.println("Cuantos departamentos tiene?");
        int numberOfDepartments = scanner.nextInt();
        scanner.nextLine();
        while (numberOfDepartments < 0) {
            System.out.println("Opcion invalida.Enter para continuar....");
            scanner.nextLine();
            System.out.println("Cuantos departamentos tiene?");
            numberOfDepartments = scanner.nextInt();
            scanner.nextLine();
        }
        Department[] departments = new Department[numberOfDepartments];
        for (int i = 0; i < departments.length; i++) {
            departments[i] = departmentReader.read();
        }
        return new Company(name, cif, departments);
    }
}

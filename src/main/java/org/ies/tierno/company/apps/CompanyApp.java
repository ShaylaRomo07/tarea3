package org.ies.tierno.company.apps;

import org.ies.tierno.company.model.Company;
import org.ies.tierno.company.model.Department;
import org.ies.tierno.company.model.Employee;
import org.ies.tierno.company.readers.CompanyReader;

import java.util.Scanner;

public class CompanyApp {
    private final Scanner scanner;
    private final CompanyReader companyReader;


    public CompanyApp(Scanner scanner, CompanyReader companyReader) {
        this.scanner = scanner;
        this.companyReader = companyReader;
    }

    public void run() {
        Company company = companyReader.read();
        int option;
        do {
            System.out.println("¿Qué desea saber?");
            System.out.println("    1.Informacion del departamento");
            System.out.println("    2.Empleados del departamento");
            System.out.println("    3.Empleado especifico del departamento");
            System.out.println("    4.Salir");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                Department department = infoDepartment(company);
                if (department != null) {
                    System.out.println("Nombre: " + department.getName());
                    System.out.println("Presupuesto: " + department.getBudget());
                    showInfoManyEmployees(department);
                }
                enter();
            } else if (option == 2) {
                Department department = infoDepartment(company);
                if (department != null) {
                    showInfoManyEmployees(department);
                }
                enter();
            } else if (option == 3) {
                Department department = infoDepartment(company);
                if (department != null) {
                    System.out.println("Introduzca el nif del empleado");
                    String nif = scanner.nextLine();
                    Employee employee = findEmployee(nif, department);
                    if (employee == null) {
                        System.out.println("No se encuentra el empleado en el departamento");
                    } else {
                        showInfoEmployee(employee);
                    }
                }
                enter();
            } else if (option == 4) {
                System.out.println("Saliendo......");
            } else {
                System.out.println("Opción invailda");
                enter();
            }
        } while (option != 4);
    }

    public Department infoDepartment(Company company) {
        System.out.println("¿Que departamento estas buscando?");
        String nameDepartment = scanner.nextLine();
        for (Department department : company.getDepartments()) {
            if (department.getName().equals(nameDepartment)) {
                return department;
            }
        }
        System.out.println("No se encuentra el departamento");
        return null;
    }

    public void showInfoManyEmployees(Department department) {
        Employee[] employees = department.getEmployees();
        System.out.println("Empleados:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println("    Empleado " + (i + 1) + ":");
            showInfoEmployee(employees[i]);
        }
    }

    public void showInfoEmployee(Employee employee) {
        System.out.println("        NIF:" + employee.getNif());
        System.out.println("        Nombre: " + employee.getName() + " " + employee.getSurname());
        System.out.println("        Puesto: " + employee.getWorkstation());
    }

    public Employee findEmployee(String nif, Department department) {
        for (Employee employee : department.getEmployees()) {
            if (employee.getNif().equals(nif)) {
                return employee;
            }
        }
        return null;
    }

    public void enter() {
        System.out.println();
        System.out.print("Enter para continuar...");
        scanner.nextLine();
    }
}

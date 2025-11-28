package org.ies.tierno.company.readers;

import org.ies.tierno.company.model.Employee;
import org.ies.tierno.company.model.Workstation;

import java.util.Scanner;

public class EmployeeReader {
    private final Scanner scanner;

    public EmployeeReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Employee read() {
        System.out.println("Introduce la información del empleado:");
        System.out.println("NIF:");
        String nif = scanner.nextLine();

        System.out.println("Nombre/s:");
        String name = scanner.nextLine();

        System.out.println("Apellidos:");
        String surname = scanner.nextLine();
        System.out.println("En que puesto trabaja:");
        System.out.println("    0.No asignado");
        System.out.println("    1.Jefe de proyecto");
        System.out.println("    2.Programador");
        System.out.println("    3.Diseñador");
        int option = scanner.nextInt();
        scanner.nextLine();
        while (option < 0 || option > 3) {
            System.out.println("Opcion invalida.Enter para continuar....");
            scanner.nextLine();
            System.out.println("En que puesto trabaja:");
            System.out.println("    0.No asignado");
            System.out.println("    1.Jefe de proyecto");
            System.out.println("    2.Programador");
            System.out.println("    3.Diseñador");
            option = scanner.nextInt();
        }
        Workstation workstation;
        if (option == 1) {
            workstation = Workstation.jefe_de_proyecto;
        } else if (option == 2) {
            workstation = Workstation.programador;
        } else if (option == 3) {
            workstation = Workstation.disenador;
        } else {
            workstation = Workstation.no_asignado;
        }
        return new Employee(nif, name, surname, workstation);
    }
}

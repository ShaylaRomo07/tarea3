package org.ies.tierno.company.readers;

import org.ies.tierno.company.model.Company;

import java.util.Scanner;

public class CompanyReader {
    private final Scanner scanner;
    private final DepartmentReader departmentReader;

    public CompanyReader(Scanner scanner, DepartmentReader departmentReader) {
        this.scanner = scanner;
        this.departmentReader = departmentReader;
    }

    public Company read() {

    }
}

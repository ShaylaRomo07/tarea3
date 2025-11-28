package org.ies.tierno.company;

import org.ies.tierno.company.apps.CompanyApp;
import org.ies.tierno.company.readers.CompanyReader;
import org.ies.tierno.company.readers.DepartmentReader;
import org.ies.tierno.company.readers.EmployeeReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        EmployeeReader employeeReader=new EmployeeReader(scanner);
        DepartmentReader departmentReader=new DepartmentReader(scanner,employeeReader);
        CompanyReader companyReader=new CompanyReader(scanner,departmentReader);
        CompanyApp companyApp=new CompanyApp(scanner,companyReader);
        companyApp.run();
    }
}

package org.ies.tierno.company.model;

import java.util.Objects;

public class Employee {
    private String nif;
    private String name;
    private String surname;
    private Workstation workstation;

    public Employee(String nif, String name, String surname, Workstation workstation) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.workstation = workstation;
    }


    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Workstation getWorkstation() {
        return workstation;
    }

    public void setWorkstation(Workstation workstation) {
        this.workstation = workstation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(nif, employee.nif) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && workstation == employee.workstation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname, workstation);
    }
}

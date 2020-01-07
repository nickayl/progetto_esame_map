package com.biblioteca.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The Customer class encapsulates information and business logic for managing the customers of the library.
 * The ordering defined here is by full name ascending.
 */
public class Customer implements Comparable<Customer> {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String fiscalCode;
    private String phoneNumber;

    private List<Loan> loans = new ArrayList<>();

    public Customer(int id, String firstName, String lastName, String email, String fiscalCode, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fiscalCode = fiscalCode;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName, String email, String fiscalCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.fiscalCode = fiscalCode;
        this.phoneNumber = phoneNumber;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, fiscalCode);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setId(int lastId) {
        this.id = lastId;
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Customer o) {
        return Integer.compare(id, o.getId());
    }
}

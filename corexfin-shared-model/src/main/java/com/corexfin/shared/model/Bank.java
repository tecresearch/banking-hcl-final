package com.corexfin.shared.model;
import java.util.Objects;

/**
 * Write the documentation of Bank Model
 *
 *
 */

public class Bank {

    private String id;
    private String name;

    private String domain;

    private String username;

    private String password;

    private String owner;

    private String email;

    private String office;

    private String status;

    private String role;

    public Bank(){}

    public Bank(String name, String domain, String username, String password, String owner, String email, String office, String status, String role) {
        this.name = name;
        domain = domain;
        this.username = username;
        this.password = password;
        this.owner = owner;
        this.email = email;
        this.office = office;
        this.status = status;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bank bank)) return false;
        return Objects.equals(username, bank.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", Domain='" + domain + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", owner='" + owner + '\'' +
                ", email='" + email + '\'' +
                ", office='" + office + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

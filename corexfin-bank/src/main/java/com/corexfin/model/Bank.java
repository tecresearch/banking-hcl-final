package com.corexfin.model;

import com.corexfin.pk_id_generator.BankIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * Write the documentation of Bank Model
 *
 *
 */
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(generator = "bank_uuid")
    @GenericGenerator(name="bank_uuid",type= BankIdGenerator.class)
    @Column(name = "bank_id", unique = true)
    private String id;
    @Column(name="bank_name")
    private String name;
    @Column(name="bank_domain")
    private String domain;
    @Column(name="bank_username")
    private String username;
    @Column(name="bank_password")
    private String password;
    @Column(name="bank_owner")
    private String owner;
    @Column(name="bank_email")
    private String email;
    @Column(name="head_office")
    private String office;
    @Column(name="bank_status")
    private String status;
    @Column(name = "bank_role")
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

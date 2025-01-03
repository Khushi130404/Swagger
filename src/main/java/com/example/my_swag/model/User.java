package com.example.my_swag.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    public int uid;

    @Column
    public String mail;

    @Column
    public String pass;

    @Column
    public String name;

    @Column
    public int age;

    @Column
    public String mobile;

    public User()
    {}

    public User(String mail, String pass, String name, int age, String mobile) {
        this.mail = mail;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }
}

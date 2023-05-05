package com.shivu.financetracker.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.persistence.Column;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotNull
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;

    private boolean loggedIn;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Finance> finance;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Savings> saving;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Profile> profile;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Budget> budget;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<LinkedAccounts> account;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<LinkedCards> card;
}

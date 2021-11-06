package com.example.psp3dalis.model;


import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "VARDAS")
    private String name;

    @Column(name = "PAVARDE")
    private String surname;

    @Column(name = "TELEFONO_NUMERIS")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADRESAS")
    private String address;

    @Column(name = "SLAPTAZODIS")
    private String password;

    public void update(User user) {
        this.name = user.getName();
        this.surname = user.getSurname() ;
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.password = user.getPassword();
    }
}

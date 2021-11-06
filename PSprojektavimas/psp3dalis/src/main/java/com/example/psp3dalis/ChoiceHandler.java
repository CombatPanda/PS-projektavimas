package com.example.psp3dalis;

import com.example.psp3dalis.model.User;
import com.example.psp3dalis.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ChoiceHandler {

    Scanner in = new Scanner(System.in);

    private final UserService userService;

    public void addUser() {
        System.out.println("Įveskite vartotojo duomenis");
        System.out.println("Vardas");
        var name = in.next();
        System.out.println("Pavarde");
        var surname = in.next();
        System.out.println("Telefono numeris");
        var phoneNumber = in.next();
        System.out.println("Email");
        var email = in.next();
        System.out.println("Adresas");
        var address = in.next();
        System.out.println("Slaptazodis");
        var password = in.next();
        var user = User.builder()
                .name(name)
                .surname(surname)
                .phoneNumber(phoneNumber)
                .email(email)
                .address(address)
                .password(password)
                .build();
        var userId = userService.addUser(user);
        if (userId != null) {
            System.out.println("Issaugoto vartotojo id: " + userId);
            System.out.println("~~~~~~~~~~~~~~~~~~");
        } else {
            System.out.println("Vartotojo issaugoti nepavyko");
            System.out.println("~~~~~~~~~~~~~~~~~~");
        }

    }

    public void editUserById() {
        System.out.println("Įveskite vartotojo duomenis");
        System.out.println("Id");
        var id = in.nextLong();
        System.out.println("Vardas");
        var name = in.next();
        System.out.println("Pavarde");
        var surname = in.next();
        System.out.println("Telefono numeris");
        var phoneNumber = in.next();
        System.out.println("Email");
        var email = in.next();
        System.out.println("Adresas");
        var address = in.next();
        System.out.println("Slaptazodis");
        var password = in.next();
        var user = User.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .phoneNumber(phoneNumber)
                .email(email)
                .address(address)
                .password(password)
                .build();
        userService.updateUser(user);
    }

    public void showUsers() {
        var users = userService.getAllUsers();
        System.out.println("------------------");
        users.forEach(user -> System.out.println(user.getName() + " " + user.getSurname() + " " + user.getEmail()));
        System.out.println("------------------");
    }

    public void showUserById() {
        System.out.println("------------------");
        System.out.println("Iveskite vartotojo id");
        var id = in.nextLong();
        var user = userService.getUserById(id);
        if (user != null) {
            System.out.println(user.getName() + " " + user.getSurname() + " " + user.getEmail());
            System.out.println("------------------");
        } else {
            System.out.println("User with id - " + id + " doesnt exist");
        }
    }

    public void deleteUserById() {
        System.out.println("Iveskite vartotojo id");
        var id = in.nextLong();
        userService.deleteById(id);
    }
}

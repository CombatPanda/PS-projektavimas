package com.example.psp3dalis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    ChoiceHandler choiceHandler;

    @Override
    public void run(String... args) throws Exception {
        Scanner in = new Scanner(System.in);
        displayOptions();
        var choice = in.nextInt();
        do {
            switch (choice) {
                case 1:
                    choiceHandler.addUser();
                    break;
                case 2:
                    choiceHandler.editUserById();
                    break;
                case 3:
                    choiceHandler.showUsers();
                    break;
                case 4:
                    choiceHandler.showUserById();
                    break;
                case 5:
                    choiceHandler.deleteUserById();
                case 6:
                    break;
            }
            displayOptions();
            choice = in.nextInt();
        }
        while (choice != 6);

    }

    private void displayOptions() {
        System.out.println("1.Pridėti vartotoją");
        System.out.println("2.Keisti vartotojo duomenis jo pagal ID");
        System.out.println("3.Parodyti visus vartotojus");
        System.out.println("4.Parodyti vartotoją pagal ID");
        System.out.println("5.Ištrinti vartotoją pagal ID");
    }

}

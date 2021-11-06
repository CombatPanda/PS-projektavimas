package com.example.psp3dalis.services;

import com.example.psp3dalis.model.User;
import com.example.psp3dalis.repository.UserRepository;
import com.example.psp3dalis.validator.EmailValidator;
import com.example.psp3dalis.validator.PasswordChecker;
import com.example.psp3dalis.validator.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long addUser(User user) {
        if (validateUserFields(user)) {
            return userRepository.save(user).getId();
        }
        return null;
    }

    public void updateUser(User newUser) {
        var user = userRepository.findById(newUser.getId()).orElse(null);
        if (user != null && validateUserFields(newUser)) {
            user.update(newUser);
            userRepository.save(user);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    private boolean validateUserFields(User user) {
        EmailValidator emailValidator = new EmailValidator();
        PasswordChecker passwordChecker = new PasswordChecker(5);
        PhoneValidator phoneValidator = new PhoneValidator("+370", 12);
        var emailValidated = emailValidator.validate(user.getEmail());
        var passwordValidated = passwordChecker.validate(user.getPassword());
        var phoneValidated = phoneValidator.validate(user.getPhoneNumber());

        if (emailValidated == false) {
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println("ERROR validating EMAIL. email validator returned - \n" + emailValidated);
            System.out.println("~~~~~~~~~~~~~~~~~~");
        }
        if (passwordValidated == false) {
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println("ERROR validating PASSWORD. password validator returned - \n" + passwordValidated);
            System.out.println("~~~~~~~~~~~~~~~~~~");
        }
        if (phoneValidated == false) {
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println("ERROR validating PHONE. phone validator returned - \n" + phoneValidated);
            System.out.println("~~~~~~~~~~~~~~~~~~");
        }
        return emailValidated && passwordValidated && phoneValidated;
    }
}

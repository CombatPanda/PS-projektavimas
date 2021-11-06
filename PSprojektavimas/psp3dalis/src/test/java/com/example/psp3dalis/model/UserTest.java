package com.example.psp3dalis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void update() {
        var user = new User(1L, "Name", "Surname", "+37060806977", "email@gmail.com", "Adress", "Password123123!");
        var newUser = new User();
        newUser.update(user);

        assertNull(newUser.getId());
        assertEquals(user.getName(), newUser.getName());
        assertEquals(user.getSurname(), newUser.getSurname());
        assertEquals(user.getPhoneNumber(), newUser.getPhoneNumber());
        assertEquals(user.getEmail(), newUser.getEmail());
        assertEquals(user.getAddress(), newUser.getAddress());
        assertEquals(user.getPassword(), newUser.getPassword());
    }
}
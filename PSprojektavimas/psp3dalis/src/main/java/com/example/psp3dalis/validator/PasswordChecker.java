package com.example.psp3dalis.validator;

public class PasswordChecker {
	 private int minLength = 0;
	    private char[] specialCharacters = {'!', '@', '$'}; // Default Characters

	    public void changeSpecialCharacters(char[] specialCharacters) {
	        this.specialCharacters = specialCharacters;
	    }

	    public PasswordChecker(int minLength) {
	        this.minLength = minLength;
	    }


	    public boolean validate(String password) {
	        if (password == null)
	            return false;
	        if (password.length() < minLength)
	            return false;
	        char[] letters = password.toCharArray();
	        boolean hasUppercase = false;
	        boolean hasSpecialSymbol = false;
	        for (char letter : letters
	        ) {
	            if ((letter >= 'A' && letter <= 'Z'))
	                hasUppercase = true;
	            for (char special : specialCharacters) {
	                if (letter == special)
	                    hasSpecialSymbol = true;
	                break;
	            }
	        }
	        return hasUppercase && hasSpecialSymbol;
	    }
}

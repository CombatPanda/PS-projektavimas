package com.example.psp3dalis.validator;

public class PhoneValidator {
	int phonenumberLength;
    String countryCode;

    public PhoneValidator(String countryCode, int phonenumberLength) {
        this.countryCode = countryCode;
        this.phonenumberLength = phonenumberLength;
    }

    public boolean validate(String phonenumber) {
        if (phonenumber == null)
            return false;
        if(phonenumber.contains(" "))
            return false;
        int length = phonenumber.length();
        if (phonenumber.charAt(0) == '8') {
            phonenumber = "+370".concat(phonenumber.substring(1, length));
            length = phonenumber.length();
        }
        if (length != phonenumberLength)
            return false;
        if (!phonenumber.startsWith(countryCode))
            return false;
        phonenumber = phonenumber.substring(1, length);
        char[] numbers = phonenumber.toCharArray();
        for (char number: numbers
             ) {
            if(!Character.isDigit(number))
                return false;

        }
        return true;
    }
}

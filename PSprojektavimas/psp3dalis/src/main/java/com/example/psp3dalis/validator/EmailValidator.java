package com.example.psp3dalis.validator;

public class EmailValidator {
	public boolean validate(String email) {
        if (email == null)
            return false;
        if (!email.contains("@"))
            return false;
        if (email.contains(" "))
            return false;

        String name = email.substring(0, email.indexOf("@"));
        String domain = email.substring(email.indexOf("@") + 1, email.length());

        return validateDomain(domain) && validateName(name) ;
    }
    private boolean validateName(String name) {
        int length = name.length();
        if(length > 64)
            return false;
        char[] nameLetters = name.toCharArray();
        for (char letter : nameLetters
        ) {
            if (letter < 33 || letter > 125)
                return false;
        }
        return true;
    }

    private boolean validateDomain(String domain) {

        if(!domain.contains("."))
            return false;
        boolean validDomain = validateDomainName(domain.substring(0, domain.lastIndexOf('.')));
        boolean validTLD = validateTLD(domain.substring(domain.lastIndexOf('.')+1, domain.length()));
        return validDomain && validTLD;

    }

    private boolean validateDomainName(String domainName) {
        int length = domainName.length();
        if(length > 253 || length < 1)
            return false;
        char[] domainLetters = domainName.toCharArray();
        for (char letter: domainLetters
        ) {
            if(letter != '-' && letter != '.')
                if(!Character.isLetterOrDigit(letter))
                    return false;
        }
        return true;
    }

    private boolean validateTLD(String tld) {
        int length = tld.length();
        if(length < 2 || length >= 7)
            return false;
        if(!Character.isLetter(tld.charAt(0)))
            return false;
        if(tld.charAt(0) == '-' || tld.charAt(length-1) == '-')
            return false;
        char[] tldLetters = tld.toCharArray();
        for (char letter: tldLetters
             ) {
            if(letter != '-')
                if(!Character.isLetterOrDigit(letter))
                    return false;
        }
        return true;
    }
}

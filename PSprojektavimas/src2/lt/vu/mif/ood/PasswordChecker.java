package lt.vu.mif.ood;

public class PasswordChecker {
    public Boolean lengthRequirement(String password, int length) {
        if(password.length() >= length) {
            return true;
        }
        else return false;
    }

    public Boolean uppercaseRequirement(String password) {
        char ch;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    public Boolean specialSymbolsRequirement(String password) {
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        char ch;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if(specialCharactersString.contains(Character.toString(ch))) {
                return true;
            }
        }
        return false;
    }
}

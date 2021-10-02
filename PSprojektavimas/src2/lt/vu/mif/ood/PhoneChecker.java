package lt.vu.mif.ood;

import java.util.Objects;

public class PhoneChecker {
    public Boolean validNumberRequirement(String phoneNumber) {
        int i;
        if(phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        if(!checkLength(phoneNumber)){
            return false;
        }
        if (phoneNumber.charAt(0) == '+') {
            i = 1;
        } else {
            i = 0;
        }
        for (; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }

        }
        return true;
    }

    public Object checkNumberStartingSymbol(String phoneNumber) {
        if(phoneNumber.startsWith("+3706") || phoneNumber.startsWith("86")){
            return "Phone number has a proper starting number sequence.";
        }
        return "Phone number doesn't have a proper starting number sequence.";
    }

    public Object checkCountryByIndex(String prefix, String phoneNumber) {
        if(Objects.equals(prefix, "LT") && phoneNumber.startsWith("+3706")){
            return "Country's prefix matches phone number.";
        }
        if(Objects.equals(prefix, "LV") && phoneNumber.startsWith("+3716")){
            return "Country's prefix matches phone number.";
        }
        if(Objects.equals(prefix, "EE") && phoneNumber.startsWith("+3726")){
            return "Country's prefix matches phone number.";
        }
        return "Country's prefix doesn't matches phone number.";
    }

    public Object checkCountryByIndexLength(String prefix, String phoneNumber) {
        if(Objects.equals(prefix, "LT") && (phoneNumber.startsWith("+3706") || phoneNumber.startsWith("86")) ){
            if(checkLength(phoneNumber)) return "Country's prefix matches phone number length.";
            else return "Country's prefix doesn't matches phone number length.";
        }
        if(Objects.equals(prefix, "LV") && (phoneNumber.startsWith("+3716") || phoneNumber.startsWith("86")) ){
            if(checkLength(phoneNumber)) return "Country's prefix matches phone number length.";
            else return "Country's prefix doesn't matches phone number length.";
        }
        if(Objects.equals(prefix, "EE") && (phoneNumber.startsWith("+3726") || phoneNumber.startsWith("86")) ){
            if(checkLength(phoneNumber)) return "Country's prefix matches phone number length.";
            else return "Country's prefix doesn't matches phone number length.";
        }
        return true;
    }

    public Boolean checkLength(String phoneNumber) {
        if(phoneNumber.charAt(0) == '+') {
            return phoneNumber.length() == 12;
        }
        if(phoneNumber.startsWith("86")){
            return phoneNumber.length() == 9;
        }
        return true;
    }
}


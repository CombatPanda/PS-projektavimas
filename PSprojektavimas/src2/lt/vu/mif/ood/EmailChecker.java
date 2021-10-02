package lt.vu.mif.ood;

public class EmailChecker {
    // Test if email has '@' symbol
    public Boolean validEmailRequirement(String email) {
        int count = 0;
        if(email == null || email.isEmpty()) {
            return false;
        }
        if (etaCount(email) == true){
            return true;
        } else return false;
    }
    //test if email has valid symbols in it
    public Boolean validEmailSymbolsRequirement(String email) {
        int count = 0;
        String name = email.substring(0, email.indexOf('@'));
        String invalidSymbols = "(),:;<>@[\\]";
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j < invalidSymbols.length(); j++) {
                if (email.charAt(i) == invalidSymbols.charAt(j)) {
                    return false;
                }
            }
        }
        if(name.startsWith(".") || name.endsWith(".")){
            return false;
        }
        if(name.contains("..")){
            return false;
        }

        return etaCount(email);

    }
    // Test if email has the right domain and TLD
    public Boolean validDomainRequirement(String email) {
        String domain = email.substring(email.indexOf('@')+1, email.length());
        String tld = domain.substring(domain.lastIndexOf('.')+1);
        if(domain.startsWith("-") || domain.endsWith("-") || domain.startsWith(".")){
            return false;
        }
        if(domain.contains("..")){
            return false;
        }
        return true;
    }

    public Boolean etaCount(String email) {
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                count++;
            }
        }
        if (count >= 2 ) {
            return false;
        }
        if (count == 0){
        return false;}

        return true;
    }
}

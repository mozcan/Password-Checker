import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        if(!passwordChecker(args[0])) {
            System.out.println("Password Incorrect");
        } else {
            System.out.println("Password Correct");
        }
    }

    public static boolean passwordChecker(String password) {
        final String LOWER = "l";
        final String UPPER = "u";
        final String DIGIT = "d";
        final String PUNCTUATION = "p";
        final String PASSWORD = "password";

        if(password.toLowerCase().contains(PASSWORD))
            return false;

        Set<String> conditions = new HashSet<>();
        for (int i = 0; i < password.length(); i++) {
            if(Character.isLowerCase(password.charAt(i)))
                conditions.add(LOWER);
            else if(Character.isUpperCase(password.charAt(i)))
                conditions.add(UPPER);
            else if(Character.isDigit(password.charAt(i)))
                conditions.add(DIGIT);
            else
                conditions.add(PUNCTUATION);

        }

        if(conditions.size() >= 3 &&
                (password.length() >=7 && password.length() <= 31) &&
                (conditions.contains(UPPER) && conditions.contains(LOWER)) &&
                (conditions.contains(DIGIT) || conditions.contains(PUNCTUATION)))
            return true;
        return false;
    }


}
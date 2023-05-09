package src.com.daily.dsa.challenge;

public class StrongPassword {

    public static void main(String[] args) {
        System.out.println(minimumNumber(5, "A98#+"));
    }

    /**
     * <a href="https://www.hackerrank.com/challenges/strong-password/problem">Strong Password</a>
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int changes = 0;

        boolean numbers = false;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean specialChars = false;

        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') numbers = true;
            else if (c >= 'a' && c <= 'z') lowerCase = true;
            else if (c >= 'A' && c <= 'Z') upperCase = true;
            else specialChars = true;
        }

        if (!specialChars) changes++;
        if (!numbers) changes++;
        if (!lowerCase) changes++;
        if (!upperCase) changes++;

        if(changes + n < 6){
            changes += 6 - (changes + n);
        }

        return changes;
    }
}

package basictasks; /**
 * Created by Khrystyna.Shyian on 03.03.2015.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneratePassword {

    static Random rnd = new Random();
    static String sCurrentLine;
    static String res;
    static boolean upperFound = false;

    static String randomString(int len, String string) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(string.charAt(rnd.nextInt(string.length())));
        return sb.toString();
    }

    public static void main(String[] args) {
        String characters = readFile();
        System.out.println("Data from file: " + characters);

        int len = rnd.nextInt(30);
        String test = randomString(len, characters);
        System.out.println("Generated password: " + test);
        System.out.println("Generated password length: " + test.length());
        checkPassword(test);
    }

    public static void checkPassword(String pass) {

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(pass);
        boolean b = m.find();
        System.out.println("Password contains special characters: " + b);

        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperFound = true;
                break;
            }
        }
        System.out.println("Password contains uppercase letters: " + upperFound);

        if (pass.length() > 8 & b & upperFound) {
            System.out.println("Password is Strong");
        } else if ((pass.length() > 8 & b & !upperFound) || (pass.length() > 8 & !b & upperFound) || (pass.length() <= 8 & b & upperFound)) {
            System.out.println("Password is Medium");
        } else {
            System.out.println("Password is Weak");
        }
    }

    public static String readFile() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("D:\\data.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                res = sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }
}

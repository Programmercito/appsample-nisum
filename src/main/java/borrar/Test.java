/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package borrar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hered
 */
public class Test {

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String password = "juan@rodriguez.org";
        
        System.out.println(isValidPassword(password)); // true

        password = "juanrodriguez.org";
        System.out.println(isValidPassword(password)); // false
    }
}

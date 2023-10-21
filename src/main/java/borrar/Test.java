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
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String password = "123456Aa@de321";
        System.out.println(isValidPassword(password)); // true

        password = "contraseña";
        System.out.println(isValidPassword(password)); // false
    }
}

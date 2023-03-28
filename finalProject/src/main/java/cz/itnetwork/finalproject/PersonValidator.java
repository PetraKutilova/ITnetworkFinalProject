/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.finalproject;

/**
 *
 * @author petra
 */
public class PersonValidator {

    public static boolean validateName(String name) {
        return name != null && !name.isBlank();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber != null
                && phoneNumber.startsWith("+")
                && phoneNumber.length() >= 2 && phoneNumber.length() <= 13
                && validateNumbersOnly(phoneNumber);
    }

    private static boolean validateNumbersOnly(String phoneNumber) {
        try {
            Long.parseLong(phoneNumber);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean validateAge(String age) {
        try {
            int parsedAge = Integer.parseInt(age);
            return parsedAge >= 0 && parsedAge <= 150;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}

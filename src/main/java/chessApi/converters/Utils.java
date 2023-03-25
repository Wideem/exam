package chessApi.converters;

import java.time.LocalDate;
import java.time.Period;

public class Utils {
    static String calculateExperience(LocalDate startDate) {
        LocalDate now = LocalDate.now();
        int years = now.getYear() - startDate.getYear();
        int months = now.getMonthValue() - startDate.getMonthValue();
        int days = now.getDayOfMonth() - startDate.getDayOfMonth();
        if (months < 0 || (months == 0 && days < 0)) {
            years--;
        }
        return years + " years";
    }

     static int calculateAge(long personCode) {
        // Parse the birthdate from the person code
        String personCodeString = Long.toString(personCode).substring(1, 7);
        int birthYear = Integer.parseInt(personCodeString.substring(0, 2));
        int birthMonth = Integer.parseInt(personCodeString.substring(2, 4));
        int birthDay = Integer.parseInt(personCodeString.substring(4, 6));
        int currentYear = LocalDate.now().getYear() % 100;

        // Determine the century of the birth year based on the gender digit in the PIN
        int genderDigit = Integer.parseInt(Long.toString(personCode).substring(0, 1));
        int birthCentury;
        if (genderDigit == 1 || genderDigit == 2) {
            birthCentury = 1800;
        } else if (genderDigit == 3 || genderDigit == 4) {
            birthCentury = 1900;
        } else if (genderDigit == 5 || genderDigit == 6) {
            birthCentury = 2000;
        } else {
            birthCentury = 2100;
        }

        // Construct the full birth year by combining the century and the two-digit year in the PIN
        birthYear = birthCentury + birthYear;

        LocalDate birthdate = LocalDate.of(birthYear, birthMonth, birthDay);
        Period age = Period.between(birthdate, LocalDate.now());

        return age.getYears();
    }


    static String calculateGender(Long personCode) {
        String gender;
        if (personCode % 2 == 0) {
            gender = "female";
        } else {
            gender = "male";
        }
        return gender;
    }
}

package com.gener.ek.utils;

import java.util.Random;

public class Utils {

    public static Boolean isValidateCpf(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "").trim();
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        String baseCpf = cpf.substring(0, 9);
        String firstDigit = firstDigit(baseCpf);
        String secondDigit = secondDigit(baseCpf + firstDigit);
        return firstDigit.equals(String.valueOf(cpf.charAt(9))) &&
                secondDigit.equals(String.valueOf(cpf.charAt(10)));
    }

    public static String makeCpf(boolean format) {
        String numberRange = "0123456789";
        Random random = new Random();
        StringBuilder cpf = new StringBuilder();
        while (cpf.length() < 9) {
            int randomIndex = random.nextInt(numberRange.length());
            cpf.append(numberRange.charAt(randomIndex));
        }
        cpf.append(firstDigit(String.valueOf(cpf)));
        cpf.append(secondDigit(String.valueOf(cpf)));
        if (format) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
        } else {
            return cpf.toString();
        }
    }

    public static String firstDigit(String cpf) {
        String formated = cpf.replace(".", "").trim();
        int count = (Integer.parseInt(String.valueOf(formated.charAt(0))) * 10) + (Integer.parseInt(String.valueOf(formated.charAt(1))) * 9) + (Integer.parseInt(String.valueOf(formated.charAt(2))) * 8) + (Integer.parseInt(String.valueOf(formated.charAt(3))) * 7) + (Integer.parseInt(String.valueOf(formated.charAt(4))) * 6) + (Integer.parseInt(String.valueOf(formated.charAt(5))) * 5) + (Integer.parseInt(String.valueOf(formated.charAt(6))) * 4) + (Integer.parseInt(String.valueOf(formated.charAt(7))) * 3) + (Integer.parseInt(String.valueOf(formated.charAt(8))) * 2);
        int division = count % 11;
        int fistDigit = division == 1 || division == 0 ? 0 : 11 - division;
        return Integer.toString(fistDigit);
    }

    public static String secondDigit(String cpf) {
        String formated = cpf.replace(".", "").trim();
        int count = (Integer.parseInt(String.valueOf(formated.charAt(0))) * 11) + (Integer.parseInt(String.valueOf(formated.charAt(1))) * 10) + (Integer.parseInt(String.valueOf(formated.charAt(2))) * 9) + (Integer.parseInt(String.valueOf(formated.charAt(3))) * 8) + (Integer.parseInt(String.valueOf(formated.charAt(4))) * 7) + (Integer.parseInt(String.valueOf(formated.charAt(5))) * 6) + (Integer.parseInt(String.valueOf(formated.charAt(6))) * 5) + (Integer.parseInt(String.valueOf(formated.charAt(7))) * 4) + (Integer.parseInt(String.valueOf(formated.charAt(8))) * 3) + (Integer.parseInt(String.valueOf(formated.charAt(9))) * 2);
        int division = count % 11;
        int secondDigit = division == 1 || division == 0 ? 0 : 11 - division;
        return Integer.toString(secondDigit);
    }
}

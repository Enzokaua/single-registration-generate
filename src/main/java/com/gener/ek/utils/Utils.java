package com.gener.ek.utils;

import java.util.Random;

public class Utils {

    private static final int[] weigthFirsDigit = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] weigthSecondDigit = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static Boolean isValidateCpf(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "").trim();
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        String baseCpf = cpf.substring(0, 9);
        String firstDigit = firstDigitCpf(baseCpf);
        String secondDigit = secondDigitCpf(baseCpf + firstDigit);
        return firstDigit.equals(String.valueOf(cpf.charAt(9))) &&
                secondDigit.equals(String.valueOf(cpf.charAt(10)));
    }

    public static boolean isValidateCnpj(String cnpj) {
        cnpj = cnpj.replaceAll("\\D", "");
        if (cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }
        try {
            return cnpj.charAt(12) == Character.forDigit(firstDigitCnpj(cnpj), 10) && cnpj.charAt(13) == Character.forDigit(secondDigitCnpj(cnpj), 10);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidAlphanumericCnpj(String alphaCnpj) {
        if (alphaCnpj == null || alphaCnpj.length() != 14 || allCharsAreEqual(alphaCnpj)) return false;
        try {
            alphaCnpj = alphaCnpj.toUpperCase().replaceAll("[^A-Z0-9]", "");
            return hashCharacters(alphaCnpj.charAt(12)) == fistDigitAlphaCnpj(alphaCnpj) && hashCharacters(alphaCnpj.charAt(13)) == secondDigitAphaCnpj(alphaCnpj);
        } catch (Exception e) {
            return false;
        }
    }

    public static String makeCpf(boolean format) {
        String numberRange = "0123456789";
        Random random = new Random();
        StringBuilder cpf = new StringBuilder();
        while (cpf.length() < 9) {
            int randomIndex = random.nextInt(numberRange.length());
            cpf.append(numberRange.charAt(randomIndex));
        }
        cpf.append(firstDigitCpf(String.valueOf(cpf)));
        cpf.append(secondDigitCpf(String.valueOf(cpf)));
        if (format) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
        } else {
            return cpf.toString();
        }
    }

    public static String makeCnpj(boolean format) {
        String numberRange = "0123456789";
        Random random = new Random();
        StringBuilder cnpj = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            cnpj.append(numberRange.charAt(random.nextInt(numberRange.length())));
        }
        cnpj.append("0001");
        cnpj.append(firstDigitCnpj(cnpj.toString()));
        cnpj.append(secondDigitCnpj(cnpj.toString()));

        if (format) {
            return cnpj.substring(0, 2) + "." +
                    cnpj.substring(2, 5) + "." +
                    cnpj.substring(5, 8) + "/" +
                    cnpj.substring(8, 12) + "-" +
                    cnpj.substring(12);
        }

        return cnpj.toString();
    }

    public static String makeAlphanumericCnpj(boolean format) {
        String range = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder cnpj = new StringBuilder();

        while (cnpj.length() < 12) {
            cnpj.append(range.charAt(random.nextInt(range.length())));
        }
        cnpj.append(fistDigitAlphaCnpj(cnpj.toString()));
        cnpj.append(secondDigitAphaCnpj(cnpj.toString()));

        if (format) {
            return cnpj.substring(0, 2) + "." +
                    cnpj.substring(2, 5) + "." +
                    cnpj.substring(5, 8) + "/" +
                    cnpj.substring(8, 12) + "-" +
                    cnpj.substring(12);
        }

        return cnpj.toString();
    }

    private static boolean allCharsAreEqual(String s) {
        return s.chars().allMatch(ch -> ch == s.charAt(0));
    }

    private static int fistDigitAlphaCnpj(String cnpj) {
        int sum = 0;

        for (int i = 0; i < 12; i++) {

            sum += hashCharacters(cnpj.charAt(i)) * weigthFirsDigit[i];
        }

        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    private static int secondDigitAphaCnpj(String cnpj) {
        int sum = 0;

        for (int i = 0; i < 13; i++) {
            sum += hashCharacters(cnpj.charAt(i)) * weigthSecondDigit[i];
        }

        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    private static int hashCharacters(char ch) {
        if (Character.isDigit(ch)) {
            return Character.getNumericValue(ch);
        } else if (Character.isLetter(ch)) {
            return ch - 48;
        } else {
            throw new IllegalArgumentException("Invalid character: " + ch);
        }
    }

    public static Integer firstDigitCnpj(String cnpj) {
        int resulted = 0;
        for (int i = 0; i < 12; i++) {
            resulted += Character.getNumericValue(cnpj.charAt(i)) * weigthFirsDigit[i];
        }
        return resulted % 11 < 2 ? 0 : 11 - (resulted % 11);
    }

    public static Integer secondDigitCnpj(String cnpj) {
        int resulted = 0;
        for (int i = 0; i < 13; i++) {
            resulted += Character.getNumericValue(cnpj.charAt(i)) * weigthSecondDigit[i];
        }
        return resulted % 11 < 2 ? 0 : 11 - (resulted % 11);
    }

    public static String firstDigitCpf(String cpf) {
        String formated = cpf.replace(".", "").trim();
        int count = (Integer.parseInt(String.valueOf(formated.charAt(0))) * 10) + (Integer.parseInt(String.valueOf(formated.charAt(1))) * 9) + (Integer.parseInt(String.valueOf(formated.charAt(2))) * 8) + (Integer.parseInt(String.valueOf(formated.charAt(3))) * 7) + (Integer.parseInt(String.valueOf(formated.charAt(4))) * 6) + (Integer.parseInt(String.valueOf(formated.charAt(5))) * 5) + (Integer.parseInt(String.valueOf(formated.charAt(6))) * 4) + (Integer.parseInt(String.valueOf(formated.charAt(7))) * 3) + (Integer.parseInt(String.valueOf(formated.charAt(8))) * 2);
        int division = count % 11;
        int fistDigit = division == 1 || division == 0 ? 0 : 11 - division;
        return Integer.toString(fistDigit);
    }

    public static String secondDigitCpf(String cpf) {
        String formated = cpf.replace(".", "").trim();
        int count = (Integer.parseInt(String.valueOf(formated.charAt(0))) * 11) + (Integer.parseInt(String.valueOf(formated.charAt(1))) * 10) + (Integer.parseInt(String.valueOf(formated.charAt(2))) * 9) + (Integer.parseInt(String.valueOf(formated.charAt(3))) * 8) + (Integer.parseInt(String.valueOf(formated.charAt(4))) * 7) + (Integer.parseInt(String.valueOf(formated.charAt(5))) * 6) + (Integer.parseInt(String.valueOf(formated.charAt(6))) * 5) + (Integer.parseInt(String.valueOf(formated.charAt(7))) * 4) + (Integer.parseInt(String.valueOf(formated.charAt(8))) * 3) + (Integer.parseInt(String.valueOf(formated.charAt(9))) * 2);
        int division = count % 11;
        int secondDigit = division == 1 || division == 0 ? 0 : 11 - division;
        return Integer.toString(secondDigit);
    }
}

package org.example.config;

import java.util.Random;

public class ISBNGenerator {

    public static String generateISBN() {
        // The first 3 digits are typically the group or country identifier.
        // For simplicity, let's use a random number for the example.
        String groupIdentifier = "978";

        // The next 9 digits are for the book and publisher identifiers.
        // For simplicity, let's use random numbers for the example.
        Random random = new Random();
        String publisherIdentifier = String.format("%09d", random.nextInt(1000000000));

        // The last digit is a check digit calculated to ensure the ISBN is valid.
        String isbnWithoutCheckDigit = groupIdentifier + publisherIdentifier;
        char checkDigit = calculateCheckDigit(isbnWithoutCheckDigit);

        return isbnWithoutCheckDigit + checkDigit;
    }

    public static char calculateCheckDigit(String isbnWithoutCheckDigit) {
        int sum = 0;
        for (int i = 0; i < isbnWithoutCheckDigit.length(); i++) {
            int digit = Character.getNumericValue(isbnWithoutCheckDigit.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }

        int remainder = sum % 10;
        return (remainder == 0) ? '0' : (char) ((10 - remainder) + '0');
    }
}

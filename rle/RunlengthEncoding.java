package hus.oop.rle;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RunlengthEncoding {
    public static void main(String[] args) {
        /*
        TODO:

        - Viết các hàm test mã hóa và giải mã theo mã hóa run-length và in ra theo mẫu:
        Ví dụ:
        Decoded Text: xxxxx
        Encoded Text: xxxxx

        và

        Encoded Text: xxxxx
        Decoded Text: xxxxx


         */
        testEncoding();
        System.out.println(); // Add a newline for separation
        testDecoding();
    }

    /*
     * Hàm mã hóa chuỗi ký tự text theo mã hóa run-length.
     */
    public static String encoding(String text) {
        /* TODO */
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder encodedText = new StringBuilder();
        int count = 0;
        char currentChar = text.charAt(0);

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == currentChar) {
                count++;
            } else {
                encodedText.append(count).append(currentChar);
                currentChar = text.charAt(i);
                count = 1;
            }
        }
        encodedText.append(count).append(currentChar); // Append the last character and its count

        return encodedText.toString();
    }

    /*
     * Hàm giải mã chuỗi ký tự text theo mã hóa run-length.
     */
    public static String decoding(String text) {
        /* TODO */
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder decodedText = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            int count = Character.getNumericValue(text.charAt(i));
            char character = text.charAt(i + 1);
            for (int j = 0; j < count; j++) {
                decodedText.append(character);
            }
        }

        return decodedText.toString();
    }

    /*
     * Hàm test mã hóa theo mã hóa run-length.
     */
    public static void testEncoding() {
        /* TODO */
        String decodedText1 = "aaaaabcccaa";
        String encodedText1 = encoding(decodedText1);
        System.out.println("Decoded Text: " + decodedText1);
        System.out.println("Encoded Text: " + encodedText1);

        String decodedText2 = "eeeffffee";
        String encodedText2 = encoding(decodedText2);
        System.out.println("Decoded Text: " + decodedText2);
        System.out.println("Encoded Text: " + encodedText2);

        String decodedText3 = "aabbbccccc";
        String encodedText3 = encoding(decodedText3);
        System.out.println("Decoded Text: " + decodedText3);
        System.out.println("Encoded Text: " + encodedText3);
    }

    /*
     * Hàm test giải mã theo mã hóa run-length.
     */
    public static void testDecoding() {
        /* TODO */
        String encodedText1 = "4a1b3c2a";
        String decodedText1 = decoding(encodedText1);
        System.out.println("Encoded Text: " + encodedText1);
        System.out.println("Decoded Text: " + decodedText1);

        String encodedText2 = "3e4f2e";
        String decodedText2 = decoding(encodedText2);
        System.out.println("Encoded Text: " + encodedText2);
        System.out.println("Decoded Text: " + decodedText2);

        String encodedText3 = "2a3b5c";
        String decodedText3 = decoding(encodedText3);
        System.out.println("Encoded Text: " + encodedText3);
        System.out.println("Decoded Text: " + decodedText3);
    }
}

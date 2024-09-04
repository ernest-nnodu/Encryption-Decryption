
import encryptdecrypt.EncryptionAlgorithm;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class EncryptionAlgorithmTest {

    private final EncryptionAlgorithm encryption = new EncryptionAlgorithm();

    @Test
    @DisplayName("Encrypt lowercase text")
    public void testAtBashEncryptWithLowercaseText() {
        String input = "abc";
        String expected = "zyx";
        String actual = encryption.atBashEncrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt uppercase text")
    public void testAtBashEncryptWithUppercaseText() {
        String input = "abc";
        String expected = "zyx";
        String actual = encryption.atBashEncrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt lowercase and uppercase text combined")
    public void testAtBashEncryptWithMixedCaseText() {
        String input = "AbC";
        String expected = "zyx";
        String actual = encryption.atBashEncrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt text with spaces and special character")
    public void testAtBashEncryptWithSpacesAndPunctuation() {
        String input = "a b c!";
        String expected = "z y x!";
        String actual = encryption.atBashEncrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt full sentence")
    public void testAtBashEncryptWithFullSentence() {
        String input = "we found a treasure!";
        String expected = "dv ulfmw z givzhfiv!";
        String actual = encryption.atBashEncrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt empty string")
    public void testAtBashEncryptWithEmptyString() {
        String input = "";
        String expected = "";
        String actual = encryption.atBashEncrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt non alphabetic characters")
    public void testAtBashEncryptWithNonAlphabeticCharacters() {
        String input = "1234!@#";
        String expected = "1234!@#";
        String actual = encryption.atBashEncrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt all letters from the alphabet")
    public void testAtBashEncryptWithAllLetters() {
        String input = "abcdefghijklmnopqrstuvwxyz";
        String expected = "zyxwvutsrqponmlkjihgfedcba";
        String actual = encryption.atBashEncrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCaesarShiftEncrypt() {
        String input = "welcome to hyperskill";
        int key = 5;
        String expected = "bjqhtrj yt mdujwxpnqq";
        String actual = encryption.caesarShiftEncrypt(input, key);
        assertEquals(expected, actual);
    }

    @Test
    public void testCaesarShiftEncryptWithWrapAround() {
        String input = "xyz";
        int key = 3;
        String expected = "abc";
        String actual = encryption.caesarShiftEncrypt(input, key);
        assertEquals(expected, actual, "The Caesar Cipher encryption did not correctly wrap around the alphabet.");
    }

    @Test
    public void testCaesarShiftEncryptWithNonLetters() {
        String input = "hello world!";
        int key = 1;
        String expected = "ifmmp xpsme!";
        String actual = encryption.caesarShiftEncrypt(input, key);
        assertEquals(expected, actual);
    }
}

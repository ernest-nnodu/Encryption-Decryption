import encryptdecrypt.AtBashEncryption;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class AtBashEncryptTest {

    private final AtBashEncryption atBashEncryption = new AtBashEncryption();

    @Test
    @DisplayName("Encrypt lowercase text")
    public void testAtBashEncryptWithLowercaseText() {
        String input = "abc";
        String expected = "zyx";
        String actual = atBashEncryption.encrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt uppercase text")
    public void testAtBashEncryptWithUppercaseText() {
        String input = "abc";
        String expected = "zyx";
        String actual = atBashEncryption.encrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt lowercase and uppercase text combined")
    public void testAtBashEncryptWithMixedCaseText() {
        String input = "AbC";
        String expected = "zyx";
        String actual = atBashEncryption.encrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt text with spaces and special character")
    public void testAtBashEncryptWithSpacesAndPunctuation() {
        String input = "a b c!";
        String expected = "z y x!";
        String actual = atBashEncryption.encrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt full sentence")
    public void testAtBashEncryptWithFullSentence() {
        String input = "we found a treasure!";
        String expected = "dv ulfmw z givzhfiv!";
        String actual = atBashEncryption.encrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt empty string")
    public void testAtBashEncryptWithEmptyString() {
        String input = "";
        String expected = "";
        String actual = atBashEncryption.encrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt non alphabetic characters")
    public void testAtBashEncryptWithNonAlphabeticCharacters() {
        String input = "1234!@#";
        String expected = "1234!@#";
        String actual = atBashEncryption.encrypt(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt all letters from the alphabet")
    public void testAtBashEncryptWithAllLetters() {
        String input = "abcdefghijklmnopqrstuvwxyz";
        String expected = "zyxwvutsrqponmlkjihgfedcba";
        String actual = atBashEncryption.encrypt(input);
        assertEquals(expected, actual);
    }
}

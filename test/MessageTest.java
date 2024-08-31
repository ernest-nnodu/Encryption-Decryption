import encryptdecrypt.AtBashEncryption;
import encryptdecrypt.Message;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    @DisplayName("Default text retrieval")
    public void testDefaultTextRetrieval() {
        Message message = new Message("Hello");
        String expected = "Hello";
        String actual = message.getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Empty text retrieval")
    public void testEmptyTextRetrieval() {
        Message message = new Message("");
        String expected = "";
        String actual = message.getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Set new text")
    public void testSetNewText() {
        Message message = new Message("Hello");
        message.setText("New Text");
        String expected = "New Text";
        String actual = message.getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Set empty text")
    public void testSetEmptyText() {
        Message message = new Message("Hello");
        message.setText("");
        String expected = "";
        String actual = message.getText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt simple message")
    public void testEncryptSimpleText() {
        Message message = new Message("abc");
        String expected = "zyx";
        String actual = message.encryptMessage(new AtBashEncryption());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt mixed case message")
    public void testEncryptMixedCaseText() {
        Message message = new Message("ABc");
        String expected = "zyx";
        String actual = message.encryptMessage(new AtBashEncryption());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt message with spaces and punctuation")
    public void testEncryptTextWithSpacesAndPunctuation() {
        Message message = new Message("a b c!");
        String expected = "z y x!";
        String actual = message.encryptMessage(new AtBashEncryption());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt empty message")
    public void testEncryptEmptyText() {
        Message message = new Message("");
        String expected = "";
        String actual = message.encryptMessage(new AtBashEncryption());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt non alphabetic message")
    public void testEncryptNonAlphabeticText() {
        Message message = new Message("123@#");
        String expected = "123@#";
        String actual = message.encryptMessage(new AtBashEncryption());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Encrypt long message")
    public void testEncryptLongText() {
        Message message = new Message("we found a treasure!");
        String expected = "dv ulfmw z givzhfiv!";
        String actual = message.encryptMessage(new AtBashEncryption());
        assertEquals(expected, actual);
    }
}









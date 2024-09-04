package encryptdecrypt;

public class Message {

    String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String encryptMessage(EncryptionAlgorithm encryption) {
        return encryption.atBashEncrypt(text);
    }

    public String encryptMessage(EncryptionAlgorithm encryption, int key) {
        return encryption.caesarShiftEncrypt(text, key);
    }
}

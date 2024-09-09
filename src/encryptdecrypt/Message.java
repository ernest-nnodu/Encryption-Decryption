package encryptdecrypt;

public class Message {

    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String encryptMessageWithAtBash(EncryptionAlgorithm algorithm) {
        return algorithm.atBashEncrypt(text);
    }

    public String encryptMessageWithCaesar(EncryptionAlgorithm algorithm, int key) {
        return algorithm.caesarShiftEncrypt(text, key);
    }

    public String decryptMessageWithCaesar(EncryptionAlgorithm algorithm, int key) {
        return algorithm.caesarShiftDecrypt(text, key);
    }

    public String encryptMessageWithUnicode(EncryptionAlgorithm algorithm, int key) {
        return algorithm.unicodeEncrypt(text, key);
    }

    public String decryptMessageWithUnicode(EncryptionAlgorithm algorithm, int key) {
        return algorithm.unicodeDecrypt(text, key);
    }
}







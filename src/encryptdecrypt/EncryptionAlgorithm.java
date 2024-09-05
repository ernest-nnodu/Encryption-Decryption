package encryptdecrypt;

public class EncryptionAlgorithm {

    public String atBashEncrypt(String data) {
        if (data.isEmpty()) {
            return "";
        }

        char firstChar = 'a';
        char lastChar = 'z';
        StringBuilder encryptedData = new StringBuilder();

        for (char ch : data.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                encryptedData.append((char) (firstChar + (lastChar - ch)));
            } else {
                encryptedData.append(ch);
            }
        }
        return encryptedData.toString();
    }

    public String caesarShiftEncrypt(String data, int key) {

        if (data.isEmpty()) {
            return "";
        }

        char firstAlphabet = 'a';
        int alphabetLength = 26;
        StringBuilder encryptedData = new StringBuilder();

        for (char ch : data.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                char shifted = (char) (firstAlphabet +
                        (ch - firstAlphabet + key) % alphabetLength);
                encryptedData.append(shifted);
            } else {
                encryptedData.append(ch);
            }
        }
        return encryptedData.toString();
    }

    public String unicodeEncrypt(String data, int key) {

        if (data.isEmpty()) {
            return "";
        }

        StringBuilder encryptedData = new StringBuilder();

        for (char ch : data.toCharArray()) {
            encryptedData.append((char) (ch + key)); //Shift by the key using unicode values
        }
        return encryptedData.toString();
    }

    public String unicodeDecrypt(String data, int key) {
        if (data.isEmpty()) {
            return "";
        }

        StringBuilder decryptedData = new StringBuilder();

        for (char ch : data.toCharArray()) {
            decryptedData.append((char) (ch - key));
        }
        return decryptedData.toString();
    }
}

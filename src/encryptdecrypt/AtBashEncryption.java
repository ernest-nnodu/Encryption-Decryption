package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

public class AtBashEncryption {

    Map<String, String> encryptionKeys;

    public AtBashEncryption() {
        generateKeys();
    }

    private void generateKeys() {
        encryptionKeys = new HashMap<>();

        encryptionKeys.put("a", "z");
        encryptionKeys.put("b", "y");
        encryptionKeys.put("c", "x");
        encryptionKeys.put("d", "w");
        encryptionKeys.put("e", "v");
        encryptionKeys.put("f", "u");
        encryptionKeys.put("g", "t");
        encryptionKeys.put("h", "s");
        encryptionKeys.put("i", "r");
        encryptionKeys.put("j", "q");
        encryptionKeys.put("k", "p");
        encryptionKeys.put("l", "o");
        encryptionKeys.put("m", "n");
        encryptionKeys.put("n", "m");
        encryptionKeys.put("o", "l");
        encryptionKeys.put("p", "k");
        encryptionKeys.put("q", "j");
        encryptionKeys.put("r", "i");
        encryptionKeys.put("s", "h");
        encryptionKeys.put("t", "g");
        encryptionKeys.put("u", "f");
        encryptionKeys.put("v", "e");
        encryptionKeys.put("w", "d");
        encryptionKeys.put("x", "c");
        encryptionKeys.put("y", "b");
        encryptionKeys.put("z", "a");

    }

    public String encrypt(String data) {
        if (data.isEmpty()) {
            return "";
        }

        data = data.toLowerCase();
        StringBuilder encryptedData = new StringBuilder();

        for (int index = 0; index < data.length(); index++) {
            String key = String.valueOf(data.charAt(index));

            if (!encryptionKeys.containsKey(key)) {
                encryptedData.append(key);
                continue;
            }
            encryptedData.append(encryptionKeys.get(key));
        }
        return encryptedData.toString();
    }
}

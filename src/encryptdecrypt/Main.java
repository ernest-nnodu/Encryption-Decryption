package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        int key = 0;
        String data = "";

        for (int index = 0; index < args.length; index += 2) {
            if (args[index].equals("-mode")) {
                mode = args[index + 1];
            } else if (args[index].equals("-key")) {
                key = Integer.parseInt(args[index + 1]);
            } else {
                data = args[index + 1];
            }
        }

        Message message = new Message(data);

        if (mode.equals("enc")) {
            System.out.println(message.encryptMessageWithUnicode(new EncryptionAlgorithm(), key));
        } else {
            System.out.println(message.decryptMessageWithUnicode(new EncryptionAlgorithm(), key));
        }
    }
}

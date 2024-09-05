package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        Message message = new Message(scanner.nextLine());
        int key = scanner.nextInt();

        if (operation.equals("enc")) {
            System.out.println(message.encryptMessageWithUnicode(new EncryptionAlgorithm(), key));
        } else {
            System.out.println(message.decryptMessageWithUnicode(new EncryptionAlgorithm(), key));
        }
    }
}

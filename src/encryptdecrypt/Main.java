package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Message message = new Message(scanner.nextLine());
        int key = scanner.nextInt();
        System.out.println(message.encryptMessage(new EncryptionAlgorithm(), key));
    }
}

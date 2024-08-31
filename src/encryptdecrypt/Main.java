package encryptdecrypt;

public class Main {
    public static void main(String[] args) {

        Message message = new Message("we found a treasure!");
        System.out.println(message.encryptMessage(new AtBashEncryption()));
    }
}

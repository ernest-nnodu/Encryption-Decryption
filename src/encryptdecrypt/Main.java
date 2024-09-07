package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        int key = 0;
        String inputFileName = "";
        String outputFileName = "";
        StringBuilder data = new StringBuilder();
        boolean readFromFIle = false;
        boolean writeToFile = false;
        Message message = new Message(data.toString());
        String output;

        Properties properties = getproperties(args, mode, key, inputFileName, readFromFIle, outputFileName, writeToFile, data);

        message = getData(properties);

        output = processData(properties, message);

        printData(properties, output);
    }

    private static Message getData(Properties properties) {
        Message message;
        if (properties.readFromFIle()) {
            readDataFromFile(properties);
        }
        message = new Message(properties.data().toString());
        return message;
    }

    private static void printData(Properties properties, String output) {
        if (properties.writeToFile()) {
            File outputFile = new File(properties.outputFileName());
            try(PrintWriter printWriter = new PrintWriter(outputFile)) {
                printWriter.println(output);
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println(output);
        }
    }

    private static String processData(Properties properties, Message message) {
        String output;
        if (properties.mode().equals("enc")) {
            output = message.encryptMessageWithUnicode(new EncryptionAlgorithm(), properties.key());
        } else {
            output = message.decryptMessageWithUnicode(new EncryptionAlgorithm(), properties.key());
        }
        return output;
    }

    private static void readDataFromFile(Properties properties) {
        File inputFile = new File(properties.inputFileName());
        try(Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNext()) {
                properties.data().append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Properties getproperties(String[] args, String mode, int key, String inputFileName, boolean readFromFIle, 
                                    String outputFileName, boolean writeToFile, StringBuilder data) {
        for (int index = 0; index < args.length; index += 2) {
            switch (args[index]) {
                case "-mode" -> mode = args[index + 1];
                case "-key" -> key = Integer.parseInt(args[index + 1]);
                case "-in" -> {
                    inputFileName = args[index + 1];
                    readFromFIle = true;
                }
                case "-out" -> {
                    outputFileName = args[index + 1];
                    writeToFile = true;
                }
                case "-data" -> {
                    data = new StringBuilder(args[index + 1]);
                    readFromFIle = false;
                }
            }
        }
        return new Properties(mode, key, inputFileName, outputFileName, data, readFromFIle, writeToFile);
    }

    private record Properties(String mode, int key, String inputFileName, String outputFileName, StringBuilder data, 
                          boolean readFromFIle, boolean writeToFile) {
    }
}

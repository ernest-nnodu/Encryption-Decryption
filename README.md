# Encryption-Decryption Project

## Overview
This project is a simple encryption-decryption tool that supports various algorithms for encoding and decoding messages. It allows users to encrypt or decrypt a message using:
- **Caesar Cipher (Shift Cipher)**
- **Atbash Cipher**
- **Unicode-based Shift Cipher**

The program supports both encryption (`enc`) and decryption (`dec`) modes and can process input from files or directly via command-line arguments. It can handle both letter and non-letter characters.

## Features
- **Caesar Cipher**: Shifts each letter in the message by a specified key.
- **Atbash Cipher**: Replaces each letter with its opposite in the alphabet.
- **Unicode-based Shift Cipher**: Shifts the Unicode value of each character by the specified key.
- **Support for file input/output**: You can read the input from a file and save the output to a file.
- **Command-line arguments**: Various options can be passed through command-line arguments to specify the mode, key, algorithm, and input/output method.

## How It Works
1. **Encryption Algorithms**:
   - **Atbash Cipher**: Reverses the alphabet (i.e., `a → z`, `b → y`, etc.).
   - **Caesar Cipher**: Shifts each letter by a certain key (e.g., with key = 3, `a → d`, `b → e`, etc.).
   - **Unicode Shift Cipher**: Shifts the Unicode value of each character, including non-alphabetic characters.
   
2. **Decryption Algorithms**:
   - **Caesar Cipher Decryption**: Reverses the shift by subtracting the key from the character's position.
   - **Unicode Shift Cipher Decryption**: Reverses the Unicode shift by subtracting the key from the character's Unicode value.

## Command-line Usage
The program can be run from the command line using various arguments:

### Arguments:
- `-mode` : Specifies whether to encrypt (`enc`) or decrypt (`dec`) the message. Defaults to `enc`.
- `-key` : The shift key for the Caesar Cipher or Unicode-based cipher. Defaults to `0`.
- `-data` : The text to be encrypted/decrypted. If not provided, the program reads from a file.
- `-in` : The input file name (optional). If specified, data is read from the file instead of `-data`.
- `-out` : The output file name (optional). If specified, the result is written to the file instead of printed to the console.
- `-alg` : Specifies the algorithm (`shift` for Caesar Cipher or `unicode` for Unicode Shift Cipher). Defaults to `shift`.

### Example:
#### Encrypting with Caesar Cipher:
```bash
java -jar encryptdecrypt.jar -mode enc -key 5 -data "hello world"
```

#### Decrypting with Caesar Cipher:
```bash
java -jar encryptdecrypt.jar -mode dec -key 5 -data "mjqqt btwqi"
```

#### Encrypting with Unicode-based Shift Cipher:
```bash
java -jar encryptdecrypt.jar -mode enc -key 10 -data "hello123!" -alg unicode
```

#### Decrypting a file with Caesar Cipher:
```bash
java -jar encryptdecrypt.jar -mode dec -key 5 -in encrypted.txt -out decrypted.txt
```

## Example Input and Output
### Caesar Cipher Example:
**Encryption**:
```bash
Input: "hello world"
Key: 3
Output: "khoor zruog"
```

**Decryption**:
```bash
Input: "khoor zruog"
Key: 3
Output: "hello world"
```

### Unicode Cipher Example:
**Encryption**:
```bash
Input: "hello 123!"
Key: 1
Output: "ifmmp!234\""
```

## Project Structure

```plaintext
├── src
│   └── encryptdecrypt
│       ├── Main.java                  # Main entry point for the program
│       ├── Message.java               # Message class that handles the text and encryption methods
│       ├── EncryptionAlgorithm.java   # Contains the logic for Atbash, Caesar, and Unicode-based encryption and decryption
│       └── Properties.java            # Holds command-line properties
├── README.md                          # Project documentation
├── encrypted.txt                      # Sample encrypted message file (if generated)
├── decrypted.txt                      # Sample decrypted message file (if generated)
```

## Class Descriptions
### 1. `Main.java`
- The main class that handles user input, processes the data, and calls the appropriate encryption or decryption methods.

### 2. `Message.java`
- Represents a message and contains methods for encrypting and decrypting the message using various algorithms.

### 3. `EncryptionAlgorithm.java`
- Contains the logic for different encryption/decryption algorithms such as Caesar Cipher, Atbash Cipher, and Unicode Shift Cipher.

### 4. `Properties.java`
- Encapsulates the command-line arguments (e.g., mode, key, algorithm, input/output file names) and manages input/output handling.

## How to Run the Project
1. Compile the project using a Java compiler:
   ```bash
   javac -d bin src/encryptdecrypt/*.java
   ```

2. Run the program from the command line:
   ```bash
   java -cp bin encryptdecrypt.Main -mode enc -key 5 -data "message to encrypt"
   ```

3. Alternatively, package the project as a JAR and run it:
   ```bash
   jar -cvfm encryptdecrypt.jar Manifest.txt -C bin/ .
   java -jar encryptdecrypt.jar -mode enc -key 5 -data "message to encrypt"
   ```

## Future Improvements
- Add support for other classical ciphers (e.g., Vigenère cipher).
- Add support for a graphical user interface (GUI) for easier interaction.
- Add unit tests to ensure better code coverage.

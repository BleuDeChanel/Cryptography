package Ciphers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jin Min on 2018-04-25.
 */

public class ShiftCipher extends Cipher {

    public ShiftCipher() {
        super(CipherType.SHIFT);
    }

    /**
     * Returns an array of Integers which represents the encrypted message given the input string,
     * modular coefficient and how much to shift for the encryption for a shift cipher
     *
     * @param input an input message that will be encrypted
     * @param a      the modular coefficient for shift cipher; it's going to be one
     * @param b      the number representing how much to shift for the encryption
     * */
    @Override
    public ArrayList<Integer> encrypt(String input, int a, int b) {
        int length = input.length();
        ArrayList<Integer> integers = new ArrayList<Integer>(length);
        HashMap<String,Integer> conversionTable = table.getAlphabetTable();

        for (int index = 0; index < length; index++) {
            try {
                Integer codeNumber = (a*conversionTable.get(Character.toString(input.charAt(index))) + b) % Modular;
                if (codeNumber >= Modular) {
                    System.out.println("Modular is " + Modular);
                    integers.add(codeNumber-Modular);
                }
                else {
                    integers.add(codeNumber);
                }
            } catch (ArithmeticException  e) {
                System.err.println("ArithmeticException:  " + e.getMessage());
            }
        }
        return integers;
    }


    /**
     * Returns a string which represents the decrypted message given the input array,
     * modular coefficient and how much was shifted for the encryption for a shift cipher
     *
     * @param input an input message that will be encrypted
     * @param c      the modular coefficient for shift cipher; it's going to be one
     * @param d      the number representing how much was shifted for the encryption
     * */
    @Override
    public String decrypt(String input, int c, int d) {
        String decryptedMessage = "";
        int length = input.length();
        HashMap<String,Integer> conversionTable = table.getAlphabetTable();
        HashMap<Integer, String> reverseConversionTable = table.getAlphabetTableReverse();

        for (int index = 0; index < length; index++) {
            try {
                Integer codeNumber = (c*conversionTable.get(Character.toString(input.charAt(index))) - d) % Modular;
                if (codeNumber >= Modular) { // mod is returning -#...
                    System.out.println("Modular is " + Modular + "; use the least positive number in rrs");
                    decryptedMessage += reverseConversionTable.get(codeNumber-Modular);
                }
                else if (codeNumber < 0) {
                    System.out.println("Added " + Modular + " since it was negative modular");
                    decryptedMessage += reverseConversionTable.get(codeNumber+Modular);
                }
                else {
                    decryptedMessage += reverseConversionTable.get(codeNumber);
                }
            } catch (ArithmeticException  e) {
                System.err.println("ArithmeticException:  " + e.getMessage());
            }
        }
        return decryptedMessage;
    }


    /**
     * Returns a string which represents the encrypted message given the input string,
     * modular coefficient and how much to shift for the encryption for a shift cipher
     *
     * @param input an input message that will be encrypted
     * @param a      the modular coefficient for shift cipher; it's going to be one
     * @param b      the number representing how much was shifted for the encryption
     * */
    @Override
    public String getEncryptedMessage(String input, int a, int b) {
        String encryptedMessage = "";
        HashMap<Integer, String> reverseConversionTable = table.getAlphabetTableReverse();
        ArrayList<Integer> encryptedNumbers = encrypt(input, a, b);

        for (int i=0; i<encryptedNumbers.size();i++) {
            encryptedMessage += reverseConversionTable.get(encryptedNumbers.get(i));
        }
        return encryptedMessage;
    }

}

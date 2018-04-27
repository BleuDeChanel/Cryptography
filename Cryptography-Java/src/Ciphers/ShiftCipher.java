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

    @Override
    public ArrayList<Integer> encrypt(String input, int a, int b) {
        int length = input.length();
        int modular = 26;
        ArrayList<Integer> integers = new ArrayList<Integer>(length);
        HashMap<String,Integer> conversionTable = table.getAlphabetTable();

        for (int index = 0; index < length; index++) {
            try {
                Integer codeNumber = (a*conversionTable.get(Character.toString(input.charAt(index))) + b) % modular;
                if (codeNumber >= modular) {
                    System.out.println("Modular is " + modular);
                }
                integers.add(codeNumber);
            } catch (ArithmeticException  e) {
                System.err.println("ArithmeticException:  " + e.getMessage());
            }
        }
        return integers;
    }

    @Override
    String decrypt(ArrayList<Integer> input, int c, int d) {

        return null;
    }

    @Override
    public String getEncryptedMessage(String input, int c, int d) {
        String encryptedMessage = "";
        HashMap<String,Integer> conversionTable = table.getAlphabetTable();
        ArrayList<Integer> encryptedNumbers = encrypt(input, c, d);

        for (int i=0; i<encryptedNumbers.size();i++) {
            encryptedMessage += getKeyByValue(conversionTable, encryptedNumbers.get(i));
        }
        return encryptedMessage;
    }

}

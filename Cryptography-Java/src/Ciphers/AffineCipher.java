package Ciphers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jin Min on 2018-04-25.
 */
public class AffineCipher extends Cipher {

    public AffineCipher() {
        super(CipherType.AFFINE);
    }

    /**
     * Returns an array of Integers which represents the encrypted message given the input string,
     * modular coefficient and how much to shift for the encryption for an affine cipher
     *
     * @param input an input message that will be encrypted
     * @param a      the modular coefficient for affine cipher
     * @param b      the number representing how much to shift for the encryption
     * */
    @Override
    public ArrayList<Integer> encrypt(String input, int a, int b) throws Exception {
        int length = input.length();
        ArrayList<Integer> integers = new ArrayList<Integer>(length);
        HashMap<String,Integer> conversionTable = table.getAlphabetTable();

        if (gcd(a,26) != 1) {
            throw new Exception("Coefficient must be coprime to 26");
        }

        for (int index = 0; index < length; index++) {
            Integer codeNumber = (a*conversionTable.get(Character.toString(input.charAt(index))) + b) % 26; // mod 26
            integers.add(codeNumber);
        }
        return integers;
    }


    /**
     * Returns a string which represents the decrypted message given the input array,
     * modular coefficient and how much was shifted for the encryption for an affine cipher
     * As a convention, used c and d for the parameters but they are calculated from the given inputs
     * which will be the same numbers used to encrypt the message
     *
     * @param input an input message that will be encrypted
     * @param c      the modular coefficient for affine cipher; c is the inverse of a (mod 26)
     * @param d      the number representing how much was shifted for the encryption; d is negative the inverse of a (mod 26) times b
     * */
    @Override
    public String decrypt(String input, int c, int d) {
        String decryptedMessage = "";
        int length = input.length();
        HashMap<String,Integer> conversionTable = table.getAlphabetTable();
        HashMap<Integer, String> reverseConversionTable = table.getAlphabetTableReverse();
        Integer decryptCoefficient = findInverse(c, 26);
        Integer decryptShift = -decryptCoefficient*d;

        if (decryptCoefficient == -1) {
            return "Cannot find " + c + " inverse modulo 26" ;
        }

        for (int index = 0; index < length; index++) {
            try {
                Integer codeNumber = (decryptCoefficient*conversionTable.get(Character.toString(input.charAt(index))) + decryptShift) % Modular;

                if (codeNumber >= Modular) {
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
}

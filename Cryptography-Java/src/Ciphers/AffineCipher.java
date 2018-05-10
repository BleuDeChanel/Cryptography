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
     * @param a      the modular coefficient for shift cipher; it's going to be one
     * @param b      the number representing how much to shift for the encryption
     * */
    @Override
    public ArrayList<Integer> encrypt(String input, int a, int b) {
        int length = input.length();
        ArrayList<Integer> integers = new ArrayList<Integer>(length);
        HashMap<String,Integer> conversionTable = table.getAlphabetTable();

        for (int index = 0; index < length; index++) {
            Integer codeNumber = (a*conversionTable.get(Character.toString(input.charAt(index))) + b) % 26; // mod 26
            integers.add(codeNumber);
        }
        return integers;
    }


    /**
     * Returns a string which represents the decrypted message given the input array,
     * modular coefficient and how much was shifted for the encryption for an affine cipher
     *
     * @param input an input message that will be encrypted
     * @param c      the modular coefficient for shift cipher; it's going to be one
     * @param d      the number representing how much was shifted for the encryption
     * */
    @Override
    public String decrypt(String input, int c, int d) {
        return null;
    }


    /**
     * Returns a string which represents the encrypted message given the input string,
     * modular coefficient and how much to shift for the encryption for an affine cipher
     *
     * @param input an input message that will be encrypted
     * @param a      the modular coefficient for shift cipher; it's going to be one
     * @param b      the number representing how much was shifted for the encryption
     * */
    @Override
    public String getEncryptedMessage(String input, int a, int b) {
        return null;
    }

}

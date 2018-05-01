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

    @Override
    ArrayList<Integer> encrypt(String input, int a, int b) {
        int length = input.length();
        ArrayList<Integer> integers = new ArrayList<Integer>(length);
        HashMap<String,Integer> conversionTable = table.getAlphabetTable();

        for (int index = 0; index < length; index++) {
            Integer codeNumber = (a*conversionTable.get(Character.toString(input.charAt(index))) + b) % 26; // mod 26
            integers.add(codeNumber);
        }
        return integers;
    }

    @Override
    String decrypt(String input, int c, int d) {
        return null;
    }

    @Override
    String getEncryptedMessage(String input, int a, int b) {
        return null;
    }

}

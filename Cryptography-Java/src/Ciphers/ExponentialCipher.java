package Ciphers;

import java.util.ArrayList;

/**
 * Created by Jin Min on 2018-05-11.
 */
public class ExponentialCipher extends Cipher{

    public ExponentialCipher() { super(CipherType.EXPONENTIAL); }

    @Override
    public ArrayList<Integer> encrypt(String input, int a, int b) throws Exception {
        return null;
    }

    @Override
    public String decrypt(String input, int c, int d) {
        return null;
    }
}

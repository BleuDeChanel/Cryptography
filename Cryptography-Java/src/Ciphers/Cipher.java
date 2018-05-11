package Ciphers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jin Min on 2018-04-25.
 */

enum CipherType
{
    SHIFT, AFFINE, EXPONENTIAL
};

public abstract class Cipher {
    protected CipherType cipher;
    protected final static EnglishAlphabet table = new EnglishAlphabet();
    protected final static int Modular = 26;

    public Cipher(CipherType cipherType) {
        this.cipher = cipherType;
        table.createTable();
    }

    public abstract ArrayList<Integer> encrypt(String input, int a, int b);
    public abstract String decrypt(String input, int c, int d);

    /**
     * Returns a string which represents the encrypted message given the input string,
     * modular coefficient and how much to shift for the encryption for an affine cipher
     *
     * @param input an input message that will be encrypted
     * @param a      the modular coefficient for the cipher
     * @param b      the number representing how much was shifted for the encryption
     * */
    public String getEncryptedMessage(String input, int a, int b) {
        String encryptedMessage = "";
        HashMap<Integer, String> reverseConversionTable = table.getAlphabetTableReverse();
        ArrayList<Integer> encryptedNumbers = encrypt(input, a, b);

        for (int i=0; i<encryptedNumbers.size();i++) {
            encryptedMessage += reverseConversionTable.get(encryptedNumbers.get(i));
        }
        return encryptedMessage;
    }

    /**
     * Method below are now static under this class, but if more calculations were to supported,
     * maybe I should build up the Calculation interface
     * */

    /**
     * Calculates the greatest common divisor of the two inputs
     * */
    public static int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); };

    /**
     * Find an inverse a mod m
     * */

    public static int findInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

}



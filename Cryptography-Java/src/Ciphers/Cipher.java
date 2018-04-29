package Ciphers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

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

    abstract ArrayList<Integer> encrypt(String input, int a, int b);
    abstract String decrypt(ArrayList<Integer> input, int c, int d);
    abstract String getEncryptedMessage(String input, int a, int b);

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }


    /**
     * Method below are now static under this class, but if more calculations were to supported,
     * maybe I should build up the Calculation interface
     * */

    public static int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); };

    public static int findInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

}


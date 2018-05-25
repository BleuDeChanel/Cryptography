package Test;

import Ciphers.Cipher;
import Ciphers.ShiftCipher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jin Min on 2018-05-11.
 */
public class TestCipher {
    private Cipher cipher;

    @Before
    public void setUp() { cipher = new ShiftCipher(); }

    @Test
    public void testGCD() {
        assertEquals(cipher.gcd(2,4), 2);
        assertEquals(cipher.gcd(4,12), 4);
        assertEquals(cipher.gcd(2,7), 1);
        assertEquals(cipher.gcd(35,72), 1);
        assertEquals(cipher.gcd(36,213), 3);
        assertEquals(cipher.gcd(47,59), 1);
        assertEquals(cipher.gcd(1258, 752), 2);
    }

    @Test
    public void testFindInverse() {
        assertEquals(cipher.findInverse(2,7), 4);
        assertEquals(cipher.findInverse(2,15), 8);
        assertEquals(cipher.findInverse(3,7), 5);
        assertEquals(cipher.findInverse(9,31), 7);
        assertEquals(cipher.findInverse(9,273), -1);
        assertEquals(cipher.findInverse(3,15), -1);
    }
}

package Test;

import Ciphers.Cipher;
import Ciphers.ShiftCipher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jin Min on 2018-04-25.
 */
public class TestShiftCipher {
    private Cipher shiftCipher;

    @Before
    public void setUp() {
        shiftCipher = new ShiftCipher();
    }

    @Test
    public void testShiftCipherEncrypt() {
        ArrayList<Integer> original = new ArrayList<Integer>(Arrays.asList(12,4,4,19,0,19,5,14,20,17));
        ArrayList<Integer> encrypted = new ArrayList<Integer>(Arrays.asList(15,7,7,22,3,22,8,17,23,20));
        try {
            assertEquals(shiftCipher.encrypt("meetatfour", 1, 0), original);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(shiftCipher.encrypt("meetatfour", 1, 3), encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShiftCipherEncrypt2() {
        ArrayList<Integer> original = new ArrayList<Integer>(Arrays.asList(25, 0, 17, 0));
        ArrayList<Integer> encrypted = new ArrayList<Integer>(Arrays.asList(6,7,24,7));
        try {
            assertEquals(shiftCipher.encrypt("zara", 1, 0), original);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertEquals(shiftCipher.encrypt("zara", 1, 7), encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShiftCipherGetEncryptedMessage() {
        assertEquals(shiftCipher.getEncryptedMessage("meetatfour", 1, 3), "phhwdwirxu");
        assertEquals(shiftCipher.getEncryptedMessage("zara", 1, 7), "ghyh");
    }

    @Test
    public void testShiftCipherDecrypt() {
        assertEquals(shiftCipher.decrypt("phhwdwirxu", 1, 3), "meetatfour");
        assertEquals(shiftCipher.decrypt("ghyh", 1, 7), "zara");
    }
}

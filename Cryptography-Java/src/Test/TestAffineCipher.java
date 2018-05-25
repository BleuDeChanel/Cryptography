package Test;

import Ciphers.AffineCipher;
import Ciphers.Cipher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


/**
 * Created by Jin Min on 2018-05-02.
 */
public class TestAffineCipher {
    private Cipher affineCipher;

    @Before
    public void setUp() { affineCipher = new AffineCipher(); }

    @Test
    public void testAffineCipherEncrypt() {
        ArrayList<Integer> original = new ArrayList<Integer>(Arrays.asList(11,14,21,4));
        ArrayList<Integer> encrypted = new ArrayList<Integer>(Arrays.asList(16,9,10,15));
        try {
            assertEquals(affineCipher.encrypt("love",1,0), original);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            affineCipher.encrypt("love", 2, 1);
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Coefficient must be coprime to 26");
        }
        try{
            assertEquals(affineCipher.encrypt("love", 15, 7), encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAffineCipherGetEncryptedMessage() {
        try {
            affineCipher.getEncryptedMessage("zara", 3, 5);
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Coefficient must be coprime to 26");
        }
        try {
            assertEquals(affineCipher.getEncryptedMessage("love", 15, 7), "qjkp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAffineCipherDecrypt() {
        assertEquals(affineCipher.decrypt("xdrj",2,1), "Cannot find 2 inverse modulo 26");
        assertEquals(affineCipher.decrypt("qjkp", 15, 7), "love");
    }
}

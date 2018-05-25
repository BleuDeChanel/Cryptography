package Test;

import Ciphers.Cipher;
import Ciphers.ExponentialCipher;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Jin Min on 2018-05-11.
 */
public class TestExponentialCipher {
    private Cipher exponentialCipher;

    @Before
    public void setUp() { exponentialCipher = new ExponentialCipher(); }

    @Test
    public void testExponentialCipherEncrypt() {

    }
}

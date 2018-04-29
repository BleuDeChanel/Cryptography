package Test;

/**
 * Created by Jin Min on 2018-04-25.
 */

import Ciphers.EnglishAlphabet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestEnglishAlphabet {
    private EnglishAlphabet englishAlphabet;

    @Before
    public void setUp() {
        englishAlphabet = new EnglishAlphabet();
    }

    @Test
    public void testTable() {
        ArrayList<Integer> integers = new ArrayList<Integer>(26);
        for (int i=0; i<26; i++) {
            integers.add(i);
        }
        assertEquals(englishAlphabet.getTableKeys(englishAlphabet.getAlphabetTable()), "abcdefghijklmnopqrstuvwxyz");
        assertEquals(englishAlphabet.getTableValues(englishAlphabet.getAlphabetTable()), integers);
    }

//    @Test
//    public void testRevserseTable() {
//        ArrayList<Integer> integers = new ArrayList<Integer>(26);
//        for (int i=0; i<26; i++) {
//            integers.add(i);
//        }
//        assertEquals(englishAlphabet.getTableKeys(englishAlphabet.getAlphabetTableReverse()), "abcdefghijklmnopqrstuvwxyz");
//        assertEquals(englishAlphabet.getTableValues(), integers);
//    }

}

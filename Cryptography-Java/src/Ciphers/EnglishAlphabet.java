package Ciphers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jin Min on 2018-04-25.
 */

public class EnglishAlphabet {
    private HashMap<String,Integer> alphabetTable;
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public  EnglishAlphabet() {
        this.alphabetTable = new HashMap< String,Integer>();
        createTable();
    }

    public void createTable() {
        for (int i=0;i<26;i++) {
            this.alphabetTable.put(Character.toString(alphabet[i]), new Integer(i));
        }
    }

    public HashMap<String, Integer> getAlphabetTable() {
        return this.alphabetTable;
    }

    public String getKeys() {
        Set< Map.Entry< String,Integer> > keys = this.alphabetTable.entrySet();
        String result = "";
        for (Map.Entry< String,Integer> me:keys)
        {
            result += me.getKey();
        }
        return result;
    }

    public ArrayList<Integer> getValues() {
        Set< Map.Entry< String,Integer> > keys = this.alphabetTable.entrySet();
        ArrayList<Integer> result = new ArrayList<Integer>(26);
        for (Map.Entry< String,Integer> me:keys) {
            result.add(me.getValue());
        }
        return result ;
    }
}

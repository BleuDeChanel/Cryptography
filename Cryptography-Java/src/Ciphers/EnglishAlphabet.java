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
    private HashMap<Integer,String> alphabetTableReverse;
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

    public void createReverseTable() {
        for (int i=0;i<26;i++) {
            this.alphabetTableReverse.put(new Integer(i), Character.toString(alphabet[i]));
        }
    }

    public HashMap<String, Integer> getAlphabetTable() {
        return this.alphabetTable;
    }
    public HashMap<Integer, String> getAlphabetTableReverse() {
        return this.alphabetTableReverse;
    }

    // Evenif I use <T,E> Not sure how to return String OR ArrayList<Integer> depending on the type of T...
    public <T,E> String getTableKeys(Map<T, E> table) {
        Set< Map.Entry<T,E> > keys = table.entrySet();
        String resultString = "";
        ArrayList<Integer> resultArray = new ArrayList<Integer>(26);

        for (Map.Entry<T,E> me:keys)
        {
            if (me.getKey() instanceof String) {
                try {
                    resultString += me.getKey();
                } catch (Exception e) {
                    System.out.println("Type of the Key does not support the + operator!");
                }
            }

            else if (me.getKey() instanceof Integer) {
                try {
                    resultArray.add((Integer) me.getValue());
                } catch (Exception e) {
                    System.out.println("Value should be an Integer!");
                }
            }

            else {
                System.out.println("Key is neither String nor Integer!");
            }
        }
        return resultString; // could we conditionally return String OR Array?
    }

    public <T,E> ArrayList<Integer> getTableValues(Map<T, E> table) {
        Set< Map.Entry< T,E> > keys = table.entrySet();
        ArrayList<Integer> result = new ArrayList<Integer>(26);
        for (Map.Entry< T,E> me:keys) {
            try {
                result.add((Integer) me.getValue());
            } catch (Exception e) {
                System.out.println("Value should be an Integer!");
            }

        }
        return result ;
    }


    


}

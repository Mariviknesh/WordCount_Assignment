package org.example;

import java.util.*;
import java.io.*;
import java.util.logging.*;


public class Main {
    public static <LinkedHashMap> void main(String[] args) throws IOException {
        String str=" ";
        Logger l=Logger.getLogger("com.api.jar");
        HashMap<String,Integer> hs=new HashMap<>();
        File file = new File(
                "C:\\Users\\Tringapps-User2\\Documents\\example.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String[] words;
        String st;
        while ((st = br.readLine()) != null)
        {
            str=st+str;
        }
        words=str.split(" ");
        for(String word:words){
            Integer integer = hs.get(word);
            if (integer == null)
            {
                hs.put(word, 1);
            }

            else {
                hs.put(word, integer + 1);
            }
        }
        String sor=hs+" ";
        l.log(Level.INFO,()->"before Sorting "+ sor);

        List<Map.Entry<String, Integer>> sorted = hs.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();

        l.log(Level.INFO,()->"After Sorting "+ sorted);
    }
}
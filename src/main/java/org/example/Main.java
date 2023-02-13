package org.example;

import java.util.*;
import java.io.*;
import java.util.logging.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Logger l=Logger.getLogger("com.api.jar");
        HashMap<String,Integer> hs=new HashMap<>();
        String se = "C:\\Users\\Tringapps-User2\\Documents\\example.txt";
        File file = new File(se);
        Scanner mysc = new Scanner(file);
        String word;

        while(mysc.hasNext())
        {
            word = mysc.next();
            if(hs.containsKey(word))
            {
                int count = hs.get(word) + 1;
                hs.put(word,count);
            }
            else
            {
                hs.put(word, 1);
            }
        }

        String map=hs+" ";
        l.log(Level.INFO,()->"before Sorting "+ map);

        List<Map.Entry<String, Integer>> sortedMap = hs.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();

        l.log(Level.INFO,()->"After Sorting "+ sortedMap);
    }
}
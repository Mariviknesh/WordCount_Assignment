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

        String hmap=hs+" ";
        l.log(Level.INFO,()->"before Sorting "+ hmap);

        List<Map.Entry<String, Integer>> sortedHmap = hs.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();

        l.log(Level.INFO,()->"After Sorting "+ sortedHmap);
    }
}
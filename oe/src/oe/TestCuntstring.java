package oe;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestCuntstring {

    public static void main(String[] args) {
    	boolean flagChange=false;
        String name = "afff";
        char[] ar = new char[name.length()];
        for (int i = 0; i < name.length(); i++) {
            ar[i] = name.charAt(i);
        }
        Map<Character, String> map=new LinkedHashMap<Character, String>();
        for (int i = 0; i < ar.length; i++) {
            int count=0;
            for (int j = i; j < ar.length; j++) {
            	System.out.println("i="+i+" j="+j+"a[i] "+ar[i]+"-"+ar[j]);
                if(ar[i]==ar[j]){
                    count++;
                    System.out.println(count);
                }else
                	break;
            }
            map.put(ar[i], count+" times");
        }
        System.out.println(map);
    }

}
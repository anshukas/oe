package oe;

import java.util.*;

public class LargestSubstring {
	public static void main(String[] args){
		@SuppressWarnings("rawtypes")
		Map map = new LinkedHashMap();
		
		String str = "afffcccaaaa";
		int i;
		for(i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			if(!map.containsKey(ch)){
				map.put(ch, 1);
			}else{
				int value = (Integer) map.get(ch);
				map.put(ch, value+1);
			}
		}
		System.out.println(map);
	}
}

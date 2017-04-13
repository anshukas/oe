package oe.work;

import java.util.Map;
import java.util.HashMap;

public class DemoMapRefernce {
	public static void main(String[] args){
		Map map = new HashMap();
		int[] arrayInt = {1,2,3,4};
		for(int i=0;i<arrayInt.length;i++){
			addValnMap(map,arrayInt[i]);
		}
	}

	private static void addValnMap(Map map, int i) {
		// TODO Auto-generated method stub
		map.put(i, i);
		System.out.println(map);
	}
}

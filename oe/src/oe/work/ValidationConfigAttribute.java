package oe.work;

import java.util.HashMap;
import java.util.Map;

public class ValidationConfigAttribute {
	public static void main(String[] args) {
		ProcessForValidation obj = new ProcessForValidation();
		
		for(int i=0;i<obj.nsPrdCodeArray.length;i++){
			//both array length must be same.
				System.out.println(obj.validateForConfigurableAttribute(obj.nsPrdCodeArray[i], obj.colorCodeArray[i]));
		}
		
	}
}
class ProcessForValidation {
	
	String[] nsPrdCodeArray = {"aaa-bbbb-xxxx","aaa-bbbb-yyyy","aaa-bbbb-yyyy","aaa-cccc-xxxx"};
	String[] colorCodeArray = {"06","06","07","06"};
	Map<String, String> nsProdConfigAttributeCodeMap = new HashMap<String,String>();
	
	public boolean validateForConfigurableAttribute(final String nsProductCode, final String attributeCode) {
		// TODO Auto-generated method stub
		
		String prdCode = nsProductCode.substring(0, 8);
		
		if(!nsProdConfigAttributeCodeMap.containsKey(nsProductCode)) {
			
			if(!nsProdConfigAttributeCodeMap.containsValue(attributeCode)){
				nsProdConfigAttributeCodeMap.put(nsProductCode, attributeCode);
				System.out.println("Value in map 1: "+nsProdConfigAttributeCodeMap);
				return true;
			}else{
				System.out.println("Value in map 2: "+nsProdConfigAttributeCodeMap +" current NSprd Code: "+nsProductCode+" current Code "+attributeCode);
				for (Map.Entry<String, String>  map: nsProdConfigAttributeCodeMap.entrySet()) {
					String prd = (String)map.getKey().substring(0, 8);
					if(!prd.equals(prdCode)) {
						nsProdConfigAttributeCodeMap.put(nsProductCode, attributeCode);
						return true;
					}
				}
			}
		}else{
			String value = (String)nsProdConfigAttributeCodeMap.get(nsProductCode);
			if(value.equalsIgnoreCase(attributeCode))
				return true;
		}
//		System.out.println("Value in map: "+nsProdConfigAttributeCodeMap);
		return false;
	}

	public Map<String, String> getData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaa-bbbb-xxxx", "06"); //true
		map.put("aaa-bbbb-yyyy", "06"); //false
		map.put("aaa-bbbb-yyyy", "07"); // true
		map.put("aaa-cccc-xxxx", "06"); // true
		return map;
	}
}
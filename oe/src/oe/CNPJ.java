package oe;
/**
 * This is CNPJ code in java <p>cnpj-code-in-java</p>
 * Needed for testing time.
 * @author anshu.kumar
 *
 */
public class CNPJ {
	public static void main(String[] args){
		System.out.println(cnpj());
	}
	
	static int randomiza(int n) {
	  int ranNum = (int) Math.round(Math.random() * n);
	  return ranNum;
	}

	static int mod(int dividendo, int divisor) {
	  return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}
	
	public static String cnpj(){
		int n = 9;
		int n1 = randomiza(n);
		int n2 = randomiza(n);
		int n3 = randomiza(n);
		int n4 = randomiza(n);
		int n5 = randomiza(n);
		int n6 = randomiza(n);
		int n7 = randomiza(n);
		int n8 = randomiza(n);
		int n9 = randomiza(n);
		int n10 = randomiza(n);
		int n11 = randomiza(n);
		int n12 = randomiza(n);
		int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;
		d1 = 11 - (mod(d1, 11));
		if (d1 >= 10) 
			d1 = 0;
		int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;
		d2 = 11 - (mod(d2, 11));
		if (d2 >= 10) 
			d2 = 0;
		
		//String str =""+n1 + n2 + '.' + n3 + n4 + n5 + '.' + n6 + n7 + n8 + '/' + n9 + n10 + n11 + n12 + '-' + d1 + d2;
		String str =""+n1 + n2 + n3 + n4 + n5  + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;
		return str;
	}
}

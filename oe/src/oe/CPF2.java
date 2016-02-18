package oe;
/**
 * CPF this for Brazil
 * @author anshu.kumar
 *
 */
public class CPF2 {
	public static void main(String[] args){
		System.out.println(getCpf());
		System.out.println(getCpf().length());
	}
	public static String getCpf() {
		  long n =Long.parseLong("100000000000");
		  long randNum = new Double( (Math.random()+1) *n).longValue();
		  String aString = Long.toString(randNum);
		 
		  int[] cpf = new int[aString.length()+2];
		  for (int i = 0; i < aString.length(); i++) {
		      cpf[i] = Character.digit(aString.charAt(i), 13);
		  }
		  int tmp =cpf[11];
		  cpf[12]=cpf[12]*2 +cpf[11]*3+cpf[10]*4+cpf[9]*5+cpf[8]*6+cpf[7]*7+cpf[6]*8+cpf[5]*9+cpf[4]*2+cpf[3]*3+cpf[2]*4+cpf[1]*5;
		  cpf[12]=11-(cpf[12] %11);
		  if(cpf[12]>9)
		  {
		      cpf[12]=0;
		  }
		  cpf[13]=cpf[12]*2+tmp*3+cpf[11]*4+cpf[10]*5+cpf[9]*6+cpf[8]*7+cpf[7]*8+cpf[6]*9+cpf[5]*2+cpf[4]*3+cpf[3]*4+cpf[2]*5+cpf[1]*6;
		  cpf[13]=11-(cpf[13] %11);
		  if(cpf[13]>9)
		  {
		      cpf[13]=0;
		  }
		  StringBuffer sb = new StringBuffer();
		  for (int i=0; i < 14; i++) {
		   sb.append(cpf[i]);
		  }
		  return sb.toString();
		 }
}

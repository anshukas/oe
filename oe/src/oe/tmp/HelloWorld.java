package oe.tmp;

public class HelloWorld{

    public static void main(String []args){
        String s1 =  "abc";
        String s2 = "def";
        StringBuffer s3 =  new StringBuffer();
        for(int i=0; i<s1.length();i++) {
            s3 = s3.append(s1.charAt(i));
            s3 = s3.append(s2.charAt(i));
        }
       System.out.println(s3);
    }
}

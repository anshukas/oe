package oe.work;

import java.nio.charset.Charset;

public class Encoding {
	public static void main(String[] args){
		 byte[] utf8bytes = { (byte)0xc3, (byte)0xa2, 0x61, 0x62, 0x63, 0x64 };
		    Charset utf8charset = Charset.forName("UTF-8");
		    Charset iso88591charset = Charset.forName("ISO-8859-1");

		    String string = new String ( utf8bytes, utf8charset );

		    System.out.println(string);

		    // "When I do a getbytes(encoding) and "
		    byte[] iso88591bytes = string.getBytes(iso88591charset);

		    for ( byte b : iso88591bytes )
		        System.out.printf("%02x ", b);

		    System.out.println();

		    // "then create a new string with the bytes in ISO-8859-1 encoding"
		    String string2 = new String ( iso88591bytes, iso88591charset );

		    // "I get a two different chars"
		    System.out.println(string2);
	}
}

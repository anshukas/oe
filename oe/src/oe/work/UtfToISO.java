package oe.work;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class UtfToISO {
    static File input = new File("D:/dev/in.txt");
    static File output = new File("D:/dev/out.txt");


public static void main(String[] args) throws IOException {

    BufferedReader br = null;

    FileWriter fileWriter = new FileWriter(output);
    try {

        String sCurrentLine;

        br = new BufferedReader(new FileReader( input ));

        int i= 0;
        while ((sCurrentLine = br.readLine()) != null) {
            byte[] isoB =  encode( sCurrentLine.getBytes() );
            fileWriter.write(new String(isoB, Charset.forName("ISO-8859-1") ) );
            fileWriter.write("\n");
            System.out.println( i++ );
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            fileWriter.flush();
            fileWriter.close();
            if (br != null)br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}


static byte[] encode(byte[] arr){
    Charset utf8charset = Charset.forName("UTF-8");
    Charset iso88591charset = Charset.forName("ISO-8859-1");

    ByteBuffer inputBuffer = ByteBuffer.wrap( arr );

    // decode UTF-8
    CharBuffer data = utf8charset.decode(inputBuffer);

    // encode ISO-8559-1
    ByteBuffer outputBuffer = iso88591charset.encode(data);
    byte[] outputData = outputBuffer.array();

    return outputData;
}

}
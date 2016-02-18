package oe.work;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * tech#707
 * @author Kansakar
 *
 */
public class WindowLastModifiedDate {
	public static void main(String[] args){
		File file = new File("D:\\Install\\Eclipse\\eclipse-git\\java\\java\\src\\tech\\oe\\file");
		String fileName = file.getName();
		long fileLastModifiedDate = file.lastModified();
		// This print the date in long format. We need to formate the long in Date
		System.out.println("The last modified date for this - "+ fileName
				+" with lastModified date - "+ fileLastModifiedDate);
		
		//convert the long value in date format
		SimpleDateFormat sdf = new  SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		// format() take argument as object and return string
		String formateDate = sdf.format(fileLastModifiedDate);
		System.out.println("LastmodifiedDate of file in format "+formateDate);
		
	}
}

package oe.work;

/**
 * This works on Java 1.7
 */
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class SearchStaticText {
	public static void main(String[] args){
		 String dir = "C:\\aa\\account";
		 //String dir = "C:\\aa\\Netshoes-AR.war";
		 Path path = Paths.get(dir);
		 List<String> list = new ArrayList<String>();
		 List<String> fileName = getFileNames(list, path);
		 System.out.println(fileName);

	}
	
	private static List<String> getFileNames(List<String> fileNames, Path dir) {
	    try {
	    	DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
	        for (Path path : stream) {
	            if(path.toFile().isDirectory()) {
	                getFileNames(fileNames, path);
	            } else {
	            	//TODO: Here I get file for further process. 
	                fileNames.add(path.toAbsolutePath().toString());
	                System.out.println(path.getFileName());
	                openFileReadTheContent(path);
	            }
	        }
	    } catch(IOException e) {
	        e.printStackTrace();
	    }
	    return fileNames;
	}

	private static void openFileReadTheContent(Path file) {
		// TODO Great man reading the content love you :)
		try (InputStream in = Files.newInputStream(file);
			    BufferedReader reader =
			      new BufferedReader(new InputStreamReader(in))) {
			    String line = null;
			    int lineCount=0;
			    while ((line = reader.readLine()) != null) {
			    	lineCount++;
			        //System.out.println(lineCount+"-->"+line);
			    	processTheLine(lineCount,line.trim());
			    }
			} catch (IOException x) {
			    System.err.println(x);
			}
	}

	private static void processTheLine(int lineCount, String line) {
		// TODO Auto-generated method stub
		char[] charArray = line.toCharArray();
		boolean flag = false;
		int startInd = 0;
		boolean skipline=skipOnlyTabline(line);
		
		if(!line.isEmpty())
		if(!line.contains("<%=") && !line.contains("/assets/js-min/") && !line.contains("static final") &&
				!line.contains(";") && !line.contains("--%>") &&  !line.contains("-->") && !line.contains("function") && !line.contains("if (")  ){
			
			for (int i = 0; i < line.length(); i++) {
				char ch=line.charAt(i);
				
				if(ch==' '||ch=='\t') continue;
				if(ch=='>' ){
					flag = true;
					startInd = i;
				}
				if(flag == true && ch !='<'){
					if(ch=='\t') continue;
					if(i > startInd){
						//System.out.print(line.charAt(i));
						System.out.println(lineCount+"->"+line);
						break;
					}
				}else{
					flag = false;
				}
			}
			if(line.indexOf('<')==-1 && line.indexOf('>')==-1 && line.indexOf('}')==-1){
				System.out.println(lineCount+"--->"+line);
			}
		}
			
	}

	private static boolean skipOnlyTabline(String line) {
		// TODO Auto-generated method stub
		
		return false;
	} 
}
*/
package oe.work;

import java.io.File;
import java.io.IOException;
/**
 * I love this script :)
 * This help to execute my command or bat file in cmd.
 * @author anshu.kumar
 *
 */
public class RunBat {
	public static void main(String[] args) throws IOException, InterruptedException{
		String path = "C:\\ATG\\ATG10.1.2\\home\\bin";
		String file ="C:\\ATG\\ATG10.1.2\\home\\servers\\xprdimport_prd\\";
		int start=0;
		int end=37;
		long startTime = System.currentTimeMillis();
		System.out.println("StartTime: "+startTime);
		for(int i=start;i<=end;i++){
			//hey this line start my cmd and excute the command
			Runtime.getRuntime().exec("cmd /c start startSQLRepository -m Netshoes.estore-ar -s xprdimport_prd -repository /atg/userprofiling/ProfileAdapterRepository -import "+file+"add-item"+i+".xml", null, new File(path));
			//Pause for 4 min
				Thread.sleep(240000);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("EndTIme: "+endTime);
		long totalTimeTaken = endTime-startTime;
		System.out.println("TotalTimeTaken : in ms "+totalTimeTaken);
	}
}

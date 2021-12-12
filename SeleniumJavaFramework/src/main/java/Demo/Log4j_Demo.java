package Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// This is to Demo Log4j reporting
// Setup is found on src/main/resources Log4j2.properties
// Captured Logs are found on logs MyLo4j_Logs.log

public class Log4j_Demo {

	private static Logger logger = LogManager.getLogger(Log4j_Demo.class);
	
	public static void main(String[] args) {

		System.out.println("\n This is Log4j \n");
		
		logger.trace("This is Trace Message");
		logger.info("This is Information message");
		logger.error("This is for Error Message");
		logger.warn("This is for Warning Message");
		logger.fatal("This is for Fatal Message");
		
		System.out.println("\n Test Completed");
		
	}

}

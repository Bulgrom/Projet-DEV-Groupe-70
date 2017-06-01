package logger;
import java.util.logging.*;
import java.io.IOException;

public class GameLogger {
	
	private static Logger logger = Logger.getLogger(GameLogger.class.getName());
	
	
	/**Write on fileName.txt + displays on console the message data
	 * @param fileName
	 * @param data
	 */
	public static void writeInfoLogs(String fileName, String data){
		SimpleFormatter sf = new SimpleFormatter();
		try{
			FileHandler fh = new FileHandler(fileName+".txt",true);
			fh.setFormatter(sf);
			logger.addHandler(fh);
			logger.info(data);
		} catch (SecurityException e){
			logger.severe("Can't add this file");
		} catch(IOException e){
			logger.severe("Can't add this file");
		}
	}

	/**Prints on console Informations
	 * @param data
	 */
	public static void infoLogs(String data){
		logger.info(data);
	}
	
	/**Prints on console (+files if created) logs of severe Level
	 * @param data
	 */
	public static void severeLogs(String data){
		logger.severe(data);
	}
	
	/**Prints on console (+files if created) logs of warning Level
	 * @param data
	 */
	public static void warningLogs(String data){
		logger.warning(data);
	}
}

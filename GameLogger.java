package fr.game;
import java.util.logging.*;
import java.io.IOException;

public class GameLogger {
	
	private Logger logger;
	/**Create a logger, needed to display messages
	 * 
	 */
	public GameLogger(){
		logger = Logger.getLogger("GameLogger");	
	}
	
	/**Create a new File to receive logs
	 * @param fileName
	 */
	public void setFileLogs(String fileName){
		SimpleFormatter sf = new SimpleFormatter();
		try{
			FileHandler fh = new FileHandler(fileName+".txt", true);
			fh.setFormatter(sf);
			logger.addHandler(fh);

		}
		catch (SecurityException e){
			logger.severe("Impossible d'ajouter ce fichier de logs");
		}
		catch (IOException e){
			logger.severe("Impossible d'ajouter ce fichier de logs");
		}
	}
	/**Prints on console (+files if created) Informations
	 * @param data
	 */
	public void infoLogs(String data){
		logger.info(data);
	}
	
	/**Prints on console (+files if created) logs of severe Level
	 * @param data
	 */
	public void severeLogs(String data){
		logger.severe(data);
	}
	
	/**Prints on console (+files if created) logs of warning Level
	 * @param data
	 */
	public void warningLogs(String data){
		logger.warning(data);
	}
}

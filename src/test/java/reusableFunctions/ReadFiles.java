package reusableFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFiles {
	
	public static String readPropFile(String key){
		
	File file = new File("src\\test\\resources\\Properties\\EnvironmentVariables.properties");
	  
	FileInputStream fileInput = null;
	
	try {
		fileInput = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Properties prop = new Properties();
	
	//load properties file
	try {
		prop.load(fileInput);
	} catch (IOException e) {
		e.printStackTrace();
	}

	String retVal=prop.getProperty(key);
	return retVal;

}

}

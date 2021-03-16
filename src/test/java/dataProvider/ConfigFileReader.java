package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	//propertyFilePath : This is just a String variable which holds the information of the config file path.
	private final String propertyFilePath = "src/test/resources/configs/Configuation.properties";

	//Read properties file
	public ConfigFileReader()
	{
		BufferedReader reader;
		try {
			//new FileReader(propertyFilePath) : Creates a new FileReader, given the name of the file to read from.
			//new BufferedReader(new FileReader(propertyFilePath)) : Reads text from a character-input stream, buffering characters so 
			//as to provide for the efficient reading of characters, arrays, and lines.
			reader = new BufferedReader(new FileReader(propertyFilePath));

			//new Properties() : The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. Each key 
			//and its corresponding value in the property list is a string.
			properties = new Properties();

			try {
				//properties.load(reader) : Reads a property list (key and element pairs) from the input character stream in a simple line-oriented format.
				properties.load(reader);
				reader.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	// Get Driver Path
	public String getDriverPath()
	{
		//properties.getProperty(“driverPath”) :Properties object gives us a .getProperty method which takes the Key of the property as a parameter and 
		//return the Value of the matched key from the .properties file.
		String driverPath = properties.getProperty("driverPath");

		//If the properties file does not have the specified key, it returns the null. This is why we have put the null check and in case of null we like to throw an exception 
		//to stop the test with the stack trace information. 
		if(driverPath != null)
		{
			return driverPath;
		}
		else
		{
			throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");	}
	}

	//Get Implicicity Wait
	public long getImplicityWait()
	{
		String implicityWait = properties.getProperty("implicitlyWait");
		if(implicityWait != null)
		{
			try {
				return Long.parseLong(implicityWait);
			} catch (NumberFormatException  e) {
				throw new RuntimeException("Not able to parse value : " + implicityWait + " in to Long");
			}

		}
		return 30;
	}

	//Get Application URL
	public String getApplicationUrl() 
	{
		String url = properties.getProperty("url");

		if(url != null)
		{
			return url;
		}
		else
		{
			throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
		}

	}

	public String getReportConfigPath()
	{
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	}
}

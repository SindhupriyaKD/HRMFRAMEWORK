package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to read the common data
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Sindhu
	 */
	public String readCommonData(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstants.PropertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;

	}
	
	public void writeCommonData(String key, String value) throws IOException
	{
		FileInputStream fis= new FileInputStream(IPathConstants.PropertyFilePath);
		Properties pobj= new Properties();
		pobj.load(fis);
		pobj.setProperty(key, value);
		FileWriter writer= new FileWriter(IPathConstants.PropertyFilePath);
		pobj.store(writer, value);
	}
	

}

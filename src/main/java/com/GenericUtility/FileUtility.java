package com.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	

}

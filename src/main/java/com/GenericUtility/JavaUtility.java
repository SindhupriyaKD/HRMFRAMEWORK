package com.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method is used to generate the random number b/w 1 to 1000
	 * @return int random number
	 * @author sindhu
	 */

	public int random()
	{
		Random random= new Random();
		int ran = random.nextInt(1000);
		return ran;
	}
	
	/**
	 * This method is used to get the current system date
	 * @return String date and time in Thu Mar 16 15:38:59 IST 2023
     * @author Sindhu
	 */
	public String getSystemDate()
	{
		Date date= new Date();
		String dt = date.toString();
		return dt;
	}
	
	/**
	 * This method is used to format the date and time as per the format required.
	 * @return String date and time in (16-38-2023 03-38-11)

	 * @author Sindhu
	 */
	public String formatSystemDate()
	{
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		Date dt= new Date();
		String dateAndTime = dateFormat.format(dt);
		
        //dateAndTime.replace(':', '-');
		//We can give the format how we want in Simpledateformat constructor itself.System will not identify : so we need to replace it will '-' .Here i already gave the right format while creating Simpledateformat obj so no need to replace.
		return dateAndTime;
				
	}
}

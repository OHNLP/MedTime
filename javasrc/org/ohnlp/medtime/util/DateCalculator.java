/*******************************************************************************
 * Copyright: (c)  2013  Mayo Foundation for Medical Education and 
 *  Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 *  triple-shield Mayo logo are trademarks and service marks of MFMER.
 *  
 *  Except as contained in the copyright notice above, or as used to identify 
 *  MFMER as the author of this software, the trade names, trademarks, service
 *  marks, or product names of the copyright holder shall not be used in
 *  advertising, promotion or otherwise in connection with this software without
 *  prior written authorization of the copyright holder.
 *  
 *  MedTime is free software: you can redistribute it and/or modify it under the 
 *  terms of the GNU General Public License as published by the Free Software 
 *  Foundation, either version 3 of the License, or (at your option) any later version.
 *  
 *  MedTime is distributed in the hope that it will be useful, but WITHOUT ANY 
 *  WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 *  FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with MedTime.  If not, see http://www.gnu.org/licenses/.
 *
 *******************************************************************************/
package org.ohnlp.medtime.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.ohnlp.medtime.resourcemanager.NormalizationManager;
/**
 * 
 * This class contains methods that rely on calendar functions to calculate data.
 * @author jannik stroetgen
 *
 */
public class DateCalculator {
	
	/**
	 * get the x-next day of date.
	 * 
	 * @param date given date to get new date from
	 * @param x type of temporal event to search for
	 * @return
	 */
	public static String getXNextDay(String date, Integer x) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = "";
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(formatter.parse(date));
			c.add(Calendar.DAY_OF_MONTH, x);
			c.getTime();
			newDate = formatter.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}

	/**
	 * get the x-next month of date
	 * 
	 * @param date current date
	 * @param x amount of months to go forward 
	 * @return new month
	 */
	public static String getXNextMonth(String date, Integer x) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
		String newDate = "";
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(formatter.parse(date));
			c.add(Calendar.MONTH, x);
			c.getTime();
			newDate = formatter.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}
	
	/**
	 * get the x-next week of date
	 * @param date current date
	 * @param x amount of weeks to go forward
	 * @return new week
	 */
	public static String getXNextWeek(String date, Integer x) {
		NormalizationManager nm = NormalizationManager.getInstance();
		String date_no_W = date.replace("W", "");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-w");
		String newDate = "";
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(formatter.parse(date_no_W));
			c.add(Calendar.WEEK_OF_YEAR, x);
			c.getTime();
			newDate = formatter.format(c.getTime());
			newDate = newDate.substring(0,4)+"-W"+nm.getFromNormNumber(newDate.substring(5));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}

	/**
	 * Get the weekday of date
	 * 
	 * @param date current date
	 * @return day of week
	 */
	public static int getWeekdayOfDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int weekday = 0;
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(formatter.parse(date));
			weekday = c.get(Calendar.DAY_OF_WEEK);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return weekday;
	}

	/**
	 * Get the week of date
	 * 
	 * @param date current date
	 * @return week of year
	 */
	public static int getWeekOfDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int week = 0;
		;
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(formatter.parse(date));
			week = c.get(Calendar.WEEK_OF_YEAR);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return week;
	}
}

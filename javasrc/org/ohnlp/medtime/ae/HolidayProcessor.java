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
package org.ohnlp.medtime.ae;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import org.ohnlp.medtime.type.MedTimex3;
import org.ohnlp.medtime.util.Logger;
/**
 * A processor of MedTime to recognize several (mostly, but not
 * entirely christian) holidays. Adapted from Heideltime.
 * 
 * @author Hongfang Liu & Sunghwan Sohn
 * 
 */
public class HolidayProcessor extends GenericProcessor {

	/**
	 * Constructor just calls the parent constructor here.
	 */
	public HolidayProcessor() {
		super();
	}
	
	/**
	 * all the functionality was put into evaluateCalculationFunctions().
	 */
	public void process(JCas jcas) {
		evaluateCalculationFunctions(jcas);
	}
	
	
	/**
	 * This function replaces function calls from the resource files with their TIMEX value.
	 * @param jcas
	 */
	public void evaluateCalculationFunctions(JCas jcas) {

		// build up a list with all found TIMEX expressions
		List<MedTimex3> linearDates = new ArrayList<MedTimex3>();
		FSIterator<? extends Annotation> iterTimex = jcas.getAnnotationIndex(MedTimex3.type).iterator();

		// Create List of all Timexes of types "date" and "time"
		while (iterTimex.hasNext()) {
			MedTimex3 timex = (MedTimex3) iterTimex.next();
			if ((timex.getTimexType().equals("DATE")) || (timex.getTimexType().equals("TIME"))) {
				linearDates.add(timex);
			}
		}
		
		
		//////////////////////////////////////////////
		// go through list of Date and Time timexes //
		//////////////////////////////////////////////
		//compile regex pattern for validating commands/arguments
		Pattern cmd_p = Pattern.compile("((\\w\\w\\w\\w)-(\\w\\w)-(\\w\\w))\\s+funcDateCalc\\((\\w+)\\((.+)\\)\\)");
		Pattern year_p = Pattern.compile("(\\d\\d\\d\\d)");
		Pattern date_p = Pattern.compile("(\\d\\d\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])");
		Matcher cmd_m;
		Matcher year_m;
		Matcher date_m;
		String date;
		String year;
		String month;
		String day;
		String function;
		String args[];
		String valueNew;
		
		for (int i = 0; i < linearDates.size(); i++) {
			MedTimex3 t_i = (MedTimex3) linearDates.get(i);
			String value_i = t_i.getTimexValue();
			cmd_m = cmd_p.matcher(value_i);
			valueNew = value_i;
		
			if(cmd_m.matches()) {
				date = cmd_m.group(1);
				year = cmd_m.group(2);
				month = cmd_m.group(3);
				day = cmd_m.group(4);
				function = cmd_m.group(5);
				args = cmd_m.group(6).split("\\s*,\\s*");
				
				//replace keywords in function with actual values
				for(int j=0; j<args.length; j++) {
					args[j] = args[j].replace("DATE", date);
					args[j] = args[j].replace("YEAR", year);
					args[j] = args[j].replace("MONTH", month);
					args[j] = args[j].replace("DAY", day);
				}
				
				if(function.equals("EasterSunday")) {
					year_m = year_p.matcher(args[0]);
					//check if args[0] is a valid YEAR value
					if(year_m.matches()) {
						
						//System.err.println("correct format");
						valueNew = this.getEasterSunday(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
					
					}
					else{
						
						Logger.printError("wrong format");
						valueNew = "XXXX-XX-XX";
					
					}
				}
				else if(function.equals("WeekdayRelativeTo")) {
					date_m = date_p.matcher(args[0]);
					//check if args[0] is a valid DATE value
					if(date_m.matches()) {
						
						//System.err.println("correct format");
						valueNew = this.getWeekdayRelativeTo(args[0], Integer.valueOf(args[1]), Integer.valueOf(args[2]), Boolean.parseBoolean(args[3]));
						
					}
					else{

						Logger.printError("wrong format");
						valueNew = "XXXX-XX-XX";
						
					}
				}
				else{
					// if function call doesn't match any supported function
					Logger.printError("command not found");
					valueNew = "XXXX-XX-XX";
				}
			}
						
			t_i.removeFromIndexes();
			t_i.setTimexValue(valueNew);
			t_i.addToIndexes();
			linearDates.set(i, t_i);
		}
	}
	
	/**
	 * Get the date of a day relative to Easter Sunday in a given year. Algorithm used is from the "Physikalisch-Technische Bundesanstalt Braunschweig" PTB.
	 * 
	 * @author Hans-Peter Pfeiffer
	 * @param year
	 * @param days
	 * @return date
	 */
	public String getEasterSunday(int year, int days) {
		int K = year / 100;
		int M = 15 + ( ( 3 * K + 3 ) / 4 ) - ( ( 8 * K + 13 ) / 25 );
		int S = 2 - ( (3 * K + 3) / 4 );
		int A = year % 19;
		int D = ( 19 * A + M ) % 30;
		int R = ( D / 29) + ( ( D / 28 ) - ( D / 29 ) * ( A / 11 ) );
		int OG = 21 + D - R;
		int SZ = 7 - ( year + ( year / 4 ) + S ) % 7;
		int OE = 7 - ( OG - SZ ) % 7;
		int OS = OG + OE;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String date;
		
		if( OS <= 31 ) {
			date = String.format("%04d-03-%02d", year, OS);
		}
		else{
			date = String.format("%04d-04-%02d", year, ( OS - 31 ) );
		}		
		try{
			c.setTime(formatter.parse(date));
			c.add(Calendar.DAY_OF_MONTH, days);
			date = formatter.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * Get the date of Eastersunday in a given year
	 * 
	 * @author Hans-Peter Pfeiffer
	 * @param year
	 * @return date
	 */
	public String getEasterSunday(int year) {
		return getEasterSunday(year, 0);
	}	
	
	
	
	/**
	 * Get the date of a weekday relative to a date, e.g. first Wednesday before 11-23
	 * 
	 * @author Hans-Peter Pfeiffer
	 * @param date
	 * @param weekday
	 * @param number
	 * @param count_itself
	 * @return
	 */
	public String getWeekdayRelativeTo(String date, int weekday, int number, boolean count_itself) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
				
		int day;
		int add;
		
		if(number == 0) {
			try{
				c.setTime(formatter.parse(date));
				date = formatter.format(c.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;			
		}
		else{
			
			if(number<0) {
				number+=1;
			}
						
			try{
				c.setTime(formatter.parse(date));
				day = c.get(Calendar.DAY_OF_WEEK);
				if((count_itself && number>0) || (!count_itself && number <= 0)) {
					if(day<=weekday) {
						add = weekday - day;
					}
					else{
						add = weekday - day + 7;
					}	
				}
				else{
					if(day<weekday) {
						add = weekday - day;
					}
					else{
						add = weekday - day + 7;
					}	
				}
				add += (( number - 1) * 7);
				c.add(Calendar.DAY_OF_MONTH, add);
				date = formatter.format(c.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}
	}
	
	
	/**
	 * Get the date of a the first, second, third etc. weekday in a month
	 * 
	 * @param number
	 * @param weekday
	 * @param month
	 * @param year
	 * @return date
	 */
	public String getWeekdayOfMonth(int number, int weekday, int month, int year) {
		return getWeekdayRelativeTo(String.format("%04d-%02d-01", year, month), weekday, number, true);
	}

}

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
/**
 * Logger class to facilitate a centralized logging effort. Upon initialization of
 * the HeidelTime annotator, the verbosity (printDetails) should be set; any kind of
 * output should be done using either the printDetail()-methods for DEBUG-Level,
 * conditional output or the printError()-methods for ERROR-Level, unconditional
 * output.
 * @author julian zell
 *
 */
public class Logger {
	private static Boolean printDetails = false;

	/**
	 * Controls whether DEBUG-Level information is printed or not
	 * @param printDetails to print or not to print
	 */
	public static void setPrintDetails(Boolean printDetails) {
		Logger.printDetails = printDetails;
	}
	
	/**
	 * print DEBUG level information with package name
	 * @param component Component from which the message originates
	 * @param msg DEBUG-level message
	 */
	public static void printDetail(Class<?> c, String msg) {
		if(Logger.printDetails) {
			String preamble;
			if(c != null)
				preamble = "["+c.getName()+"]";
			else
				preamble = "";
			System.out.println(preamble+" "+msg);
		}
	}
	
	/**
	 * no-package proxy method
	 * @param msg DEBUG-Level message
	 */
	public static void printDetail(String msg) {
		printDetail(null, msg);
	}
	
	/**
	 * print an ERROR-Level message with package name
	 * @param component Component from which the message originates
	 * @param msg ERROR-Level message
	 */
	public static void printError(Class<?> c, String msg) {
		String preamble;
		if(c != null)
			preamble = "["+c.getName()+"]";
		else
			preamble = "";
		System.err.println(preamble+" "+msg);
	}

	/**
	 * no-package proxy method
	 * @param msg ERROR-Level message
	 */
	public static void printError(String msg) {
		printError(null, msg);
	}
}

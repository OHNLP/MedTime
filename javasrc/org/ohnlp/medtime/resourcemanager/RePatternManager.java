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
package org.ohnlp.medtime.resourcemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import org.ohnlp.medtime.util.Logger;
/**
 * 
 * This class fills the role of a manager of all the RePattern resources.
 * It reads the data from a file system and fills up a bunch of HashMaps
 * with their information.
 * @author jannik stroetgen
 *
 */
public class RePatternManager extends GenericResourceManager {
	private static RePatternManager INSTANCE = null;
	
	// STORE PATTERNS AND NORMALIZATIONS
	private TreeMap<String, String> hmAllRePattern;

	/**
	 * Constructor calls the parent constructor that sets language/resource
	 * parameters and collects resource repatterns.
	 * @param language
	 */
	private RePatternManager(String language, String resourceDir) {
		// calls the Generic constructor with repattern parameter
		super("repattern");
		// initialize the member map of all repatterns
		hmAllRePattern = new TreeMap<String, String>();
		//////////////////////////////////////////////////////
		// READ PATTERN RESOURCES FROM FILES AND STORE THEM //
		//////////////////////////////////////////////////////
		HashMap<String, String> hmResourcesRePattern = readResourcesFromDirectory();
		for (String which : hmResourcesRePattern.keySet()) {
			hmAllRePattern.put(which, "");
		}
		readRePatternResources(hmResourcesRePattern);
	}

	/**
	 * singleton producer.
	 * @return singleton instance of RePatternManager
	 */
	public static RePatternManager getInstance() {
		if(RePatternManager.INSTANCE == null)
			RePatternManager.INSTANCE = new RePatternManager(REPORTFORMAT, RESOURCEDIR);
		
		return RePatternManager.INSTANCE;
	}
	
	
	/**
	 * READ THE REPATTERN FROM THE FILES. The files have to be defined in the HashMap hmResourcesRePattern.
	 * @param hmResourcesRePattern RePattern resources to be interpreted
	 */
	private void readRePatternResources(HashMap<String, String> hmResourcesRePattern) {
		
		//////////////////////////////////////
		// READ REGULAR EXPRESSION PATTERNS //
		//////////////////////////////////////
		try {
			for (String resource : hmResourcesRePattern.keySet()) {
				Logger.printDetail(component, "Adding pattern resource: "+resource);
				// create a buffered reader for every repattern resource file
				Scanner sc = new Scanner(new File(hmResourcesRePattern.get(resource)));
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					System.out.println(line);
					if (!line.startsWith("//")) {
						boolean correctLine = false;
						if (!(line.equals(""))) {
							correctLine = true;
							for (String which : hmAllRePattern.keySet()) {
								if (resource.equals(which)) {
									String devPattern = hmAllRePattern.get(which);
									devPattern = devPattern + "|" + line;
									hmAllRePattern.put(which, devPattern);
								}
							}
						}
						if ((correctLine == false) && (!(line.matches("")))) {
							Logger.printError(component, "Cannot read one of the lines of pattern resource "+resource);
							Logger.printError(component, "Line: "+line);
						}
					}
				}
			}
			////////////////////////////
			// FINALIZE THE REPATTERN //
			////////////////////////////
			for (String which : hmAllRePattern.keySet()) {
				finalizeRePattern(which, hmAllRePattern.get(which));
				System.out.println(which+":"+hmAllRePattern.get(which));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pattern containing regular expression is finalized, i.e., created correctly and added to hmAllRePattern.
	 * @param name key name
	 * @param rePattern repattern value
	 */
	private void finalizeRePattern(String name, String rePattern) {
		// create correct regular expression
		rePattern = rePattern.replaceFirst("\\|", "");
		/* this was added to reduce the danger of getting unusable groups from user-made repattern
		 * files with group-producing parentheses (i.e. "(foo|bar)" while matching against the documents. */
		rePattern = rePattern.replaceAll("\\(([^\\?])", "(?:$1");
		rePattern = "(" + rePattern + ")";
		rePattern = rePattern.replaceAll("\\\\", "\\\\\\\\");
		// add rePattern to hmAllRePattern
		hmAllRePattern.put(name, rePattern);
	}
	
	/**
	 * proxy method to access the hmAllRePattern member
	 * @param key key to check for
	 * @return whether the map contains the key
	 */
	public Boolean containsKey(String key) {
		return hmAllRePattern.containsKey(key);
	}

	/**
	 * proxy method to access the hmAllRePattern member
	 * @param key Key to retrieve data from
	 * @return String from the map
	 */
	public String get(String key) {
		return hmAllRePattern.get(key);
	}

}

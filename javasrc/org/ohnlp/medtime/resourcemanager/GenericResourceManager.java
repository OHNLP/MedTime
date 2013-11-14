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
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import org.ohnlp.medtime.util.Logger;
import org.ohnlp.medtime.util.Toolbox;
/**
 * 
 * Abstract class for all Resource Managers to inherit from. Contains basic
 * functionality such as file system access and some private members.
 *
 */
public abstract class GenericResourceManager {
	// language for the utilized resources
	public static String REPORTFORMAT;
	public static String RESOURCEDIR;
	// kind of resource -- e.g. repattern, normalization, rules
	protected String resourceType;
	// local package for logging output
	protected Class<?> component;
	
	/**
	 * Instantiates the Resource Manager with a resource type
	 * @param resourceType kind of resource to represent
	 */
	protected GenericResourceManager(String resourceType) {
		this.resourceType = resourceType;
		this.component = this.getClass();
	}

	/**
	 * Reads resource files of the type resourceType from the "used_resources.txt" file and returns a HashMap
	 * containing information to access these resources.
	 * @return HashMap containing filename/path tuples
	 */
	protected HashMap<String, String> readResourcesFromDirectory() {

		HashMap<String, String> hmResources = new HashMap<String, String>();
		
		try{
			String resourcefile=RESOURCEDIR+"/used_resources.txt";
			Scanner sc = new Scanner(new File(resourcefile));
	 		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			Pattern paResource = Pattern.compile(REPORTFORMAT+"/"+resourceType+"/resources_"+resourceType+"_"+"(.*?)\\.txt");
			for (Object r : Toolbox.findMatches(paResource, line)){
					MatchResult ro=(MatchResult) r;
					String foundResource  = ro.group(1);
					String pathToResource = RESOURCEDIR+"/"+REPORTFORMAT+"/"+resourceType+"/resources_"+resourceType+"_"+foundResource+".txt";
					System.out.println(pathToResource);
					
					hmResources.put(foundResource, pathToResource);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			Logger.printError(component, "Failed to read a resource from used_resources.txt.");
			System.exit(-1);
		}
		return hmResources;
	}

}

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

import java.util.ArrayList;

import org.apache.uima.jcas.JCas;

import org.ohnlp.medtime.ae.GenericProcessor;
import org.ohnlp.medtime.util.Logger;
/**
 * This class implements a singleton "Addon Manager". Any subroutine (Processor) that
 * may be added to MedTime's code to achieve a specific goal which is self-sufficient,
 * i.e. creates new Timexes by itself and without the use of MedTime's non-resource
 * related functionality should be registered in an instance of this class. HeidelTime's
 * annotator will then execute every registered "Processor"'s process() function.
 * Note that these Processes will be instantiated and processed after the resource
 * collection and before HeidelTime's cleanup methods. Adapted from HeidelTime.
 * 
 * @author Hongfang Liu & Sunghwan Sohn
 *
 */
public class ProcessorManager {
	// singleton instance
	private static final ProcessorManager INSTANCE = new ProcessorManager();
	// list of processes' package names
	private ArrayList<String> processors;
	// self-identifying component for logging purposes
	private Class<?> component; 
	
	/**
	 * Private constructor, only to be called by the getInstance() method.
	 */
	private ProcessorManager() {
		this.processors = new ArrayList<String>();
		this.component = this.getClass();
	}
	
	/**
	 * method to register a processor
	 * @param processor processor to be registered in the processormanager's list
	 */
	public void registerProcessor(String processor) {
		this.processors.add(processor);
	}
	
	/**
	 * Based on reflection, this method instantiates and executes all of the
	 * registered Processors.
	 * @param jcas
	 */
	public void executeAllProcessors(JCas jcas) {
		for(String s : processors) {
			try {
				Class<?> c = Class.forName(s);
				GenericProcessor p = (GenericProcessor) c.newInstance();
				p.process(jcas);
			} catch (Exception e) {
				e.printStackTrace();
				Logger.printError(component, "Unable to instantiate registered Processor "+s);
				System.exit(-1);
			}
		}
	}
	
	/**
	 * getInstance method of the singleton pattern
	 * @return ProcessorManager
	 */
	public static ProcessorManager getInstance() {
		return ProcessorManager.INSTANCE;
	}
}

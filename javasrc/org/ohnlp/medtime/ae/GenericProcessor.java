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

import org.apache.uima.jcas.JCas;

/**
 * 
 * Abstract class to for all Processors to inherit from. A processor is a
 * modular, self-sufficient piece of code that was added to
 * fulfill a specific function. Adapted from Heideltime.
 *
 * @author Hongfang Liu & Sunghwan Sohn
 * 
 */

public abstract class GenericProcessor {
	protected Package component;
	
	/**
	 * Constructor that sets the component for logger use.
	 * Any inheriting class should run this via super()
	 */
	public GenericProcessor() {
		this.component = this.getClass().getPackage();
	}
	
	/**
	 * starts the processing of the processor.
	 * @param jcas
	 */
	public abstract void process(JCas jcas);
}

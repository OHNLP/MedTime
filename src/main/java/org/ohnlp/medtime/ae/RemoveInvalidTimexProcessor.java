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
import java.util.HashSet;
import java.util.List;


import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import org.ohnlp.medtime.util.Logger;
import org.ohnlp.medtime.type.MedTimex3;

/**
 * MedTime finds temporal expressions and normalizes them according to the
 * TIMEX3 TimeML annotation standard. Adapted from HeidelTime
 * 
 * @author Hongfang Liu
 * 
 */
public class RemoveInvalidTimexProcessor extends GenericProcessor {

	private int GOODDIS = 12;

	public RemoveInvalidTimexProcessor() {
		super();
	}

	public void process(JCas jcas) {

		FSIterator<? extends Annotation> iterTimex = jcas.getAnnotationIndex(MedTimex3.type).iterator();
		List<MedTimex3> linearDates = new ArrayList<MedTimex3>();

		while (iterTimex.hasNext()) {
			MedTimex3 timex = (MedTimex3) iterTimex.next();
			if (timex.getTimexType().equals("DATE")
					|| timex.getTimexType().equals("TIME")) {
				linearDates.add(timex);
			}
		}
		int size = linearDates.size();
		for (int i = 0; i < size; i++) {
			MedTimex3 timex = (MedTimex3) linearDates.get(i);
			boolean remove = false;
			if (timex.getTimexType().equals("TIME")
					&& timex.getFoundByRule().indexOf("time_r7a") >= 0){
				MedTimex3 timex_b=null;
				MedTimex3 timex_a=null;
				 
				if(i>0) timex_b= (MedTimex3) linearDates.get(i-1);
				if(i<size-1) timex_a= (MedTimex3) linearDates.get(i+1);
				if(! (timex_b!=null && timex_b.getTimexType().equals("DATE")&& timex.getBegin()-timex_b.getEnd() < GOODDIS-7 ||
						timex_a!=null && timex_a.getTimexType().equals("DATE") && timex_a.getBegin()-timex.getEnd() < GOODDIS-7))
					remove = true;
			}
				
				if (timex.getTimexType().equals("DATE")) {
				// Remove Section Header
				if (timex.getCoveredText().toLowerCase().equals(
						"discharge date")
						&& timex.getContextSentence().getSegment().getValue().startsWith("date_of_discharge")
						|| timex.getCoveredText().toLowerCase().equals(
								"admission date")
						&& timex.getContextSentence().getSegment().getValue().startsWith("date_of_admission"))
					remove = true;
			}
								
			if(remove){
				timex.removeFromIndexes(jcas);
				timex.setTimexValue("REMOVE");
				timex.addToIndexes(jcas);
			}
		}

			FSIterator<? extends Annotation> timexIter1 = jcas.getAnnotationIndex(MedTimex3.type).iterator();
			HashSet<MedTimex3> hsTimexesToRemove = new HashSet<MedTimex3>();

			while (timexIter1.hasNext()) {
				MedTimex3 t1 = (MedTimex3) timexIter1.next();
				if(t1.getTimexValue().equals("REMOVE")) hsTimexesToRemove.add(t1);
			}
			// remove, finally
			for (MedTimex3 t : hsTimexesToRemove) {
				Logger.printDetail(t.getTimexId() + "REMOVE DUPLICATE: "
						+ t.getCoveredText() + "(id:" + t.getTimexId() + " value:"
						+ t.getTimexValue() + " found by:" + t.getFoundByRule()
						+ ")");
				t.removeFromIndexes(jcas);
			}
	}
 }


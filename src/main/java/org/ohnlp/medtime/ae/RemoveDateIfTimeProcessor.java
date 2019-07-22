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
import java.util.List;

import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import org.ohnlp.medtime.util.Logger;
import org.ohnlp.medtime.type.MedTimex3;

/**
 * MedTime finds temporal expressions and normalizes them according to the
 * TIMEX3 TimeML annotation standard. Adapted from HeidelTime.
 * 
 * @author Hongfang Liu & Sunghwan Sohn
 * 
 */
public class RemoveDateIfTimeProcessor extends GenericProcessor {

	public RemoveDateIfTimeProcessor() {
		super();
	}
	
	public void process(JCas jcas) {
		List<MedTimex3> linearDates = new ArrayList<MedTimex3>();

		FSIterator<? extends Annotation> iterTimex = jcas.getAnnotationIndex(MedTimex3.type).iterator();

		while (iterTimex.hasNext()) {
			MedTimex3 timex = (MedTimex3) iterTimex.next();
			if (timex.getTimexType().equals("DATE")
					|| timex.getTimexType().equals("TIME")) {
				linearDates.add(timex);
			}
		}
		for (int i = 1; i < linearDates.size(); i++) {
			MedTimex3 t_i = (MedTimex3) linearDates.get(i);
			MedTimex3 t_previous = (MedTimex3) linearDates.get(i - 1);
			if (t_i.getTimexType().equals("TIME")
					&& t_previous.getTimexType().equals("DATE")
					&& t_i.getContextSentence().getId() == t_previous
							.getContextSentence().getId()
					&& t_i.getBegin() - t_previous.getEnd() < GOODDIS
					&& t_i.getTimexValue().indexOf(t_previous.getTimexValue()) >= 0) {
				t_previous.removeFromIndexes();
				t_i.removeFromIndexes();
				t_i.setBegin(t_previous.getBegin());
				t_i.addToIndexes();
				linearDates.set(i - 1, t_i);
				Logger.printDetail(t_previous.getTimexId()
						+ " REMOVING PHASE: " + "found by:"
						+ t_previous.getFoundByRule() + " text:"
						+ t_previous.getCoveredText() + " value:"
						+ t_previous.getTimexValue());
			}
		}
		for (int i = 0; i < linearDates.size() - 1; i++) {
			MedTimex3 t_i = (MedTimex3) linearDates.get(i);
			MedTimex3 t_after = (MedTimex3) linearDates.get(i + 1);
			if (t_i.getTimexType().equals("TIME")
					&& t_after.getTimexType().equals("DATE")
					&& t_i.getContextSentence().getId() == t_after
							.getContextSentence().getId()
					&& t_i.getEnd() - t_after.getBegin() < GOODDIS
					&& t_i.getTimexValue().indexOf(t_after.getTimexValue()) >= 0) {
				t_after.removeFromIndexes();
				t_i.removeFromIndexes();
				t_i.setEnd(t_after.getEnd());
				t_i.addToIndexes();
				linearDates.set(i, t_i);
				Logger.printDetail(t_after.getTimexId() + " REMOVING PHASE: "
						+ "found by:" + t_after.getFoundByRule() + " text:"
						+ t_after.getCoveredText() + " value:"
						+ t_after.getTimexValue());
			}
		}
	}

	private int GOODDIS = 12; // if the date and time are not away from each
								// other over GOODDIS, merge them into one entry
}

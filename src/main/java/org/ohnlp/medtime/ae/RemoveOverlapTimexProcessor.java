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

import java.util.HashSet;

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
public class RemoveOverlapTimexProcessor extends GenericProcessor {
	
	public RemoveOverlapTimexProcessor() {
		super();
	}
	public void process(JCas jcas) {

		FSIterator<? extends Annotation> timexIter1 = jcas.getAnnotationIndex(MedTimex3.type).iterator();
		HashSet<MedTimex3> hsTimexesToRemove = new HashSet<MedTimex3>();

		while (timexIter1.hasNext()) {
			MedTimex3 t1 = (MedTimex3) timexIter1.next();
			FSIterator<? extends Annotation> timexIter2 = jcas.getAnnotationIndex(MedTimex3.type).iterator();

			while (timexIter2.hasNext()) {
				MedTimex3 t2 = (MedTimex3) timexIter2.next();
				if (((t1.getBegin() >= t2.getBegin()) && (t1.getEnd() < t2
						.getEnd())) // t1 starts inside or with t2 and ends before t2 -> remove t1
						|| ((t1.getBegin() > t2.getBegin()) && (t1.getEnd() <= t2
								.getEnd()))) { // t1 starts inside t2 and ends with or before t2 -> remove t1
					hsTimexesToRemove.add(t1);
				} else if (((t2.getBegin() >= t1.getBegin()) && (t2.getEnd() < t1
						.getEnd()))
						|| // t2 starts inside or with t1 and ends before t1 -> remove t2
						((t2.getBegin() > t1.getBegin()) && (t2.getEnd() <= t1
								.getEnd()))) { // t2 starts inside t1 and ends with or before t1 -> remove t2
					hsTimexesToRemove.add(t2);
				}
				// identical length
				if ((t1.getBegin() == t2.getBegin())
						&& (t1.getEnd() == t2.getEnd())) {
					if ((t1.getTimexType().equals("SET"))
							|| (t2.getTimexType().equals("SET"))) {
						// REMOVE REAL DUPLICATES (the one with the lower
						// timexID)
						if ((Integer.parseInt(t1.getTimexId().substring(1)) < Integer
								.parseInt(t2.getTimexId().substring(1)))) {
							hsTimexesToRemove.add(t1);
						}
					} else {
						if (!(t1.equals(t2))) {
							if ((t1.getTimexValue().startsWith("UNDEF"))
									&& (!(t2.getTimexValue()
											.startsWith("UNDEF")))) {
								hsTimexesToRemove.add(t1);
							} else if ((!(t1.getTimexValue()
									.startsWith("UNDEF")))
									&& (t2.getTimexValue().startsWith("UNDEF"))) {
								hsTimexesToRemove.add(t2);
							}
							// t1 is explicit, but t2 is not
							else if ((t1.getFoundByRule().endsWith("explicit"))
									&& (!(t2.getFoundByRule()
											.endsWith("explicit")))) {
								hsTimexesToRemove.add(t2);
							}
							// REMOVE REAL DUPLICATES (the one with the lower
							// timexID)
							else if ((Integer.parseInt(t1.getTimexId()
									.substring(1)) < Integer.parseInt(t2
									.getTimexId().substring(1)))) {
								hsTimexesToRemove.add(t1);
							}
						}
					}
				}
			}
		}
		// remove, finally
		for (MedTimex3 t : hsTimexesToRemove) {
			Logger.printDetail(t.getTimexId() + "REMOVE DUPLICATE: "
					+ t.getCoveredText() + "(id:" + t.getTimexId() + " value:"
					+ t.getTimexValue() + " found by:" + t.getFoundByRule()
					+ ")");

			t.removeFromIndexes();
		}
	}
}

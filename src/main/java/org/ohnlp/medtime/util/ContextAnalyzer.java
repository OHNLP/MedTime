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

import java.util.List;
import java.util.TreeMap;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import org.ohnlp.medtime.resourcemanager.NormalizationManager;
import org.ohnlp.medtime.resourcemanager.RePatternManager;
import org.ohnlp.typesystem.type.textspan.Sentence;
import org.ohnlp.medtime.type.MedTimex3;
import org.ohnlp.typesystem.type.syntax.BaseToken;

/**
 * 
 * This class contains methods that work with the dependence of a subject with its
 * surrounding data; namely via the jcas element or a subset list.
 * @author Hongfang Liu
 *
 */
public class ContextAnalyzer {
	// local reference to the normalization manager
	private final static NormalizationManager nm = NormalizationManager.getInstance();
	
	/**
	 * The value of the x of the last mentioned Timex is calculated.
	 * @param linearDates list of previous linear dates
	 * @param i index for the previous date entry
	 * @param x type to search for
	 * @return last mentioned entry
	 */
	public static String getLastMentionedX(List<MedTimex3> linearDates, int i, String x) {
		
		// Timex for which to get the last mentioned x (i.e., Timex i)
		MedTimex3 t_i = linearDates.get(i);
		
		String xValue = "";
		int j = i - 1;
		while (j >= 0) {
			MedTimex3 timex = linearDates.get(j);
			// check that the two timexes to compare do not have the same offset:
				if (!(t_i.getBegin() == timex.getBegin())) {
				
					String value = timex.getTimexValue();
					if (!(value.contains("funcDate"))){
						if (x.equals("century")) {
							if (value.matches("^[0-9][0-9]...*")) {
								xValue = value.substring(0,2);
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("decade")) {
							if (value.matches("^[0-9][0-9][0-9]..*")) {
								xValue = value.substring(0,3);
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("year")) {
							if (value.matches("^[0-9][0-9][0-9][0-9].*")) {
								xValue = value.substring(0,4);
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("dateYear")) {
							if (value.matches("^[0-9][0-9][0-9][0-9].*")) {
								xValue = value;
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("month")) {
							if (value.matches("^[0-9][0-9][0-9][0-9]-[0-9][0-9].*")) {
								xValue = value.substring(0,7);
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("day")) {
							if (value.matches("^[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9].*")) {
								xValue = value.substring(0,10);
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("week")) {
							if (value.matches("^[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9].*")) {
								for (MatchResult r : Toolbox.findMatches(Pattern.compile("^(([0-9][0-9][0-9][0-9])-[0-9][0-9]-[0-9][0-9]).*"), value)) {
									xValue = r.group(2)+"-W"+DateCalculator.getWeekOfDate(r.group(1));
									break;
								}
								break;
							}
							else if (value.matches("^[0-9][0-9][0-9][0-9]-W[0-9][0-9].*")) {
								for (MatchResult r : Toolbox.findMatches(Pattern.compile("^([0-9][0-9][0-9][0-9]-W[0-9][0-9]).*"), value)) {
									xValue = r.group(1);
									break;
								}
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("quarter")) {
							if (value.matches("^[0-9][0-9][0-9][0-9]-[0-9][0-9].*")) {
								String month   = value.substring(5,7);
								String quarter = nm.getFromNormMonthInQuarter(month);
								xValue = value.substring(0,4)+"-Q"+quarter;
								break;
							}
							else if (value.matches("^[0-9][0-9][0-9][0-9]-Q[1234].*")) {
								xValue = value.substring(0,7);
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("dateQuarter")) {
							if (value.matches("^[0-9][0-9][0-9][0-9]-Q[1234].*")) {
								xValue = value.substring(0,7);
								break;
							}
							else {
								j--;
							}
						}
						else if (x.equals("season")) {
							if (value.matches("^[0-9][0-9][0-9][0-9]-[0-9][0-9].*")) {
								String month   = value.substring(5,7);
								String season = nm.getFromNormMonthInSeason(month);
								xValue = value.substring(0,4)+"-"+season;
								break;
							}
							else if (value.matches("^[0-9][0-9][0-9][0-9]-(SP|SU|FA|WI).*")) {
								xValue = value.substring(0,7);
								break;
							}
							else {
								j--;
							}
						}
						
					}
					else {
						j--;
					}
				}
		}
		return xValue;
	}
	
	/**
	 * Get the last tense used in the sentence
	 * 
	 * @param timex timex construct to discover tense data for
	 * @return string that contains the tense
	 */
	public static String getClosestTense(MedTimex3 timex, JCas jcas) {
		RePatternManager rpm = RePatternManager.getInstance();
		
		String lastTense = "";
		String nextTense = "";
		
		int tokenCounter = 0;
		int lastid = 0;
		int nextid = 0;
		int tid    = 0;

		// Get the sentence
		FSIterator<? extends Annotation> iterSentence = jcas.getAnnotationIndex(Sentence.type).iterator();
		Sentence s = new Sentence(jcas);
		while (iterSentence.hasNext()) {
			s = (Sentence) iterSentence.next();
			if ((s.getBegin() < timex.getBegin())
					&& (s.getEnd() > timex.getEnd())) {
				break;
			}
		}

		// Get the tokens
		TreeMap<Integer, BaseToken> tmToken = new TreeMap<Integer, BaseToken>();
		FSIterator<? extends Annotation> iterToken = jcas.getAnnotationIndex(BaseToken.type).subiterator(s);
		while (iterToken.hasNext()) {
			BaseToken token = (BaseToken) iterToken.next();
			tmToken.put(token.getEnd(), token);
		}
		
		// Get the last VERB token
		for (Integer tokEnd : tmToken.keySet()) {
			tokenCounter++;
			if (tokEnd < timex.getBegin()) {
				BaseToken token = tmToken.get(tokEnd);
				
				Logger.printDetail("GET LAST TENSE: string:"+token.getCoveredText()+" pos:"+token.getPartOfSpeech());
				Logger.printDetail("hmAllRePattern.containsKey(tensePos4PresentFuture):"+rpm.get("tensePos4PresentFuture"));
				Logger.printDetail("hmAllRePattern.containsKey(tensePos4Future):"+rpm.get("tensePos4Future"));
				Logger.printDetail("hmAllRePattern.containsKey(tensePos4Past):"+rpm.get("tensePos4Past"));
				Logger.printDetail("CHECK TOKEN:"+token.getPartOfSpeech());
				
				if (token.getPartOfSpeech()== null) {
					
				}
				else if ((rpm.containsKey("tensePos4PresentFuture")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4PresentFuture")))) {
					lastTense = "PRESENTFUTURE";
					lastid = tokenCounter; 
				}
				else if ((rpm.containsKey("tensePos4Past")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4Past")))) {
					lastTense = "PAST";
					lastid = tokenCounter;
				}
				else if ((rpm.containsKey("tensePos4Future")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4Future")))) {
					if (token.getCoveredText().matches(rpm.get("tenseWord4Future"))) {
						lastTense = "FUTURE";
						lastid = tokenCounter;
					}
				}
			}
			else {
				if (tid == 0) {
					tid = tokenCounter;
				}
			}
		}
		tokenCounter = 0;
		for (Integer tokEnd : tmToken.keySet()) {
			tokenCounter++;
			if (nextTense.equals("")) {
				if (tokEnd > timex.getEnd()) {
					BaseToken token = tmToken.get(tokEnd);
					
					Logger.printDetail("GET NEXT TENSE: string:"+token.getCoveredText()+" pos:"+token.getPartOfSpeech());
					Logger.printDetail("hmAllRePattern.containsKey(tensePos4PresentFuture):"+rpm.get("tensePos4PresentFuture"));
					Logger.printDetail("hmAllRePattern.containsKey(tensePos4Future):"+rpm.get("tensePos4Future"));
					Logger.printDetail("hmAllRePattern.containsKey(tensePos4Past):"+rpm.get("tensePos4Past"));
					Logger.printDetail("CHECK TOKEN:"+token.getPartOfSpeech());
					
					if (token.getPartOfSpeech() == null) {
						
					}
					else if ((rpm.containsKey("tensePos4PresentFuture")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4PresentFuture")))) {
						nextTense = "PRESENTFUTURE";
						nextid = tokenCounter;
					}
					else if ((rpm.containsKey("tensePos4Past")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4Past")))) {
						nextTense = "PAST";
						nextid = tokenCounter;
					}
					else if ((rpm.containsKey("tensePos4Future")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4Future")))) {
						if (token.getCoveredText().matches(rpm.get("tenseWord4Future"))) {
							nextTense = "FUTURE";
							nextid = tokenCounter;
						}
					}
				}
			}
		}
		if (lastTense.equals("")) {
			Logger.printDetail("TENSE: "+nextTense);
			return nextTense;
		}
		else if (nextTense.equals("")) {
			Logger.printDetail("TENSE: "+lastTense);
			return lastTense;
		}
		else {
			// If there is tense before and after the timex token, 
			// return the closer one:
			if ((tid - lastid) > (nextid - tid)) {
				Logger.printDetail("TENSE: "+nextTense);
				return nextTense;
			}
			else {
				Logger.printDetail("TENSE: "+lastTense);
				return lastTense;	
			}	
		}
	}
	
	
	/**
	 * Get the last tense used in the sentence
	 * 
	 * @param timex timex construct to discover tense data for
	 * @return string that contains the tense
	 */
	public static String getLastTense(MedTimex3 timex, JCas jcas) {
		RePatternManager rpm = RePatternManager.getInstance();
		
		String lastTense = "";

		// Get the sentence
		FSIterator<? extends Annotation> iterSentence = jcas.getAnnotationIndex(Sentence.type).iterator();
		Sentence s = new Sentence(jcas);
		while (iterSentence.hasNext()) {
			s = (Sentence) iterSentence.next();
			if ((s.getBegin() < timex.getBegin())
					&& (s.getEnd() > timex.getEnd())) {
				break;
			}
		}

		// Get the tokens
		TreeMap<Integer, BaseToken> tmToken = new TreeMap<Integer, BaseToken>();
		FSIterator<? extends Annotation> iterToken = jcas.getAnnotationIndex(BaseToken.type).subiterator(s);
		while (iterToken.hasNext()) {
			BaseToken token= (BaseToken) iterToken.next();
			tmToken.put(token.getEnd(), token);
		}

		// Get the last VERB token
		for (Integer tokEnd : tmToken.keySet()) {
			if (tokEnd < timex.getBegin()) {
				BaseToken token= tmToken.get(tokEnd);
				
				Logger.printDetail("GET LAST TENSE: string:"+token.getCoveredText()+" pos:"+token.getPartOfSpeech());
				Logger.printDetail("hmAllRePattern.containsKey(tensePos4PresentFuture):"+rpm.get("tensePos4PresentFuture"));
				Logger.printDetail("hmAllRePattern.containsKey(tensePos4Future):"+rpm.get("tensePos4Future"));
				Logger.printDetail("hmAllRePattern.containsKey(tensePos4Past):"+rpm.get("tensePos4Past"));
				Logger.printDetail("CHECK TOKEN:"+token.getPartOfSpeech());
				
				if (token.getPartOfSpeech() == null) {
					
				}
				else if ((rpm.containsKey("tensePos4PresentFuture")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4PresentFuture")))) {
					lastTense = "PRESENTFUTURE";
				}
				else if ((rpm.containsKey("tensePos4Past")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4Past")))) {
					lastTense = "PAST";
				}
				else if ((rpm.containsKey("tensePos4Future")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4Future")))) {
					if (token.getCoveredText().matches(rpm.get("tenseWord4Future"))) {
						lastTense = "FUTURE";
					}
				}
				if (token.getCoveredText().equals("since")) {
					lastTense = "PAST";
				}
			}
			if (lastTense.equals("")) {
				if (tokEnd > timex.getEnd()) {
					BaseToken token= tmToken.get(tokEnd);
					
					Logger.printDetail("GET NEXT TENSE: string:"+token.getCoveredText()+" pos:"+token.getPartOfSpeech());
					Logger.printDetail("hmAllRePattern.containsKey(tensePos4PresentFuture):"+rpm.get("tensePos4PresentFuture"));
					Logger.printDetail("hmAllRePattern.containsKey(tensePos4Future):"+rpm.get("tensePos4Future"));
					Logger.printDetail("hmAllRePattern.containsKey(tensePos4Past):"+rpm.get("tensePos4Past"));
					Logger.printDetail("CHECK TOKEN:"+token.getPartOfSpeech());
					
					if (token.getPartOfSpeech() == null) {
						
					}
					else if ((rpm.containsKey("tensePos4PresentFuture")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4PresentFuture")))) {
						lastTense = "PRESENTFUTURE";
					}
					else if ((rpm.containsKey("tensePos4Past")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4Past")))) {
						lastTense = "PAST";
					}
					else if ((rpm.containsKey("tensePos4Future")) && (token.getPartOfSpeech().matches(rpm.get("tensePos4Future")))) {
						if (token.getCoveredText().matches(rpm.get("tenseWord4Future"))) {
							lastTense = "FUTURE";
						}
					}
				}
			}
		}
		//Hongfang needs to check.
		// VHZ VNN and VHZ VNN and VHP VNN and VBP VVN
		String prevPos = "";
		String longTense = "";
		if (lastTense.equals("PRESENTFUTURE")) {
			for (Integer tokEnd : tmToken.keySet()) { 
				if (tokEnd < timex.getBegin()) {
					BaseToken token= tmToken.get(tokEnd);
					if ((prevPos.equals("VHZ")) || (prevPos.equals("VBZ")) || (prevPos.equals("VHP")) || (prevPos.equals("VBP"))) {
						if (token.getPartOfSpeech().equals("VVN")) {
							if ((!(token.getCoveredText().equals("expected"))) && (!(token.getCoveredText().equals("scheduled")))) {
								lastTense = "PAST";
								longTense = "PAST";
							}
						}
					}
					prevPos = token.getPartOfSpeech();
				}
				if (longTense.equals("")) {
					if (tokEnd > timex.getEnd()) {
						BaseToken token= tmToken.get(tokEnd);
						if ((prevPos.equals("VHZ")) || (prevPos.equals("VBZ")) || (prevPos.equals("VHP")) || (prevPos.equals("VBP"))) {
							if (token.getPartOfSpeech().equals("VVN")) {
								if ((!(token.getCoveredText().equals("expected"))) && (!(token.getCoveredText().equals("scheduled")))) {
									lastTense = "PAST";
									longTense = "PAST";
								}
							}
						}
						prevPos = token.getPartOfSpeech();
					}
				}
			}
		}
		Logger.printDetail("TENSE: "+lastTense);
		
		return lastTense;
	}
	
	/**
	 * Check Tokenboundaries of expressions.
	 * @param r MatchResult 
	 * @param s Respective sentence
	 * @return whether or not the MatchResult is a clean one
	 */
	public static Boolean checkInfrontBehind(MatchResult r, Sentence s) {
		Boolean ok = true;
		
		// get rid of expressions such as "1999" in 53453.1999
		if (r.start() > 1) {
			if ((s.getCoveredText().substring(r.start() - 2, r.start()).matches("\\d\\."))){
				ok = false;
			}
		}
		
		// get rid of expressions if there is a character or symbol ($+) directly in front of the expression
		if (r.start() > 0) {
			if (((s.getCoveredText().substring(r.start() - 1, r.start()).matches("[\\w\\$\\+]"))) &&
					(!(s.getCoveredText().substring(r.start() - 1, r.start()).matches("\\(")))){
				ok = false;
			}
		}
		
		if (r.end() < s.getCoveredText().length()) {
			if ((s.getCoveredText().substring(r.end(), r.end() + 1).matches("[°\\w]")) &&
					(!(s.getCoveredText().substring(r.end(), r.end() + 1).matches("\\)")))){
				ok = false;
			}
			if (r.end() + 1 < s.getCoveredText().length()) {
				if (s.getCoveredText().substring(r.end(), r.end() + 2).matches(
						"[\\.,]\\d")) {
					ok = false;
				}
			}
		}
		return ok;
	}
}

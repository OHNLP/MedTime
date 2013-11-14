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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * Adapted from HeidelTime
 * 
 * @author hongfangliu
 *
 */
public class Toolbox {
	/**
	 * Find all the matches of a pattern in a charSequence and return the
	 * results as list.
	 * 
	 * @param pattern Pattern to be matched
	 * @param s String to be matched against
	 * @return Iterable List of MatchResults
	 */
	public static Iterable<MatchResult> findMatches(Pattern pattern, CharSequence s) {
		List<MatchResult> results = new ArrayList<MatchResult>();

		for (Matcher m = pattern.matcher(s); m.find();)
			results.add(m.toMatchResult());

		return results;
	}

	/**
	 * Sorts a given HashMap using a custom function
	 * @param m Map of items to sort
	 * @return sorted List of items
	 */
    public static List<Pattern> sortByValue(final HashMap<Pattern,String> m) {
        List<Pattern> keys = new ArrayList<Pattern>();
        keys.addAll(m.keySet());
        Collections.sort(keys, new Comparator<Object>() {
        	@SuppressWarnings("unchecked")
			public int compare(Object o1, Object o2) {
                Object v1 = m.get(o1);
                Object v2 = m.get(o2);
                if (v1 == null) {
                    return (v2 == null) ? 0 : 1;
                } else if (v1 instanceof Comparable) {
                    return ((Comparable) v1).compareTo(v2);
                } else {
                    return 0;
                }
            }
        });
        return keys;
    }
    
 public static String removeTrailingZeros(java.lang.String str) {
		if (str == null)
			return null;
		char[] chars = str.toCharArray();
		int length, index;
		length = str.length();
		index = length - 1;

		for (; index >= 0; index--) {
			if (chars[index] != '0')
				break;
		}

		String ret = (index == length - 1) ? str : str.substring(0, index + 1);
		if (ret.endsWith("."))
			ret = ret.substring(0, ret.length() - 1);

		return ret;
	}
 /**
	 * Durations of a finer granularity are mapped to a coarser one if possible,
	 * e.g., "PT24H" -> "P1D". One may add several further corrections.
	 * 
	 * @param value
	 * @return
	 */
	public static String correctDurationValue(String value) {
		if (value.matches("PT[0-9]+H")) {
			for (Object mr : Toolbox.findMatches(Pattern
					.compile("PT([0-9]+)H"), value)) {
				int hours = Integer.parseInt(((MatchResult) mr).group(1));
				if ((hours % 24) == 0) {
					int days = hours / 24;
					value = "P" + days + "D";
				}
			}
		} else if (value.matches("PT[0-9]+M")) {
			for (Object mr : Toolbox.findMatches(Pattern
					.compile("PT([0-9]+)M"), value)) {
				int minutes = Integer.parseInt(((MatchResult) mr).group(1));
				if ((minutes % 60) == 0) {
					int hours = minutes / 60;
					value = "PT" + hours + "H";
				}
			}
		} else if (value.matches("P[0-9]+M")) {
			for (Object mr : Toolbox.findMatches(Pattern
					.compile("P([0-9]+)M"), value)) {
				int months = Integer.parseInt(((MatchResult) mr).group(1));
				if ((months % 12) == 0) {
					int years = months / 12;
					value = "P" + years + "Y";
				}
			}
		}
		return value;
	}

}

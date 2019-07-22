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
package org.ohnlp.medtime.cc;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JFSIndexRepository;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.ohnlp.typesystem.type.structured.Document;
import org.ohnlp.medtime.type.MedTimex3;


/**
 * 
 * Generate i2b2 Timex3 output format
 * Adapted from HeidelTime
 * @author Sunghwan Sohn & Hongfang Liu
 *
 */
public class MedTimeWriter extends CasConsumer_ImplBase {

	public static final String PARAM_OUTPUTDIR = "OutputDir";

	private File mOutputDir;
 
	private int mDocNum;
	
	private boolean printDetails = false;

	/**
	 * initialize
	 */
	public void initialize() throws ResourceInitializationException {
    
		mDocNum = 0;
		mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
		if (!mOutputDir.exists()) {
			mOutputDir.mkdirs();
		} 
	}


	/**
	 * process
	 */
	public void processCas(CAS aCAS) throws ResourceProcessException {

		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new ResourceProcessException(e);
		}

		printTimexAnnotationsInline(jcas);
	}
	
	
	public void printTimexAnnotationsInline(JCas jcas){
			
	JFSIndexRepository indexes = jcas.getJFSIndexRepository();
 	FSIterator<TOP> docIterator = indexes.getAllIndexedFS(Document.type);
	 File outFile = null;
	    File inFile = null;
	  if (docIterator.hasNext()) {
   	Document docAnn = (Document) docIterator.next();
	    String fileLoc =docAnn.getFileLoc(); 
     try {
       inFile = new File(new URL(fileLoc).getPath());
       String outFileName = inFile.getName();
       outFile = new File(mOutputDir, outFileName+".ann");
     } catch (MalformedURLException e1) {
      }
   }
   if (outFile == null) {
     outFile = new File(mOutputDir, "doc" + mDocNum++);
   }
   
	   
	    String toprint = "";
	    
	    // document text
	    String doctext    = jcas.getDocumentText();
	    int startposition = 0;
	    int endposition   = doctext.length();
	     
		// get timex index
		FSIndex<? extends Annotation> indexTimex   = jcas.getAnnotationIndex(MedTimex3.type);
		FSIterator<? extends Annotation> iterTimex = indexTimex.iterator();
		
		int tid=0;
		while (iterTimex.hasNext()){
				MedTimex3 t = (MedTimex3) iterTimex.next();
				String segv=t.getContextSentence().getSegment().getValue();
			if(segv.equals("date_dictated") 
				|| segv.equals("date_transcribed")
				|| segv.equals("providers")
				|| segv.equals("author")
			) break;
			endposition = t.getBegin();
			if (endposition < startposition){
				if (printDetails == true){
					System.err.println("[MedTimeWriter] Overlapping expressions... ignoring: "+t.getCoveredText());
				}
			} else{
				//toprint += "<MedTimex3 id=\"" + t.getTimexId() + "\" "; //id of MedTimex3
				String type = (t.getTimexType().equals("SET") ? "FREQUENCY" : t.getTimexType());
				
				String mod = t.getTimexMod();
				if(mod.equals("")) mod="NA";
				else if(mod.contains("MORE")) mod="MORE";
				else if(mod.contains("LESS")) mod="LESS";
				else {}
				
				String val = t.getTimexValue();
				int start=t.getBegin()+1;
				int end=t.getEnd()+1;
				toprint += "<TIMEX3 id=\"T" + tid + "\" "; //id of MedTimex3
				toprint += "start=\"" + start + "\" " + "end=\"" + end + "\" "; 
				toprint += "text=\"" + t.getCoveredText() + "\" "; 
				toprint += "type=\"" + type + "\" ";				
				toprint += "val=\"" + val + "\" ";
				toprint += "mod=\"" + mod + "\" />" + "\n";
				startposition = t.getEnd();
			}
			
			tid++;
		}
	
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(outFile));
			bf.append(toprint);
			bf.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}

	
	public String translateMedTimex3timex2(String timexvalue){
		
		// change decades
		String decade = "(.*\\d\\d\\d)X";
		if (timexvalue.matches(decade)){
			for (MatchResult m : findMatches(Pattern.compile(decade), timexvalue)){
				timexvalue = m.group(1);
			}
		}
		// change century
		String century = "(.*\\d\\d)XX";
		if (timexvalue.matches(century)){
			for (MatchResult m : findMatches(Pattern.compile(century), timexvalue)){
				timexvalue = m.group(1);
			}
		}		
		
		return timexvalue;
	}
	
	public String translateMedTimex3timex2set(String timexvalue){
		
		// change year
		String year = "(P(\\d)+Y)";
		if (timexvalue.matches(year)){
			timexvalue = "XXXX";
		}
		// change month
		String month = "(P(\\d)+M)";
		if (timexvalue.matches(month)){
			timexvalue = "XXXX-XX";
		}
		// change day
		String day = "(P(\\d)+D)";
		if (timexvalue.matches(day)){
			timexvalue = "XXXX-XX-XX";
		}
		// change hour
		String hour = "(PT(\\d)+H)";
		if (timexvalue.matches(hour)){
			timexvalue = "XXXX-XX-XXTXX";
		}
		// change minute
		String minute = "(PT(\\d)+M)";
		if (timexvalue.matches(minute)){
			timexvalue = "XXXX-XX-XXTXX:XX";
		}
		
		return timexvalue;
	}
	
	/**
	 * Find all the matches of a pattern in a charSequence and return the
	 * results as list.
	 * 
	 * @param pattern
	 * @param s
	 * @return
	 */
	public static Iterable<MatchResult> findMatches(Pattern pattern,
			CharSequence s) {
		List<MatchResult> results = new ArrayList<MatchResult>();

		for (Matcher m = pattern.matcher(s); m.find();)
			results.add(m.toMatchResult());

		return results;
	}
}

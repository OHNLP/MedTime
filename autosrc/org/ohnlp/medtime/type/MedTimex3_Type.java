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

/* First created by JCasGen Sun Sep 29 06:04:08 CDT 2013 */
package org.ohnlp.medtime.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * @generated */
public class MedTimex3_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (MedTimex3_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = MedTimex3_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new MedTimex3(addr, MedTimex3_Type.this);
  			   MedTimex3_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new MedTimex3(addr, MedTimex3_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MedTimex3.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.medtime.type.MedTimex3");
 
  /** @generated */
  final Feature casFeat_filename;
  /** @generated */
  final int     casFeatCode_filename;
  /** @generated */ 
  public String getFilename(int addr) {
        if (featOkTst && casFeat_filename == null)
      jcas.throwFeatMissing("filename", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_filename);
  }
  /** @generated */    
  public void setFilename(int addr, String v) {
        if (featOkTst && casFeat_filename == null)
      jcas.throwFeatMissing("filename", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_filename, v);}
    
  
 
  /** @generated */
  final Feature casFeat_firstTokId;
  /** @generated */
  final int     casFeatCode_firstTokId;
  /** @generated */ 
  public int getFirstTokId(int addr) {
        if (featOkTst && casFeat_firstTokId == null)
      jcas.throwFeatMissing("firstTokId", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getIntValue(addr, casFeatCode_firstTokId);
  }
  /** @generated */    
  public void setFirstTokId(int addr, int v) {
        if (featOkTst && casFeat_firstTokId == null)
      jcas.throwFeatMissing("firstTokId", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setIntValue(addr, casFeatCode_firstTokId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_allTokIds;
  /** @generated */
  final int     casFeatCode_allTokIds;
  /** @generated */ 
  public String getAllTokIds(int addr) {
        if (featOkTst && casFeat_allTokIds == null)
      jcas.throwFeatMissing("allTokIds", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_allTokIds);
  }
  /** @generated */    
  public void setAllTokIds(int addr, String v) {
        if (featOkTst && casFeat_allTokIds == null)
      jcas.throwFeatMissing("allTokIds", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_allTokIds, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexId;
  /** @generated */
  final int     casFeatCode_timexId;
  /** @generated */ 
  public String getTimexId(int addr) {
        if (featOkTst && casFeat_timexId == null)
      jcas.throwFeatMissing("timexId", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexId);
  }
  /** @generated */    
  public void setTimexId(int addr, String v) {
        if (featOkTst && casFeat_timexId == null)
      jcas.throwFeatMissing("timexId", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexInstance;
  /** @generated */
  final int     casFeatCode_timexInstance;
  /** @generated */ 
  public int getTimexInstance(int addr) {
        if (featOkTst && casFeat_timexInstance == null)
      jcas.throwFeatMissing("timexInstance", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getIntValue(addr, casFeatCode_timexInstance);
  }
  /** @generated */    
  public void setTimexInstance(int addr, int v) {
        if (featOkTst && casFeat_timexInstance == null)
      jcas.throwFeatMissing("timexInstance", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setIntValue(addr, casFeatCode_timexInstance, v);}
    
  
 
  /** @generated */
  final Feature casFeat_contextSentence;
  /** @generated */
  final int     casFeatCode_contextSentence;
  /** @generated */ 
  public int getContextSentence(int addr) {
        if (featOkTst && casFeat_contextSentence == null)
      jcas.throwFeatMissing("contextSentence", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getRefValue(addr, casFeatCode_contextSentence);
  }
  /** @generated */    
  public void setContextSentence(int addr, int v) {
        if (featOkTst && casFeat_contextSentence == null)
      jcas.throwFeatMissing("contextSentence", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setRefValue(addr, casFeatCode_contextSentence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexType;
  /** @generated */
  final int     casFeatCode_timexType;
  /** @generated */ 
  public String getTimexType(int addr) {
        if (featOkTst && casFeat_timexType == null)
      jcas.throwFeatMissing("timexType", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexType);
  }
  /** @generated */    
  public void setTimexType(int addr, String v) {
        if (featOkTst && casFeat_timexType == null)
      jcas.throwFeatMissing("timexType", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexValue;
  /** @generated */
  final int     casFeatCode_timexValue;
  /** @generated */ 
  public String getTimexValue(int addr) {
        if (featOkTst && casFeat_timexValue == null)
      jcas.throwFeatMissing("timexValue", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexValue);
  }
  /** @generated */    
  public void setTimexValue(int addr, String v) {
        if (featOkTst && casFeat_timexValue == null)
      jcas.throwFeatMissing("timexValue", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexValue, v);}
    
  
 
  /** @generated */
  final Feature casFeat_foundByRule;
  /** @generated */
  final int     casFeatCode_foundByRule;
  /** @generated */ 
  public String getFoundByRule(int addr) {
        if (featOkTst && casFeat_foundByRule == null)
      jcas.throwFeatMissing("foundByRule", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_foundByRule);
  }
  /** @generated */    
  public void setFoundByRule(int addr, String v) {
        if (featOkTst && casFeat_foundByRule == null)
      jcas.throwFeatMissing("foundByRule", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_foundByRule, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexQuant;
  /** @generated */
  final int     casFeatCode_timexQuant;
  /** @generated */ 
  public String getTimexQuant(int addr) {
        if (featOkTst && casFeat_timexQuant == null)
      jcas.throwFeatMissing("timexQuant", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexQuant);
  }
  /** @generated */    
  public void setTimexQuant(int addr, String v) {
        if (featOkTst && casFeat_timexQuant == null)
      jcas.throwFeatMissing("timexQuant", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexQuant, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexFreq;
  /** @generated */
  final int     casFeatCode_timexFreq;
  /** @generated */ 
  public String getTimexFreq(int addr) {
        if (featOkTst && casFeat_timexFreq == null)
      jcas.throwFeatMissing("timexFreq", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexFreq);
  }
  /** @generated */    
  public void setTimexFreq(int addr, String v) {
        if (featOkTst && casFeat_timexFreq == null)
      jcas.throwFeatMissing("timexFreq", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexFreq, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexMod;
  /** @generated */
  final int     casFeatCode_timexMod;
  /** @generated */ 
  public String getTimexMod(int addr) {
        if (featOkTst && casFeat_timexMod == null)
      jcas.throwFeatMissing("timexMod", "org.ohnlp.medtime.type.MedTimex3");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexMod);
  }
  /** @generated */    
  public void setTimexMod(int addr, String v) {
        if (featOkTst && casFeat_timexMod == null)
      jcas.throwFeatMissing("timexMod", "org.ohnlp.medtime.type.MedTimex3");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexMod, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public MedTimex3_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_filename = jcas.getRequiredFeatureDE(casType, "filename", "uima.cas.String", featOkTst);
    casFeatCode_filename  = (null == casFeat_filename) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_filename).getCode();

 
    casFeat_firstTokId = jcas.getRequiredFeatureDE(casType, "firstTokId", "uima.cas.Integer", featOkTst);
    casFeatCode_firstTokId  = (null == casFeat_firstTokId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_firstTokId).getCode();

 
    casFeat_allTokIds = jcas.getRequiredFeatureDE(casType, "allTokIds", "uima.cas.String", featOkTst);
    casFeatCode_allTokIds  = (null == casFeat_allTokIds) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_allTokIds).getCode();

 
    casFeat_timexId = jcas.getRequiredFeatureDE(casType, "timexId", "uima.cas.String", featOkTst);
    casFeatCode_timexId  = (null == casFeat_timexId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexId).getCode();

 
    casFeat_timexInstance = jcas.getRequiredFeatureDE(casType, "timexInstance", "uima.cas.Integer", featOkTst);
    casFeatCode_timexInstance  = (null == casFeat_timexInstance) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexInstance).getCode();

 
    casFeat_contextSentence = jcas.getRequiredFeatureDE(casType, "contextSentence", "org.ohnlp.typesystem.type.textspan.Sentence", featOkTst);
    casFeatCode_contextSentence  = (null == casFeat_contextSentence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_contextSentence).getCode();

 
    casFeat_timexType = jcas.getRequiredFeatureDE(casType, "timexType", "uima.cas.String", featOkTst);
    casFeatCode_timexType  = (null == casFeat_timexType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexType).getCode();

 
    casFeat_timexValue = jcas.getRequiredFeatureDE(casType, "timexValue", "uima.cas.String", featOkTst);
    casFeatCode_timexValue  = (null == casFeat_timexValue) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexValue).getCode();

 
    casFeat_foundByRule = jcas.getRequiredFeatureDE(casType, "foundByRule", "uima.cas.String", featOkTst);
    casFeatCode_foundByRule  = (null == casFeat_foundByRule) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_foundByRule).getCode();

 
    casFeat_timexQuant = jcas.getRequiredFeatureDE(casType, "timexQuant", "uima.cas.String", featOkTst);
    casFeatCode_timexQuant  = (null == casFeat_timexQuant) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexQuant).getCode();

 
    casFeat_timexFreq = jcas.getRequiredFeatureDE(casType, "timexFreq", "uima.cas.String", featOkTst);
    casFeatCode_timexFreq  = (null == casFeat_timexFreq) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexFreq).getCode();

 
    casFeat_timexMod = jcas.getRequiredFeatureDE(casType, "timexMod", "uima.cas.String", featOkTst);
    casFeatCode_timexMod  = (null == casFeat_timexMod) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexMod).getCode();

  }
}



    
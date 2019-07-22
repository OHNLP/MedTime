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
import org.apache.uima.jcas.cas.TOP_Type;

import org.ohnlp.typesystem.type.textspan.Sentence;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * XML source: /MedTime-1.0/descsrc/org/ohnlp/medtime/types/MedTimeTypes.xml
 * @generated */
public class MedTimex3 extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(MedTimex3.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected MedTimex3() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public MedTimex3(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public MedTimex3(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public MedTimex3(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: filename

  /** getter for filename - gets 
   * @generated */
  public String getFilename() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_filename == null)
      jcasType.jcas.throwFeatMissing("filename", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_filename);}
    
  /** setter for filename - sets  
   * @generated */
  public void setFilename(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_filename == null)
      jcasType.jcas.throwFeatMissing("filename", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_filename, v);}    
   
    
  //*--------------*
  //* Feature: firstTokId

  /** getter for firstTokId - gets 
   * @generated */
  public int getFirstTokId() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_firstTokId == null)
      jcasType.jcas.throwFeatMissing("firstTokId", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_firstTokId);}
    
  /** setter for firstTokId - sets  
   * @generated */
  public void setFirstTokId(int v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_firstTokId == null)
      jcasType.jcas.throwFeatMissing("firstTokId", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setIntValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_firstTokId, v);}    
   
    
  //*--------------*
  //* Feature: allTokIds

  /** getter for allTokIds - gets 
   * @generated */
  public String getAllTokIds() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_allTokIds == null)
      jcasType.jcas.throwFeatMissing("allTokIds", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_allTokIds);}
    
  /** setter for allTokIds - sets  
   * @generated */
  public void setAllTokIds(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_allTokIds == null)
      jcasType.jcas.throwFeatMissing("allTokIds", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_allTokIds, v);}    
   
    
  //*--------------*
  //* Feature: timexId

  /** getter for timexId - gets 
   * @generated */
  public String getTimexId() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexId == null)
      jcasType.jcas.throwFeatMissing("timexId", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexId);}
    
  /** setter for timexId - sets  
   * @generated */
  public void setTimexId(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexId == null)
      jcasType.jcas.throwFeatMissing("timexId", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexId, v);}    
   
    
  //*--------------*
  //* Feature: timexInstance

  /** getter for timexInstance - gets 
   * @generated */
  public int getTimexInstance() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexInstance == null)
      jcasType.jcas.throwFeatMissing("timexInstance", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getIntValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexInstance);}
    
  /** setter for timexInstance - sets  
   * @generated */
  public void setTimexInstance(int v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexInstance == null)
      jcasType.jcas.throwFeatMissing("timexInstance", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setIntValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexInstance, v);}    
   
    
  //*--------------*
  //* Feature: contextSentence

  /** getter for contextSentence - gets 
   * @generated */
  public Sentence getContextSentence() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_contextSentence == null)
      jcasType.jcas.throwFeatMissing("contextSentence", "org.ohnlp.medtime.type.MedTimex3");
    return (Sentence)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_contextSentence)));}
    
  /** setter for contextSentence - sets  
   * @generated */
  public void setContextSentence(Sentence v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_contextSentence == null)
      jcasType.jcas.throwFeatMissing("contextSentence", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setRefValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_contextSentence, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: timexType

  /** getter for timexType - gets 
   * @generated */
  public String getTimexType() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexType == null)
      jcasType.jcas.throwFeatMissing("timexType", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexType);}
    
  /** setter for timexType - sets  
   * @generated */
  public void setTimexType(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexType == null)
      jcasType.jcas.throwFeatMissing("timexType", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexType, v);}    
   
    
  //*--------------*
  //* Feature: timexValue

  /** getter for timexValue - gets 
   * @generated */
  public String getTimexValue() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexValue == null)
      jcasType.jcas.throwFeatMissing("timexValue", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexValue);}
    
  /** setter for timexValue - sets  
   * @generated */
  public void setTimexValue(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexValue == null)
      jcasType.jcas.throwFeatMissing("timexValue", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexValue, v);}    
   
    
  //*--------------*
  //* Feature: foundByRule

  /** getter for foundByRule - gets 
   * @generated */
  public String getFoundByRule() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_foundByRule == null)
      jcasType.jcas.throwFeatMissing("foundByRule", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_foundByRule);}
    
  /** setter for foundByRule - sets  
   * @generated */
  public void setFoundByRule(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_foundByRule == null)
      jcasType.jcas.throwFeatMissing("foundByRule", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_foundByRule, v);}    
   
    
  //*--------------*
  //* Feature: timexQuant

  /** getter for timexQuant - gets 
   * @generated */
  public String getTimexQuant() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexQuant == null)
      jcasType.jcas.throwFeatMissing("timexQuant", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexQuant);}
    
  /** setter for timexQuant - sets  
   * @generated */
  public void setTimexQuant(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexQuant == null)
      jcasType.jcas.throwFeatMissing("timexQuant", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexQuant, v);}    
   
    
  //*--------------*
  //* Feature: timexFreq

  /** getter for timexFreq - gets 
   * @generated */
  public String getTimexFreq() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexFreq == null)
      jcasType.jcas.throwFeatMissing("timexFreq", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexFreq);}
    
  /** setter for timexFreq - sets  
   * @generated */
  public void setTimexFreq(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexFreq == null)
      jcasType.jcas.throwFeatMissing("timexFreq", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexFreq, v);}    
   
    
  //*--------------*
  //* Feature: timexMod

  /** getter for timexMod - gets 
   * @generated */
  public String getTimexMod() {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexMod == null)
      jcasType.jcas.throwFeatMissing("timexMod", "org.ohnlp.medtime.type.MedTimex3");
    return jcasType.ll_cas.ll_getStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexMod);}
    
  /** setter for timexMod - sets  
   * @generated */
  public void setTimexMod(String v) {
    if (MedTimex3_Type.featOkTst && ((MedTimex3_Type)jcasType).casFeat_timexMod == null)
      jcasType.jcas.throwFeatMissing("timexMod", "org.ohnlp.medtime.type.MedTimex3");
    jcasType.ll_cas.ll_setStringValue(addr, ((MedTimex3_Type)jcasType).casFeatCode_timexMod, v);}    
  }

    
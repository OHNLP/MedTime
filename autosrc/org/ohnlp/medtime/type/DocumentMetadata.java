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

import org.apache.uima.jcas.tcas.Annotation;


/** Structured data that captures information about the document, patient, or context of the clinical text.
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * XML source: /MedTime-1.0/descsrc/org/ohnlp/medtime/types/MedTimeTypes.xml
 * @generated */
public class DocumentMetadata extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(DocumentMetadata.class);
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
  protected DocumentMetadata() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public DocumentMetadata(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public DocumentMetadata(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public DocumentMetadata(JCas jcas, int begin, int end) {
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
  //* Feature: fileName

  /** getter for fileName - gets 
   * @generated */
  public String getFileName() {
    if (DocumentMetadata_Type.featOkTst && ((DocumentMetadata_Type)jcasType).casFeat_fileName == null)
      jcasType.jcas.throwFeatMissing("fileName", "org.ohnlp.medtime.type.DocumentMetadata");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetadata_Type)jcasType).casFeatCode_fileName);}
    
  /** setter for fileName - sets  
   * @generated */
  public void setFileName(String v) {
    if (DocumentMetadata_Type.featOkTst && ((DocumentMetadata_Type)jcasType).casFeat_fileName == null)
      jcasType.jcas.throwFeatMissing("fileName", "org.ohnlp.medtime.type.DocumentMetadata");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetadata_Type)jcasType).casFeatCode_fileName, v);}    
   
    
  //*--------------*
  //* Feature: timexId

  /** getter for timexId - gets 
   * @generated */
  public String getTimexId() {
    if (DocumentMetadata_Type.featOkTst && ((DocumentMetadata_Type)jcasType).casFeat_timexId == null)
      jcasType.jcas.throwFeatMissing("timexId", "org.ohnlp.medtime.type.DocumentMetadata");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetadata_Type)jcasType).casFeatCode_timexId);}
    
  /** setter for timexId - sets  
   * @generated */
  public void setTimexId(String v) {
    if (DocumentMetadata_Type.featOkTst && ((DocumentMetadata_Type)jcasType).casFeat_timexId == null)
      jcasType.jcas.throwFeatMissing("timexId", "org.ohnlp.medtime.type.DocumentMetadata");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetadata_Type)jcasType).casFeatCode_timexId, v);}    
   
    
  //*--------------*
  //* Feature: timexValue

  /** getter for timexValue - gets 
   * @generated */
  public String getTimexValue() {
    if (DocumentMetadata_Type.featOkTst && ((DocumentMetadata_Type)jcasType).casFeat_timexValue == null)
      jcasType.jcas.throwFeatMissing("timexValue", "org.ohnlp.medtime.type.DocumentMetadata");
    return jcasType.ll_cas.ll_getStringValue(addr, ((DocumentMetadata_Type)jcasType).casFeatCode_timexValue);}
    
  /** setter for timexValue - sets  
   * @generated */
  public void setTimexValue(String v) {
    if (DocumentMetadata_Type.featOkTst && ((DocumentMetadata_Type)jcasType).casFeat_timexValue == null)
      jcasType.jcas.throwFeatMissing("timexValue", "org.ohnlp.medtime.type.DocumentMetadata");
    jcasType.ll_cas.ll_setStringValue(addr, ((DocumentMetadata_Type)jcasType).casFeatCode_timexValue, v);}    
  }

    
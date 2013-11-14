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
package org.ohnlp.typesystem.type.syntax;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Differentiates a token as being a word rather than a punctuation, symbol, newline, contraction, or number.
Equivalent to Mayo cTAKES version 2.5: edu.mayo.bmi.uima.core.type.WordToken
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * XML source: /MedTime-1.0/descsrc/org/ohnlp/medtime/types/MedTimeTypes.xml
 * @generated */
public class WordToken extends BaseToken {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(WordToken.class);
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
  protected WordToken() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public WordToken(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public WordToken(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public WordToken(JCas jcas, int begin, int end) {
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
  //* Feature: capitalization

  /** getter for capitalization - gets 
   * @generated */
  public int getCapitalization() {
    if (WordToken_Type.featOkTst && ((WordToken_Type)jcasType).casFeat_capitalization == null)
      jcasType.jcas.throwFeatMissing("capitalization", "org.ohnlp.typesystem.type.syntax.WordToken");
    return jcasType.ll_cas.ll_getIntValue(addr, ((WordToken_Type)jcasType).casFeatCode_capitalization);}
    
  /** setter for capitalization - sets  
   * @generated */
  public void setCapitalization(int v) {
    if (WordToken_Type.featOkTst && ((WordToken_Type)jcasType).casFeat_capitalization == null)
      jcasType.jcas.throwFeatMissing("capitalization", "org.ohnlp.typesystem.type.syntax.WordToken");
    jcasType.ll_cas.ll_setIntValue(addr, ((WordToken_Type)jcasType).casFeatCode_capitalization, v);}    
   
    
  //*--------------*
  //* Feature: numPosition

  /** getter for numPosition - gets 
   * @generated */
  public int getNumPosition() {
    if (WordToken_Type.featOkTst && ((WordToken_Type)jcasType).casFeat_numPosition == null)
      jcasType.jcas.throwFeatMissing("numPosition", "org.ohnlp.typesystem.type.syntax.WordToken");
    return jcasType.ll_cas.ll_getIntValue(addr, ((WordToken_Type)jcasType).casFeatCode_numPosition);}
    
  /** setter for numPosition - sets  
   * @generated */
  public void setNumPosition(int v) {
    if (WordToken_Type.featOkTst && ((WordToken_Type)jcasType).casFeat_numPosition == null)
      jcasType.jcas.throwFeatMissing("numPosition", "org.ohnlp.typesystem.type.syntax.WordToken");
    jcasType.ll_cas.ll_setIntValue(addr, ((WordToken_Type)jcasType).casFeatCode_numPosition, v);}    
   
    
  //*--------------*
  //* Feature: suggestion

  /** getter for suggestion - gets 
   * @generated */
  public String getSuggestion() {
    if (WordToken_Type.featOkTst && ((WordToken_Type)jcasType).casFeat_suggestion == null)
      jcasType.jcas.throwFeatMissing("suggestion", "org.ohnlp.typesystem.type.syntax.WordToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WordToken_Type)jcasType).casFeatCode_suggestion);}
    
  /** setter for suggestion - sets  
   * @generated */
  public void setSuggestion(String v) {
    if (WordToken_Type.featOkTst && ((WordToken_Type)jcasType).casFeat_suggestion == null)
      jcasType.jcas.throwFeatMissing("suggestion", "org.ohnlp.typesystem.type.syntax.WordToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((WordToken_Type)jcasType).casFeatCode_suggestion, v);}    
   
    
  //*--------------*
  //* Feature: canonicalForm

  /** getter for canonicalForm - gets 
   * @generated */
  public String getCanonicalForm() {
    if (WordToken_Type.featOkTst && ((WordToken_Type)jcasType).casFeat_canonicalForm == null)
      jcasType.jcas.throwFeatMissing("canonicalForm", "org.ohnlp.typesystem.type.syntax.WordToken");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WordToken_Type)jcasType).casFeatCode_canonicalForm);}
    
  /** setter for canonicalForm - sets  
   * @generated */
  public void setCanonicalForm(String v) {
    if (WordToken_Type.featOkTst && ((WordToken_Type)jcasType).casFeat_canonicalForm == null)
      jcasType.jcas.throwFeatMissing("canonicalForm", "org.ohnlp.typesystem.type.syntax.WordToken");
    jcasType.ll_cas.ll_setStringValue(addr, ((WordToken_Type)jcasType).casFeatCode_canonicalForm, v);}    
  }

    
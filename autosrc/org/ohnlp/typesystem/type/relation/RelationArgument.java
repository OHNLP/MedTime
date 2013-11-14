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
package org.ohnlp.typesystem.type.relation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.jcas.cas.TOP;


/** Relations are like lines connecting two or more endpoints.  RelationArguments are used as endpoints that are text spans via the "argument" feature. The directed relations should specify a "role" feature.
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * XML source: /MedTime-1.0/descsrc/org/ohnlp/medtime/types/MedTimeTypes.xml
 * @generated */
public class RelationArgument extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(RelationArgument.class);
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
  protected RelationArgument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public RelationArgument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public RelationArgument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public int getId() {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "org.ohnlp.typesystem.type.relation.RelationArgument");
    return jcasType.ll_cas.ll_getIntValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(int v) {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "org.ohnlp.typesystem.type.relation.RelationArgument");
    jcasType.ll_cas.ll_setIntValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: argument

  /** getter for argument - gets 
   * @generated */
  public Annotation getArgument() {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_argument == null)
      jcasType.jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.relation.RelationArgument");
    return (Annotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_argument)));}
    
  /** setter for argument - sets  
   * @generated */
  public void setArgument(Annotation v) {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_argument == null)
      jcasType.jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.relation.RelationArgument");
    jcasType.ll_cas.ll_setRefValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_argument, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: role

  /** getter for role - gets 
   * @generated */
  public String getRole() {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_role == null)
      jcasType.jcas.throwFeatMissing("role", "org.ohnlp.typesystem.type.relation.RelationArgument");
    return jcasType.ll_cas.ll_getStringValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_role);}
    
  /** setter for role - sets  
   * @generated */
  public void setRole(String v) {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_role == null)
      jcasType.jcas.throwFeatMissing("role", "org.ohnlp.typesystem.type.relation.RelationArgument");
    jcasType.ll_cas.ll_setStringValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_role, v);}    
   
    
  //*--------------*
  //* Feature: participatesIn

  /** getter for participatesIn - gets 
   * @generated */
  public FSList getParticipatesIn() {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_participatesIn == null)
      jcasType.jcas.throwFeatMissing("participatesIn", "org.ohnlp.typesystem.type.relation.RelationArgument");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_participatesIn)));}
    
  /** setter for participatesIn - sets  
   * @generated */
  public void setParticipatesIn(FSList v) {
    if (RelationArgument_Type.featOkTst && ((RelationArgument_Type)jcasType).casFeat_participatesIn == null)
      jcasType.jcas.throwFeatMissing("participatesIn", "org.ohnlp.typesystem.type.relation.RelationArgument");
    jcasType.ll_cas.ll_setRefValue(addr, ((RelationArgument_Type)jcasType).casFeatCode_participatesIn, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    
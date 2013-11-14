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
package org.ohnlp.typesystem.type.textsem;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.ohnlp.typesystem.type.relation.Relation;


/** Predicate-argument structure used for semantic role labeling output.
 * Updated by JCasGen Sun Sep 29 06:07:12 CDT 2013
 * XML source: /MedTime-1.0/descsrc/org/ohnlp/medtime/types/MedTimeTypes.xml
 * @generated */
public class SemanticRoleRelation extends Relation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SemanticRoleRelation.class);
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
  protected SemanticRoleRelation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public SemanticRoleRelation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public SemanticRoleRelation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: predicate

  /** getter for predicate - gets 
   * @generated */
  public Predicate getPredicate() {
    if (SemanticRoleRelation_Type.featOkTst && ((SemanticRoleRelation_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    return (Predicate)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SemanticRoleRelation_Type)jcasType).casFeatCode_predicate)));}
    
  /** setter for predicate - sets  
   * @generated */
  public void setPredicate(Predicate v) {
    if (SemanticRoleRelation_Type.featOkTst && ((SemanticRoleRelation_Type)jcasType).casFeat_predicate == null)
      jcasType.jcas.throwFeatMissing("predicate", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((SemanticRoleRelation_Type)jcasType).casFeatCode_predicate, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: argument

  /** getter for argument - gets 
   * @generated */
  public SemanticArgument getArgument() {
    if (SemanticRoleRelation_Type.featOkTst && ((SemanticRoleRelation_Type)jcasType).casFeat_argument == null)
      jcasType.jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    return (SemanticArgument)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((SemanticRoleRelation_Type)jcasType).casFeatCode_argument)));}
    
  /** setter for argument - sets  
   * @generated */
  public void setArgument(SemanticArgument v) {
    if (SemanticRoleRelation_Type.featOkTst && ((SemanticRoleRelation_Type)jcasType).casFeat_argument == null)
      jcasType.jcas.throwFeatMissing("argument", "org.ohnlp.typesystem.type.textsem.SemanticRoleRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((SemanticRoleRelation_Type)jcasType).casFeatCode_argument, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    
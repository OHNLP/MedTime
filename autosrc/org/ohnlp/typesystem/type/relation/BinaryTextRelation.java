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



/** A super-type for relationships between two spans of text.
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * XML source: /MedTime-1.0/descsrc/org/ohnlp/medtime/types/MedTimeTypes.xml
 * @generated */
public class BinaryTextRelation extends Relation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(BinaryTextRelation.class);
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
  protected BinaryTextRelation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public BinaryTextRelation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public BinaryTextRelation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: arg1

  /** getter for arg1 - gets 
   * @generated */
  public RelationArgument getArg1() {
    if (BinaryTextRelation_Type.featOkTst && ((BinaryTextRelation_Type)jcasType).casFeat_arg1 == null)
      jcasType.jcas.throwFeatMissing("arg1", "org.ohnlp.typesystem.type.relation.BinaryTextRelation");
    return (RelationArgument)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((BinaryTextRelation_Type)jcasType).casFeatCode_arg1)));}
    
  /** setter for arg1 - sets  
   * @generated */
  public void setArg1(RelationArgument v) {
    if (BinaryTextRelation_Type.featOkTst && ((BinaryTextRelation_Type)jcasType).casFeat_arg1 == null)
      jcasType.jcas.throwFeatMissing("arg1", "org.ohnlp.typesystem.type.relation.BinaryTextRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((BinaryTextRelation_Type)jcasType).casFeatCode_arg1, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: arg2

  /** getter for arg2 - gets 
   * @generated */
  public RelationArgument getArg2() {
    if (BinaryTextRelation_Type.featOkTst && ((BinaryTextRelation_Type)jcasType).casFeat_arg2 == null)
      jcasType.jcas.throwFeatMissing("arg2", "org.ohnlp.typesystem.type.relation.BinaryTextRelation");
    return (RelationArgument)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((BinaryTextRelation_Type)jcasType).casFeatCode_arg2)));}
    
  /** setter for arg2 - sets  
   * @generated */
  public void setArg2(RelationArgument v) {
    if (BinaryTextRelation_Type.featOkTst && ((BinaryTextRelation_Type)jcasType).casFeat_arg2 == null)
      jcasType.jcas.throwFeatMissing("arg2", "org.ohnlp.typesystem.type.relation.BinaryTextRelation");
    jcasType.ll_cas.ll_setRefValue(addr, ((BinaryTextRelation_Type)jcasType).casFeatCode_arg2, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    
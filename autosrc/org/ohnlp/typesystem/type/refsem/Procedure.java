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
package org.ohnlp.typesystem.type.refsem;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.ohnlp.typesystem.type.relation.TemporalRelation;
import org.ohnlp.typesystem.type.relation.LocationOf;


/** This is an Event from the UMLS semantic group of Procedures (except that Laboratory procedures are separate).  Based on generic Clinical Element Models (CEMs)
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * XML source: /MedTime-1.0/descsrc/org/ohnlp/medtime/types/MedTimeTypes.xml
 * @generated */
public class Procedure extends Event {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Procedure.class);
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
  protected Procedure() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Procedure(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Procedure(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: bodyLaterality

  /** getter for bodyLaterality - gets 
   * @generated */
  public BodyLaterality getBodyLaterality() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_bodyLaterality == null)
      jcasType.jcas.throwFeatMissing("bodyLaterality", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (BodyLaterality)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_bodyLaterality)));}
    
  /** setter for bodyLaterality - sets  
   * @generated */
  public void setBodyLaterality(BodyLaterality v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_bodyLaterality == null)
      jcasType.jcas.throwFeatMissing("bodyLaterality", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_bodyLaterality, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: bodySide

  /** getter for bodySide - gets 
   * @generated */
  public BodySide getBodySide() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_bodySide == null)
      jcasType.jcas.throwFeatMissing("bodySide", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (BodySide)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_bodySide)));}
    
  /** setter for bodySide - sets  
   * @generated */
  public void setBodySide(BodySide v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_bodySide == null)
      jcasType.jcas.throwFeatMissing("bodySide", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_bodySide, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: bodyLocation

  /** getter for bodyLocation - gets 
   * @generated */
  public LocationOf getBodyLocation() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_bodyLocation == null)
      jcasType.jcas.throwFeatMissing("bodyLocation", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (LocationOf)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_bodyLocation)));}
    
  /** setter for bodyLocation - sets  
   * @generated */
  public void setBodyLocation(LocationOf v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_bodyLocation == null)
      jcasType.jcas.throwFeatMissing("bodyLocation", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_bodyLocation, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: procedureDevice

  /** getter for procedureDevice - gets 
   * @generated */
  public ProcedureDevice getProcedureDevice() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_procedureDevice == null)
      jcasType.jcas.throwFeatMissing("procedureDevice", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (ProcedureDevice)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_procedureDevice)));}
    
  /** setter for procedureDevice - sets  
   * @generated */
  public void setProcedureDevice(ProcedureDevice v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_procedureDevice == null)
      jcasType.jcas.throwFeatMissing("procedureDevice", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_procedureDevice, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: duration

  /** getter for duration - gets 
   * @generated */
  public TemporalRelation getDuration() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_duration == null)
      jcasType.jcas.throwFeatMissing("duration", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (TemporalRelation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_duration)));}
    
  /** setter for duration - sets  
   * @generated */
  public void setDuration(TemporalRelation v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_duration == null)
      jcasType.jcas.throwFeatMissing("duration", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_duration, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: endTime

  /** getter for endTime - gets 
   * @generated */
  public Time getEndTime() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_endTime == null)
      jcasType.jcas.throwFeatMissing("endTime", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (Time)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_endTime)));}
    
  /** setter for endTime - sets  
   * @generated */
  public void setEndTime(Time v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_endTime == null)
      jcasType.jcas.throwFeatMissing("endTime", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_endTime, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: method

  /** getter for method - gets 
   * @generated */
  public ProcedureMethod getMethod() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_method == null)
      jcasType.jcas.throwFeatMissing("method", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (ProcedureMethod)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_method)));}
    
  /** setter for method - sets  
   * @generated */
  public void setMethod(ProcedureMethod v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_method == null)
      jcasType.jcas.throwFeatMissing("method", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_method, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: startTime

  /** getter for startTime - gets 
   * @generated */
  public Time getStartTime() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_startTime == null)
      jcasType.jcas.throwFeatMissing("startTime", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (Time)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_startTime)));}
    
  /** setter for startTime - sets  
   * @generated */
  public void setStartTime(Time v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_startTime == null)
      jcasType.jcas.throwFeatMissing("startTime", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_startTime, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: relativeTemporalContext

  /** getter for relativeTemporalContext - gets 
   * @generated */
  public TemporalRelation getRelativeTemporalContext() {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_relativeTemporalContext == null)
      jcasType.jcas.throwFeatMissing("relativeTemporalContext", "org.ohnlp.typesystem.type.refsem.Procedure");
    return (TemporalRelation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_relativeTemporalContext)));}
    
  /** setter for relativeTemporalContext - sets  
   * @generated */
  public void setRelativeTemporalContext(TemporalRelation v) {
    if (Procedure_Type.featOkTst && ((Procedure_Type)jcasType).casFeat_relativeTemporalContext == null)
      jcasType.jcas.throwFeatMissing("relativeTemporalContext", "org.ohnlp.typesystem.type.refsem.Procedure");
    jcasType.ll_cas.ll_setRefValue(addr, ((Procedure_Type)jcasType).casFeatCode_relativeTemporalContext, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    
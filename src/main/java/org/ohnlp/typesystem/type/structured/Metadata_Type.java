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
package org.ohnlp.typesystem.type.structured;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** Structured data that captures information about the document, patient, or context of the clinical text.
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * @generated */
public class Metadata_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Metadata_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Metadata_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Metadata(addr, Metadata_Type.this);
  			   Metadata_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Metadata(addr, Metadata_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Metadata.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.structured.Metadata");
 
  /** @generated */
  final Feature casFeat_patientID;
  /** @generated */
  final int     casFeatCode_patientID;
  /** @generated */ 
  public long getPatientID(int addr) {
        if (featOkTst && casFeat_patientID == null)
      jcas.throwFeatMissing("patientID", "org.ohnlp.typesystem.type.structured.Metadata");
    return ll_cas.ll_getLongValue(addr, casFeatCode_patientID);
  }
  /** @generated */    
  public void setPatientID(int addr, long v) {
        if (featOkTst && casFeat_patientID == null)
      jcas.throwFeatMissing("patientID", "org.ohnlp.typesystem.type.structured.Metadata");
    ll_cas.ll_setLongValue(addr, casFeatCode_patientID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_providerID;
  /** @generated */
  final int     casFeatCode_providerID;
  /** @generated */ 
  public int getProviderID(int addr) {
        if (featOkTst && casFeat_providerID == null)
      jcas.throwFeatMissing("providerID", "org.ohnlp.typesystem.type.structured.Metadata");
    return ll_cas.ll_getRefValue(addr, casFeatCode_providerID);
  }
  /** @generated */    
  public void setProviderID(int addr, int v) {
        if (featOkTst && casFeat_providerID == null)
      jcas.throwFeatMissing("providerID", "org.ohnlp.typesystem.type.structured.Metadata");
    ll_cas.ll_setRefValue(addr, casFeatCode_providerID, v);}
    
   /** @generated */
  public long getProviderID(int addr, int i) {
        if (featOkTst && casFeat_providerID == null)
      jcas.throwFeatMissing("providerID", "org.ohnlp.typesystem.type.structured.Metadata");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getLongArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_providerID), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_providerID), i);
  return ll_cas.ll_getLongArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_providerID), i);
  }
   
  /** @generated */ 
  public void setProviderID(int addr, int i, long v) {
        if (featOkTst && casFeat_providerID == null)
      jcas.throwFeatMissing("providerID", "org.ohnlp.typesystem.type.structured.Metadata");
    if (lowLevelTypeChecks)
      ll_cas.ll_setLongArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_providerID), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_providerID), i);
    ll_cas.ll_setLongArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_providerID), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_sourceData;
  /** @generated */
  final int     casFeatCode_sourceData;
  /** @generated */ 
  public int getSourceData(int addr) {
        if (featOkTst && casFeat_sourceData == null)
      jcas.throwFeatMissing("sourceData", "org.ohnlp.typesystem.type.structured.Metadata");
    return ll_cas.ll_getRefValue(addr, casFeatCode_sourceData);
  }
  /** @generated */    
  public void setSourceData(int addr, int v) {
        if (featOkTst && casFeat_sourceData == null)
      jcas.throwFeatMissing("sourceData", "org.ohnlp.typesystem.type.structured.Metadata");
    ll_cas.ll_setRefValue(addr, casFeatCode_sourceData, v);}
    
  
 
  /** @generated */
  final Feature casFeat_demographics;
  /** @generated */
  final int     casFeatCode_demographics;
  /** @generated */ 
  public int getDemographics(int addr) {
        if (featOkTst && casFeat_demographics == null)
      jcas.throwFeatMissing("demographics", "org.ohnlp.typesystem.type.structured.Metadata");
    return ll_cas.ll_getRefValue(addr, casFeatCode_demographics);
  }
  /** @generated */    
  public void setDemographics(int addr, int v) {
        if (featOkTst && casFeat_demographics == null)
      jcas.throwFeatMissing("demographics", "org.ohnlp.typesystem.type.structured.Metadata");
    ll_cas.ll_setRefValue(addr, casFeatCode_demographics, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Metadata_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_patientID = jcas.getRequiredFeatureDE(casType, "patientID", "uima.cas.Long", featOkTst);
    casFeatCode_patientID  = (null == casFeat_patientID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_patientID).getCode();

 
    casFeat_providerID = jcas.getRequiredFeatureDE(casType, "providerID", "uima.cas.LongArray", featOkTst);
    casFeatCode_providerID  = (null == casFeat_providerID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_providerID).getCode();

 
    casFeat_sourceData = jcas.getRequiredFeatureDE(casType, "sourceData", "org.ohnlp.typesystem.type.structured.SourceData", featOkTst);
    casFeatCode_sourceData  = (null == casFeat_sourceData) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sourceData).getCode();

 
    casFeat_demographics = jcas.getRequiredFeatureDE(casType, "demographics", "org.ohnlp.typesystem.type.structured.Demographics", featOkTst);
    casFeatCode_demographics  = (null == casFeat_demographics) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_demographics).getCode();

  }
}



    
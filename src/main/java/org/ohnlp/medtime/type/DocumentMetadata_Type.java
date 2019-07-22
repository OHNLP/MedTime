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

/** Structured data that captures information about the document, patient, or context of the clinical text.
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * @generated */
public class DocumentMetadata_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (DocumentMetadata_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = DocumentMetadata_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new DocumentMetadata(addr, DocumentMetadata_Type.this);
  			   DocumentMetadata_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new DocumentMetadata(addr, DocumentMetadata_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = DocumentMetadata.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.medtime.type.DocumentMetadata");
 
  /** @generated */
  final Feature casFeat_fileName;
  /** @generated */
  final int     casFeatCode_fileName;
  /** @generated */ 
  public String getFileName(int addr) {
        if (featOkTst && casFeat_fileName == null)
      jcas.throwFeatMissing("fileName", "org.ohnlp.medtime.type.DocumentMetadata");
    return ll_cas.ll_getStringValue(addr, casFeatCode_fileName);
  }
  /** @generated */    
  public void setFileName(int addr, String v) {
        if (featOkTst && casFeat_fileName == null)
      jcas.throwFeatMissing("fileName", "org.ohnlp.medtime.type.DocumentMetadata");
    ll_cas.ll_setStringValue(addr, casFeatCode_fileName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexId;
  /** @generated */
  final int     casFeatCode_timexId;
  /** @generated */ 
  public String getTimexId(int addr) {
        if (featOkTst && casFeat_timexId == null)
      jcas.throwFeatMissing("timexId", "org.ohnlp.medtime.type.DocumentMetadata");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexId);
  }
  /** @generated */    
  public void setTimexId(int addr, String v) {
        if (featOkTst && casFeat_timexId == null)
      jcas.throwFeatMissing("timexId", "org.ohnlp.medtime.type.DocumentMetadata");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timexValue;
  /** @generated */
  final int     casFeatCode_timexValue;
  /** @generated */ 
  public String getTimexValue(int addr) {
        if (featOkTst && casFeat_timexValue == null)
      jcas.throwFeatMissing("timexValue", "org.ohnlp.medtime.type.DocumentMetadata");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timexValue);
  }
  /** @generated */    
  public void setTimexValue(int addr, String v) {
        if (featOkTst && casFeat_timexValue == null)
      jcas.throwFeatMissing("timexValue", "org.ohnlp.medtime.type.DocumentMetadata");
    ll_cas.ll_setStringValue(addr, casFeatCode_timexValue, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public DocumentMetadata_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_fileName = jcas.getRequiredFeatureDE(casType, "fileName", "uima.cas.String", featOkTst);
    casFeatCode_fileName  = (null == casFeat_fileName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_fileName).getCode();

 
    casFeat_timexId = jcas.getRequiredFeatureDE(casType, "timexId", "uima.cas.String", featOkTst);
    casFeatCode_timexId  = (null == casFeat_timexId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexId).getCode();

 
    casFeat_timexValue = jcas.getRequiredFeatureDE(casType, "timexValue", "uima.cas.String", featOkTst);
    casFeatCode_timexValue  = (null == casFeat_timexValue) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timexValue).getCode();

  }
}



    
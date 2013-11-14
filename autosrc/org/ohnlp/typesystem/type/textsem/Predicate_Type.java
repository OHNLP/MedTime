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
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** Predicates are typically verbs and may participate in SemanticRoleRelations.  Follows PropBank standards with a few clinical additions.
 * Updated by JCasGen Sun Sep 29 06:07:12 CDT 2013
 * @generated */
public class Predicate_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Predicate_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Predicate_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Predicate(addr, Predicate_Type.this);
  			   Predicate_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Predicate(addr, Predicate_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Predicate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.textsem.Predicate");
 
  /** @generated */
  final Feature casFeat_relations;
  /** @generated */
  final int     casFeatCode_relations;
  /** @generated */ 
  public int getRelations(int addr) {
        if (featOkTst && casFeat_relations == null)
      jcas.throwFeatMissing("relations", "org.ohnlp.typesystem.type.textsem.Predicate");
    return ll_cas.ll_getRefValue(addr, casFeatCode_relations);
  }
  /** @generated */    
  public void setRelations(int addr, int v) {
        if (featOkTst && casFeat_relations == null)
      jcas.throwFeatMissing("relations", "org.ohnlp.typesystem.type.textsem.Predicate");
    ll_cas.ll_setRefValue(addr, casFeatCode_relations, v);}
    
  
 
  /** @generated */
  final Feature casFeat_frameSet;
  /** @generated */
  final int     casFeatCode_frameSet;
  /** @generated */ 
  public String getFrameSet(int addr) {
        if (featOkTst && casFeat_frameSet == null)
      jcas.throwFeatMissing("frameSet", "org.ohnlp.typesystem.type.textsem.Predicate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_frameSet);
  }
  /** @generated */    
  public void setFrameSet(int addr, String v) {
        if (featOkTst && casFeat_frameSet == null)
      jcas.throwFeatMissing("frameSet", "org.ohnlp.typesystem.type.textsem.Predicate");
    ll_cas.ll_setStringValue(addr, casFeatCode_frameSet, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Predicate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_relations = jcas.getRequiredFeatureDE(casType, "relations", "uima.cas.FSList", featOkTst);
    casFeatCode_relations  = (null == casFeat_relations) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_relations).getCode();

 
    casFeat_frameSet = jcas.getRequiredFeatureDE(casType, "frameSet", "uima.cas.String", featOkTst);
    casFeatCode_frameSet  = (null == casFeat_frameSet) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_frameSet).getCode();

  }
}



    
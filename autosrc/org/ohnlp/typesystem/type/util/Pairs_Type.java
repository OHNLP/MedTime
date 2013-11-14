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
package org.ohnlp.typesystem.type.util;

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

/** A brute force "hash" that stores multiple Pairs in a list. 
Equivalent toMayo cTAKES version 2.5: edu.mayo.bmi.uima.core.type.Properties
 * Updated by JCasGen Sun Sep 29 06:07:12 CDT 2013
 * @generated */
public class Pairs_Type extends TOP_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Pairs_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Pairs_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Pairs(addr, Pairs_Type.this);
  			   Pairs_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Pairs(addr, Pairs_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Pairs.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.util.Pairs");
 
  /** @generated */
  final Feature casFeat_pairs;
  /** @generated */
  final int     casFeatCode_pairs;
  /** @generated */ 
  public int getPairs(int addr) {
        if (featOkTst && casFeat_pairs == null)
      jcas.throwFeatMissing("pairs", "org.ohnlp.typesystem.type.util.Pairs");
    return ll_cas.ll_getRefValue(addr, casFeatCode_pairs);
  }
  /** @generated */    
  public void setPairs(int addr, int v) {
        if (featOkTst && casFeat_pairs == null)
      jcas.throwFeatMissing("pairs", "org.ohnlp.typesystem.type.util.Pairs");
    ll_cas.ll_setRefValue(addr, casFeatCode_pairs, v);}
    
   /** @generated */
  public int getPairs(int addr, int i) {
        if (featOkTst && casFeat_pairs == null)
      jcas.throwFeatMissing("pairs", "org.ohnlp.typesystem.type.util.Pairs");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pairs), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_pairs), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pairs), i);
  }
   
  /** @generated */ 
  public void setPairs(int addr, int i, int v) {
        if (featOkTst && casFeat_pairs == null)
      jcas.throwFeatMissing("pairs", "org.ohnlp.typesystem.type.util.Pairs");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pairs), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_pairs), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_pairs), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Pairs_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_pairs = jcas.getRequiredFeatureDE(casType, "pairs", "uima.cas.FSArray", featOkTst);
    casFeatCode_pairs  = (null == casFeat_pairs) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pairs).getCode();

  }
}



    
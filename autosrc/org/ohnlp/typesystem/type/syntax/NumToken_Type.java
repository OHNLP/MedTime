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
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** Differentiates a token as being a number rather than a punctuation, symbol, newline, word, or contraction. 
Equivalent to Mayo cTAKES version 2.5: edu.mayo.bmi.uima.core.type.NumToken
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * @generated */
public class NumToken_Type extends BaseToken_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NumToken_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NumToken_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NumToken(addr, NumToken_Type.this);
  			   NumToken_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NumToken(addr, NumToken_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NumToken.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.syntax.NumToken");
 
  /** @generated */
  final Feature casFeat_numType;
  /** @generated */
  final int     casFeatCode_numType;
  /** @generated */ 
  public int getNumType(int addr) {
        if (featOkTst && casFeat_numType == null)
      jcas.throwFeatMissing("numType", "org.ohnlp.typesystem.type.syntax.NumToken");
    return ll_cas.ll_getIntValue(addr, casFeatCode_numType);
  }
  /** @generated */    
  public void setNumType(int addr, int v) {
        if (featOkTst && casFeat_numType == null)
      jcas.throwFeatMissing("numType", "org.ohnlp.typesystem.type.syntax.NumToken");
    ll_cas.ll_setIntValue(addr, casFeatCode_numType, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public NumToken_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_numType = jcas.getRequiredFeatureDE(casType, "numType", "uima.cas.Integer", featOkTst);
    casFeatCode_numType  = (null == casFeat_numType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_numType).getCode();

  }
}



    
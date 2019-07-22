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

/** A Penn Treebank Node; as the top node, this stores the whole subsumed sentence's parse tree as a string.  It also stores all the terminals, allowing for traversal of the tree bottom-up (top-down is implied through the TreebankNode's 'children' attribute).
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * @generated */
public class TopTreebankNode_Type extends TreebankNode_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (TopTreebankNode_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = TopTreebankNode_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new TopTreebankNode(addr, TopTreebankNode_Type.this);
  			   TopTreebankNode_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new TopTreebankNode(addr, TopTreebankNode_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TopTreebankNode.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.syntax.TopTreebankNode");
 
  /** @generated */
  final Feature casFeat_treebankParse;
  /** @generated */
  final int     casFeatCode_treebankParse;
  /** @generated */ 
  public String getTreebankParse(int addr) {
        if (featOkTst && casFeat_treebankParse == null)
      jcas.throwFeatMissing("treebankParse", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    return ll_cas.ll_getStringValue(addr, casFeatCode_treebankParse);
  }
  /** @generated */    
  public void setTreebankParse(int addr, String v) {
        if (featOkTst && casFeat_treebankParse == null)
      jcas.throwFeatMissing("treebankParse", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    ll_cas.ll_setStringValue(addr, casFeatCode_treebankParse, v);}
    
  
 
  /** @generated */
  final Feature casFeat_terminals;
  /** @generated */
  final int     casFeatCode_terminals;
  /** @generated */ 
  public int getTerminals(int addr) {
        if (featOkTst && casFeat_terminals == null)
      jcas.throwFeatMissing("terminals", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    return ll_cas.ll_getRefValue(addr, casFeatCode_terminals);
  }
  /** @generated */    
  public void setTerminals(int addr, int v) {
        if (featOkTst && casFeat_terminals == null)
      jcas.throwFeatMissing("terminals", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    ll_cas.ll_setRefValue(addr, casFeatCode_terminals, v);}
    
   /** @generated */
  public int getTerminals(int addr, int i) {
        if (featOkTst && casFeat_terminals == null)
      jcas.throwFeatMissing("terminals", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_terminals), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_terminals), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_terminals), i);
  }
   
  /** @generated */ 
  public void setTerminals(int addr, int i, int v) {
        if (featOkTst && casFeat_terminals == null)
      jcas.throwFeatMissing("terminals", "org.ohnlp.typesystem.type.syntax.TopTreebankNode");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_terminals), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_terminals), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_terminals), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public TopTreebankNode_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_treebankParse = jcas.getRequiredFeatureDE(casType, "treebankParse", "uima.cas.String", featOkTst);
    casFeatCode_treebankParse  = (null == casFeat_treebankParse) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_treebankParse).getCode();

 
    casFeat_terminals = jcas.getRequiredFeatureDE(casType, "terminals", "uima.cas.FSArray", featOkTst);
    casFeatCode_terminals  = (null == casFeat_terminals) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_terminals).getCode();

  }
}



    
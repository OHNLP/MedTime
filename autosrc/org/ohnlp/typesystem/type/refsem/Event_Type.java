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
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** A real-world event; similar to Entity, but may bear some temporal properties and relationships.  In the constrained clinical context, many concepts are discussed as instances with some temporal component, e.g., Medications, Labs.
 * Updated by JCasGen Sun Sep 29 06:07:11 CDT 2013
 * @generated */
public class Event_Type extends Element_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Event_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Event_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Event(addr, Event_Type.this);
  			   Event_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Event(addr, Event_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Event.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.ohnlp.typesystem.type.refsem.Event");
 
  /** @generated */
  final Feature casFeat_properties;
  /** @generated */
  final int     casFeatCode_properties;
  /** @generated */ 
  public int getProperties(int addr) {
        if (featOkTst && casFeat_properties == null)
      jcas.throwFeatMissing("properties", "org.ohnlp.typesystem.type.refsem.Event");
    return ll_cas.ll_getRefValue(addr, casFeatCode_properties);
  }
  /** @generated */    
  public void setProperties(int addr, int v) {
        if (featOkTst && casFeat_properties == null)
      jcas.throwFeatMissing("properties", "org.ohnlp.typesystem.type.refsem.Event");
    ll_cas.ll_setRefValue(addr, casFeatCode_properties, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Event_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_properties = jcas.getRequiredFeatureDE(casType, "properties", "org.ohnlp.typesystem.type.refsem.EventProperties", featOkTst);
    casFeatCode_properties  = (null == casFeat_properties) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_properties).getCode();

  }
}



    
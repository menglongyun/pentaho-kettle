/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2017 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.trans.steps.xmlinputstream;

import org.junit.Before;
import org.junit.Ignore;
import org.pentaho.di.core.row.RowMeta;
import org.pentaho.di.trans.steps.file.BaseFileField;
import org.pentaho.di.trans.steps.fileinput.BaseParsingTest;

/**
 * Base class for all CSV input step tests.
 */
@Ignore( "No tests in abstract base class" )
public class BaseXmlInputStreamParsingTest extends
    BaseParsingTest<XMLInputStreamMeta, XMLInputStreamData, XMLInputStream> {
  /**
   * Initialize step info.
   */
  @Before
  public void before() {
    meta = new XMLInputStreamMeta();
    meta.setDefault();

    data = new XMLInputStreamData();
    data.outputRowMeta = new RowMeta();
  }

  /**
   * Initialize for processing specified file.
   */
  protected void init( String file ) throws Exception {
    meta.setFilename( getFile( file ).getURL().getFile() );

    step = new XMLInputStream( stepMeta, null, 1, transMeta, trans );
    step.init( meta, data );
    step.addRowListener( rowListener );
  }

  /**
   * For BaseFileInput fields.
   */
  @Override
  protected void setFields( BaseFileField... fields ) throws Exception {
    throw new RuntimeException( "Not implemented" );
  }
}

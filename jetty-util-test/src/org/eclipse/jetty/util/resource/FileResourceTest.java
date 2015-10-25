//
//  ========================================================================
//  Copyright (c) 1995-2014 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.junit.Ignore;
import org.junit.Test;

public class FileResourceTest extends AbstractFSResourceTest
{
    @Override
    public Resource newResource(URI uri) throws IOException
    {
        return new FileResource(uri);
    }
    
    @Override
    public Resource newResource(File file) throws IOException
    {
        return new FileResource(file);
    }
    
    @Ignore("Cannot get null to be seen by FileResource")
    @Test
    public void testExist_BadNull() throws Exception
    {
    }

    @Ignore("Validation shouldn't be done in FileResource")
    @Test
    public void testExist_BadNullX() throws Exception
    {
    }
}

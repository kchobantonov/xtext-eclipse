/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextResourceSetBasedProjectProvider implements IJavaProjectProvider {

	@Override
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		if (resourceSet instanceof XtextResourceSet) {
			XtextResourceSet xtextResourceSet = (XtextResourceSet) resourceSet;
			Object context = xtextResourceSet.getClasspathURIContext();
			if (context instanceof IJavaProject)
				return (IJavaProject) context;
		}
		return null;
	}

}

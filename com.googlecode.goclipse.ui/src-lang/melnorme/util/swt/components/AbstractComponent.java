/*******************************************************************************
 * Copyright (c) 2014, 2014 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package melnorme.util.swt.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Simple abstract class for a {@link IWidgetComponent}.
 */
public abstract class AbstractComponent implements IWidgetComponent {
	
	@Override
	public Composite createComponent(Composite parent) {
		Composite topControl = createTopLevelControl(parent);
		createContents(topControl);
		return topControl;
	}
	
	@Override
	public void createComponentInlined(Composite parent) {
		createContents(parent);
	}
	
	protected Composite createTopLevelControl(Composite parent) {
		Composite topControl = new Composite(parent, SWT.NONE);
		createTopLevelControlLayout(topControl);
		return topControl;
	}
	
	protected void createTopLevelControlLayout(Composite topControl) {
		topControl.setLayout(new GridLayout());
	}
	
	protected abstract void createContents(Composite topControl);
	
	/* ----------------- util ----------------- */
	
	/** Do {@link #createComponent(Composite)}, and also set the layou Data of created Control.  */
 	public final Composite createComponent(Composite parent, Object layoutData) {
 		Composite control = createComponent(parent);
 		control.setLayoutData(layoutData);
 		return control;
 	}
	
}
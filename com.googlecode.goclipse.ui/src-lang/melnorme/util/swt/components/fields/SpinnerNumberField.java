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
package melnorme.util.swt.components.fields;

import melnorme.util.swt.SWTFactoryUtil;
import melnorme.util.swt.components.AbstractFieldExt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class SpinnerNumberField extends AbstractFieldExt<Integer> {
	
	protected Label label;
	protected Spinner spinner;
	
	public SpinnerNumberField(String labelText) {
		super(labelText);
	}
	
	@Override
	public Integer getDefaultFieldValue() {
		return 0;
	}
	
	@Override
	protected void createContents_do(Composite topControl) {
		createLabel(topControl);
		createSpinner(topControl);
	}
	
	protected void createLabel(Composite parent) {
		label = SWTFactoryUtil.createLabel(parent, SWT.NONE, labelText, null);
	}
	
	protected void createSpinner(Composite parent) {
		spinner = createFieldSpinner(this, parent, SWT.BORDER);
	}
	
	@Override
	protected void createContents_layout() {
		layout2Controls(label, spinner, false);
	}
	
	public Spinner getSpinner() {
		return spinner;
	}
	
	@Override
	protected Spinner getFieldControl() {
		return spinner;
	}
	
	@Override
	protected void doUpdateComponentFromValue() {
		spinner.setSelection(getFieldValue());
	}
	
	public SpinnerNumberField setValueMinimum(int minimum) {
		spinner.setMinimum(minimum);
		return this;
	}
	
	public SpinnerNumberField setValueMaximum(int maximum) {
		spinner.setMaximum(maximum);
		return this;
	}
	
	public SpinnerNumberField setValueIncrement(int increment) {
		spinner.setIncrement(increment);
		return this;
	}
	
	public void setEnabled(boolean enabled) {
		label.setEnabled(enabled);
		spinner.setEnabled(enabled);
	}
	
}
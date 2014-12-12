/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * @author Jan K�hnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultHighlightingConfiguration implements IHighlightingConfiguration {
	
	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles#KEYWORD_ID} instead
	 */
	@Deprecated
	public static final String KEYWORD_ID = HighlightingStyles.KEYWORD_ID;
	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles#PUNCTUATION_ID} instead
	 */
	@Deprecated
	public static final String PUNCTUATION_ID = HighlightingStyles.PUNCTUATION_ID;
	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles#COMMENT_ID} instead
	 */
	@Deprecated
	public static final String COMMENT_ID = HighlightingStyles.COMMENT_ID;
	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles#STRING_ID} instead
	 */
	@Deprecated
	public static final String STRING_ID = HighlightingStyles.STRING_ID;
	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles#NUMBER_ID} instead
	 */
	@Deprecated
	public static final String NUMBER_ID = HighlightingStyles.NUMBER_ID;
	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles#DEFAULT_ID} instead
	 */
	@Deprecated
	public static final String DEFAULT_ID = HighlightingStyles.DEFAULT_ID;
	/**
	 * @deprecated Use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles#INVALID_TOKEN_ID} instead
	 */
	@Deprecated
	public static final String INVALID_TOKEN_ID = HighlightingStyles.INVALID_TOKEN_ID;
	/**
	 * @since 2.6
	 * 
	 * @deprecated Use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles#INVALID_TOKEN_ID} instead
	 */
	@Deprecated
	public static final String TASK_ID = HighlightingStyles.TASK_ID;

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keywordTextStyle());
		acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, "Punctuation character", punctuationTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());
		acceptor.acceptDefaultHighlighting(TASK_ID, "Task Tag", taskTextStyle());
		acceptor.acceptDefaultHighlighting(STRING_ID, "String", stringTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, "Invalid Symbol", errorTextStyle());
	}
	
	public TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		return textStyle;
	}
	
	public TextStyle errorTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}
	
	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}

	public TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(42, 0, 255));
		return textStyle;
	}

	public TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		return textStyle;
	}
	
	/**
	 * @since 2.6
	 */
	public TextStyle taskTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 159, 191));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle punctuationTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}

}

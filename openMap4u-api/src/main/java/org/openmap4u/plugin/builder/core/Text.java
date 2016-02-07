package org.openmap4u.plugin.builder.core;

import java.awt.Paint;

import org.openmap4u.builder.TextBuilder;
import org.openmap4u.primitive.TextBuildable;
import org.openmap4u.style.FontStyle;
import org.openmap4u.style.FontWeight;
import org.openmap4u.style.TextStyleBuildable;

public class Text extends TextBuilder<Text> implements
		TextStyleBuildable<Text>, TextBuildable<Text> {

	@Override
	public Text fontColor(Paint fontColor) {
		return this;
	}

	@Override
	public Text fontFamily(String fontFamily) {
		this.getDrawable().getStyle().fontFamily(fontFamily);
		return this;
	}

	@Override
	public Text fontSize(double fontSize) {
		this.getDrawable().getStyle().fontSize(fontSize);
		return this;
	}

	@Override
	public Text fontStyle(FontStyle fontStyle) {
		this.getDrawable().getStyle().fontStyle(fontStyle);
		return this;
	}

	@Override
	public Text fontWeight(FontWeight fontWeight) {
		this.getDrawable().getStyle().fontWeight(fontWeight);
		return this;
	}

	@Override
	public Text text(String text) {
		this.getDrawable().getPrimitive().text(text);
		return this;
	}

	@Override
	public Text text(String format, Object... args) {
		this.getDrawable().getPrimitive().text(format, args);
		return this;
	}

}

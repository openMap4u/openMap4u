package org.openmap4u.style;

import java.awt.Paint;

public final class TextStyle extends Style<TextStyle>implements TextStyleable, TextStyleBuildable<TextStyle> {

	public static final TextStyle DEFAULT_TEXT_STYLE = null;

	private Paint fontColor;

	private String fontFamily;

	private double fontSize;

	private FontStyle fontStyle;

	private FontWeight fontWeight;
	
	public TextStyle() {
		super();
		this.fontColor(DEFAULT_FONT_COLOR).fontSize(DEFAULT_FONT_SIZE).fontFamily(DEFAULT_FONT_FAMILY).fontStyle(FontStyle.DEFAULT).fontWeight(FontWeight.DEFAULT);
	}

	@Override
	public TextStyle fontColor(Paint fontColor) {
		this.fontColor = fontColor;
		return this;
	}

	@Override
	public TextStyle fontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
		return this;
	}

	@Override
	public TextStyle fontSize(double fontSize) {
		this.fontSize = fontSize;
		return this;

	}

	@Override
	public TextStyle fontStyle(FontStyle fontStyle) {
		this.fontStyle = fontStyle;
		return this;
	}

	@Override
	public TextStyle fontWeight(FontWeight fontWeight) {
		this.fontWeight = fontWeight;
		return this;
	}

	@Override
	public Paint getFontColor() {
		return this.fontColor;
	}

	@Override
	public String getFontFamily() {
		return this.fontFamily;
	}

	@Override
	public double getFontSize() {
		return this.fontSize;
	}

	@Override
	public FontWeight getFontWeight() {
		return this.fontWeight;
	}

	@Override
	public FontStyle getFontStyle() {
		return this.fontStyle;
	}

	public boolean equals(Object object) {
		boolean equals = false;
		if (object instanceof TextStyle) {
			TextStyle obj = (TextStyle) object;
			return super.equals(object) && this.getFontColor() == obj.getFontColor() && this.getFontFamily() == obj.getFontFamily()
					&& this.getFontSize() == obj.getFontSize() && this.getFontStyle() == obj.getFontStyle()
					&& this.getFontWeight() == obj.getFontWeight();
		}
		return equals;

	}

}

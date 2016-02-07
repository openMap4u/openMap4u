package org.openmap4u.primitive;

public final class TextPrimitive extends Primitive<TextPrimitive> implements
		Textable, TextBuildable<TextPrimitive> {

	private String text;

	@Override
	public TextPrimitive text(String text) {
		this.text = text;
		return this;
	}

	@Override
	public TextPrimitive text(String format, Object... args) {
		return text(String.format(format, args));
	}

	@Override
	public String getText() {
		return text;
	}

}

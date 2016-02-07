package org.openmap4u.primitive;


public interface TextBuildable<T extends TextBuildable<T>> extends
		PrimitiveBuildable<T> {

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            The text.
	 * @return The Text itself (method chaining pattern).
	 */
	T text(String text);

	/**
	 * Formats the arguments with the given format template.
	 *
	 * @param format
	 *            The format template.
	 * @param args
	 *            The arguments.
	 * @return The Text itself (method chaining pattern).
	 */
	T text(String format, Object... args);

}

package org.openmap4u.builder;

import org.openmap4u.common.Plugable;

/**
 * All builders are derives from this base interface.
 * @author Michael Hadrbolec.
 *
 * @param <T> The builder type.
 */
public interface Buildable<T> extends Plugable {

	/**
	 * Builds the object.
	 * @return The object.
	 */
	T build();
	
}

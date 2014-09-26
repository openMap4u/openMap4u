package org.openmap4u.commons;

/**
 * All builders are derives from this base interface.
 * @author MIchael Hadrbolec.
 *
 * @param <T> The builder type.
 */
public interface Buildable<T> {

	
	T build();
	
}

package org.openmap4u.style;

public abstract class Style<T extends Style<T>> implements Styleable, StyleBuildable<T> {

	public static boolean DEFAULT_VISIBLE = true;

	public static double DEFAULT_ALPHA = 1;

	private double alpha;

	private boolean visible;
	
	public Style() {
		super();
		this.alpha(DEFAULT_ALPHA).visible(DEFAULT_VISIBILITY);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public T alpha(double alpha) {
		this.alpha = alpha;
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T visible(boolean visible) {
		this.visible = visible;
		return (T) this;
	}

	@Override
	public double getAlpha() {
		return alpha;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public boolean equals(Object object) {
		boolean equals = false;
		if (object instanceof Style) {
			Style obj = (Style) object;
			return this.getAlpha() == obj.getAlpha() && this.isVisible() == obj.isVisible();
		}
		return equals;

	}

}

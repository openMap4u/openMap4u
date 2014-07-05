package org.openmap4u;

import org.openmap4u.format.Outputable;

/**
 * Helper class to generate File names.
 * @author Michael Hadrbolec
 *
 */
public class OutputFormat {

	/**
	 * Stores the file extension.
	 */
	private String mFileExtension = null;
	
	/**
	 * Stores the output format.
	 */
	private Class<? extends Outputable> mOutputableFormat = null;

	/**
	 * Creates a new output format class.
	 * @param outputFormat The output format.
	 * @param fileExtension The file extension of the output format.
	 */
	public OutputFormat(Class<? extends Outputable> outputFormat,
			String fileExtension) {
		this.mFileExtension = fileExtension;
		this.mOutputableFormat = outputFormat;
	}

	/**
	 * Creates a filename based on the given fragments sperated by "_" and the output format extension.
	 * @param fileNameFragments The file name fragments.
	 * @return The file name.
	 */
	public String getFileneame(String... fileNameFragments) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fileNameFragments.length; i++) {
			if (i > 0) {
				sb.append("_");
			}
			sb.append(fileNameFragments[i]);
		}
		return sb.append(".").append(this.mFileExtension).toString();
	}

	/**
	 * Gets the file extension.
	 * @return The file extension.
	 */
	public String getFileExtension() {
		return this.mFileExtension;
	}

	/**
	 * Gets the output format.
	 * @return The output format.
	 */
	public Class<? extends Outputable> getOutputableFormat() {
		return this.mOutputableFormat;
	}

}

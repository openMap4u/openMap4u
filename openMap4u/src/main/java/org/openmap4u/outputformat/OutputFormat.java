package org.openmap4u.outputformat;

import javax.activation.MimeType;

/**
 * All concrete output formats implementations are derived from this base
 * clasee.
 * 
 * @author Michael Hadrbolec
 * 
 */
public abstract class OutputFormat implements OutputableFormat {

    /**
     * Stores the mime type.
     */
    private final MimeType mMimeType;

    /**
     * Creates a new instance.
     * 
     * @param mimeType
     *            The mime type of the ouput format.
     */
    protected OutputFormat(MimeType mimeType) {
        this.mMimeType = mimeType;
    }

    /**
     * Gets the mime type of the output format.
     * 
     * @return The mime type of the output format.
     */
    public final MimeType getMimeType() {
        return this.mMimeType;
    }

}

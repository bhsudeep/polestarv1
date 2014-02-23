
package com.sample.common;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class GZIPResponseWrapper.
 */
public class GZIPResponseWrapper extends HttpServletResponseWrapper {
	
	/** The orig response. */
	protected HttpServletResponse origResponse = null;
	
	/** The stream. */
	protected ServletOutputStream stream = null;
	
	/** The writer. */
	protected PrintWriter writer = null;

	/**
	 * Instantiates a new gZIP response wrapper.
	 * 
	 * @param response the response
	 */
	public GZIPResponseWrapper(HttpServletResponse response) {
		super(response);
		origResponse = response;
	}

	/**
	 * Creates the output stream.
	 * 
	 * @return the servlet output stream
	 * 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ServletOutputStream createOutputStream() throws IOException {
		return (new GZIPResponseStream(origResponse));
	}

	/**
	 * Finish response.
	 */
	public void finishResponse() {
		try {
			if (writer != null) {
				writer.close();
			} else {
				if (stream != null) {
					stream.close();
				}
			}
		} catch (IOException e) {
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#flushBuffer()
	 */
	public void flushBuffer() throws IOException {
		stream.flush();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#getOutputStream()
	 */
	public ServletOutputStream getOutputStream() throws IOException {
		if (writer != null) {
			throw new IllegalStateException(
					"getWriter() has already been called!");
		}

		if (stream == null)
			stream = createOutputStream();
		return (stream);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#getWriter()
	 */
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return (writer);
		}

		if (stream != null) {
			throw new IllegalStateException(
					"getOutputStream() has already been called!");
		}

		stream = createOutputStream();
		writer = new PrintWriter(new OutputStreamWriter(stream, "UTF-8"));
		return (writer);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#setContentLength(int)
	 */
	public void setContentLength(int length) {
	}
}

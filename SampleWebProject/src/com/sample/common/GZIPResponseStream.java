package com.sample.common;

import java.io.*;
import java.util.zip.GZIPOutputStream;
import javax.servlet.*;
import javax.servlet.http.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GZIPResponseStream.
 */
public class GZIPResponseStream extends ServletOutputStream {

	/** The baos. */
	protected ByteArrayOutputStream baos = null;

	/** The gzipstream. */
	protected GZIPOutputStream gzipstream = null;

	/** The closed. */
	protected boolean closed = false;

	/** The response. */
	protected HttpServletResponse response = null;

	/** The output. */
	protected ServletOutputStream output = null;

	/**
	 * Instantiates a new gZIP response stream.
	 * 
	 * @param response
	 *            the response
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public GZIPResponseStream(HttpServletResponse response) throws IOException {
		super();
		closed = false;
		this.response = response;
		this.output = response.getOutputStream();
		baos = new ByteArrayOutputStream();
		gzipstream = new GZIPOutputStream(baos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.OutputStream#close()
	 */
	public void close() throws IOException {
		if (closed) {
			throw new IOException("This output stream has already been closed");
		}
		gzipstream.finish();

		byte[] bytes = baos.toByteArray();

		response.addHeader("Content-Length", Integer.toString(bytes.length));
		response.addHeader("Content-Encoding", "gzip");
		output.write(bytes);
		output.flush();
		output.close();
		closed = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.OutputStream#flush()
	 */
	public void flush() throws IOException {
		if (closed) {
			throw new IOException("Cannot flush a closed output stream");
		}
		gzipstream.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.OutputStream#write(int)
	 */
	public void write(int b) throws IOException {
		if (closed) {
			throw new IOException("Cannot write to a closed output stream");
		}
		gzipstream.write((byte) b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.OutputStream#write(byte[])
	 */
	public void write(byte b[]) throws IOException {
		write(b, 0, b.length);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.OutputStream#write(byte[], int, int)
	 */
	public void write(byte b[], int off, int len) throws IOException {
		if (closed) {
			throw new IOException("Cannot write to a closed output stream");
		}
		gzipstream.write(b, off, len);
	}

	/**
	 * Closed.
	 * 
	 * @return true, if successful
	 */
	public boolean closed() {
		return (this.closed);
	}

	/**
	 * Reset.
	 */
	public void reset() {
		// noop
	}
}

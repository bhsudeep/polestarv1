
package com.sample.common;

import java.io.IOException;
import java.text.StringCharacterIterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

// TODO: Auto-generated Javadoc
/**
 * The Class XssFilter.
 */
public final class XssFilter implements Filter {

	/**
	 * The Class FilteredRequest.
	 */
	static class FilteredRequest extends HttpServletRequestWrapper {

		/**
		 * Instantiates a new filtered request.
		 * 
		 * @param request the request
		 */
		public FilteredRequest(ServletRequest request) {
			super((HttpServletRequest) request);
		}

		/* Sanitized against following tags *
			<applet> 
			<body> 
			<embed> 
			<frame> 
			<script> 
			<frameset> 
			<html> 
			<iframe> 
			<img> 
			<style> 
			<layer> 
			<link> 
			<ilayer> 
			<meta> 
			<object>
		 */
		
		/**
		 * Sanitize.
		 * 
		 * @param input the input
		 * 
		 * @return the string
		 */
		public static String sanitize(String input) {
			if(input == null) return input;
		  input =  input
		     .replaceAll("(?i)<script.*?>.*?</script.*?>", "")   
		     .replaceAll("(?i)<applet.*?>.*?</applet.*?>", "")
		     .replaceAll("(?i)<body.*?>.*?</body.*?>", "")
		     .replaceAll("(?i)<embed.*?>.*?</embed.*?>", "")
		     .replaceAll("(?i)<frame.*?>.*?</frame.*?>", "")
		     .replaceAll("(?i)<frameset.*?>.*?</frameset.*?>", "")
		     .replaceAll("(?i)<html.*?>.*?</html.*?>", "")
		     .replaceAll("(?i)<iframe.*?>.*?</iframe.*?>", "")
		     .replaceAll("(?i)<img.*?>.*?</img.*?>", "")
		     .replaceAll("(?i)<style.*?>.*?</style.*?>", "")
		     .replaceAll("(?i)<layer.*?>.*?</layer.*?>", "")
		     .replaceAll("(?i)<link.*?>.*?</link.*?>", "")
		     .replaceAll("(?i)<ilayer.*?>.*?</ilayer.*?>", "")
		     .replaceAll("(?i)<meta.*?>.*?</meta.*?>", "")
		     .replaceAll("(?i)<object.*?>.*?</object.*?>", "")
		     .replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "") 
		     .replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");    
		  
		  // Escape quotes
		  return escapeQuote(input);
		  
		}

		/* (non-Javadoc)
		 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
		 */
		public String getParameter(String paramName) {
			String value = super.getParameter(paramName);
			value = sanitize(value);
			return value;
		}

		/* (non-Javadoc)
		 * @see javax.servlet.ServletRequestWrapper#getParameterValues(java.lang.String)
		 */
		public String[] getParameterValues(String paramName) {
			String values[] = super.getParameterValues(paramName);
			for (int index = 0; index < values.length; index++) {
				values[index] = sanitize(values[index]);
			}
			return values;
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new FilteredRequest(request), response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) {
	}
	
	
	/**
	 * Escape quote.
	 * 
	 * @param s the s
	 * 
	 * @return the string
	 */
	private static String escapeQuote(String s){
		   if (s == null)
			   return "";
		   StringBuffer sb = new StringBuffer();
		   int n = s.length();
		   for (int i = 0; i < n; i++) {
		      char c = s.charAt(i);
		      switch (c) {
		      	 case '’': sb.append("'");break;
		         case '“': sb.append("\""); break;
		         case '”': sb.append("\""); break;
		         default:  sb.append(c); break;
		      }
		   }
		   return sb.toString();
	}
}

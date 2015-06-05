package org.skycrawl.search.commons;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;

public abstract class EscapeUtils
{
	private static Encoder encoder = ESAPI.encoder();
	
	public static String escapeHTMLinner(String input)
	{
		 return encoder.encodeForHTML(input);
	}
	
	public static String escapeHTMLAttribute(String input)
	{
		return encoder.encodeForHTMLAttribute(input);
	}
}

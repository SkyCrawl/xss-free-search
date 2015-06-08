package org.skycrawl.search.commons;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.errors.EncodingException;

public abstract class EscapeUtils
{
	private static Encoder encoder = ESAPI.encoder();
	
	public static String escapeAsTag(String input)
	{
		 return encoder.encodeForHTML(input);
	}
	
	public static String escapeAsAttr(String input)
	{
		return encoder.encodeForHTMLAttribute(input);
	}
	
	public static String escapeAsCSS(String input)
	{
		return encoder.encodeForCSS(input);
	}
	
	public static String escapeAsJS(String input)
	{
		return encoder.encodeForJavaScript(input);
	}
	
	public static String escapeAsURL(String input) throws EncodingException
	{
		return encoder.encodeForURL(input);
	}
}

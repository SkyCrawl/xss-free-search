package org.skycrawl.search.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.owasp.esapi.errors.EncodingException;
import org.skycrawl.search.commons.EscapeUtils;

@Path("/escape")
public class EscapeService
{
	/*
	 * TODO: XML escape is missing but it is not needed anyway...
	 */
	
	@GET
	@Path("/htmlTag/{input}")
	@Consumes({ "text/plain", "text/richtext", "text/html" })
	@Produces({ "text/plain", "text/richtext", "text/html" })
	public String escapeAsTag(@PathParam("input") String input)
	{
		return EscapeUtils.escapeAsTag(input);
	}
	
	@GET
	@Path("/htmlAttr/{input}")
	@Consumes({ "text/plain", "text/richtext", "text/html" })
	@Produces({ "text/plain", "text/richtext", "text/html" })
	public String escapeAsAttr(@PathParam("input") String input)
	{
		return EscapeUtils.escapeAsAttr(input);
	}
	
	@GET
	@Path("/css/{input}")
	@Consumes({ "text/plain", "text/css" })
	@Produces({ "text/plain", "text/css" })
	public String escapeAsCSS(@PathParam("input") String input)
	{
		return EscapeUtils.escapeAsCSS(input);
	}
	
	@GET
	@Path("/js/{input}")
	@Consumes({ "text/plain", "text/javascript", "text/ecmascript" })
	@Produces({ "text/plain", "text/javascript", "text/ecmascript" })
	public String escapeAsJavascript(@PathParam("input") String input)
	{
		return EscapeUtils.escapeAsJS(input);
	}
	
	@GET
	@Path("url/{input}")
	@Consumes({ "text/plain", "text/uri-list", "text/html" })
	@Produces({ "text/plain", "text/uri-list", "text/html" })
	public String escapeAsURL(@PathParam("input") String input) throws EncodingException
	{
		return EscapeUtils.escapeAsURL(input);
	}
}

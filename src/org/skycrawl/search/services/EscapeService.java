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
	 * TODO: parameters should rather be included in request body as servlet containers may have problems with some characters...
	 */
	
	@GET
	@Path("/htmlTag/{input}")
	@Consumes({ "text/plain; charset=utf-8", "text/richtext; charset=utf-8", "text/html; charset=utf-8" })
	@Produces({ "text/plain; charset=utf-8", "text/richtext; charset=utf-8", "text/html; charset=utf-8" })
	public String escapeAsTag(@PathParam("input") String input)
	{
		return EscapeUtils.escapeAsTag(input);
	}
	
	@GET
	@Path("/htmlAttr/{input}")
	@Consumes({ "text/plain; charset=utf-8", "text/richtext; charset=utf-8", "text/html; charset=utf-8" })
	@Produces({ "text/plain; charset=utf-8", "text/richtext; charset=utf-8", "text/html; charset=utf-8" })
	public String escapeAsAttr(@PathParam("input") String input)
	{
		return EscapeUtils.escapeAsAttr(input);
	}
	
	@GET
	@Path("/css/{input}")
	@Consumes({ "text/plain; charset=utf-8", "text/css; charset=utf-8" })
	@Produces({ "text/plain; charset=utf-8", "text/css; charset=utf-8" })
	public String escapeAsCSS(@PathParam("input") String input)
	{
		return EscapeUtils.escapeAsCSS(input);
	}
	
	@GET
	@Path("/js/{input}")
	@Consumes({ "text/plain; charset=utf-8", "text/javascript; charset=utf-8", "text/ecmascript; charset=utf-8" })
	@Produces({ "text/plain; charset=utf-8", "text/javascript; charset=utf-8", "text/ecmascript; charset=utf-8" })
	public String escapeAsJavascript(@PathParam("input") String input)
	{
		return EscapeUtils.escapeAsJS(input);
	}
	
	@GET
	@Path("url/{input}")
	@Consumes({ "text/plain", "text/uri-list; charset=utf-8", "text/html; charset=utf-8" })
	@Produces({ "text/plain", "text/uri-list; charset=utf-8", "text/html; charset=utf-8" })
	public String escapeAsURL(@PathParam("input") String input) throws EncodingException
	{
		return EscapeUtils.escapeAsURL(input);
	}
}

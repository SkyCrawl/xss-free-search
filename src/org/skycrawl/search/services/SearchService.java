package org.skycrawl.search.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.owasp.esapi.errors.EncodingException;
import org.skycrawl.search.commons.EscapeUtils;
import org.skycrawl.search.core.DataMockup;
import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.core.templating.views.search.SearchView;

@Path("/search")
public class SearchService
{
	@POST
	@Path("/body")
	@Consumes("text/plain; charset=utf-8")
	@Produces("text/html; charset=utf-8")
	public String body(String requestBody) throws EncodingException
	{
		return searchViewWithQuery(requestBody);
	}
	
	@GET
	@Path("/param")
	@Consumes("text/plain; charset=utf-8")
	@Produces("text/html; charset=utf-8")
	// @Encode
	public String param(@QueryParam("query") String query) throws EncodingException
	{
		return searchViewWithQuery(query);
	}
	
	private String searchViewWithQuery(String query) throws EncodingException
	{
		System.out.println("Before unescaping: " + query);
		
		SearchView view = new SearchView();
		view.setSearchTerm(EscapeUtils.unescapeAsURL(query));
		
		System.out.println("Unescaped: " + view.getSearchTerm());
		
		view.setSearchResults(DataMockup.search(view.getSearchTerm()));
		return RythmTemplates.viewSearchResultsForAjax(view);
	}
}

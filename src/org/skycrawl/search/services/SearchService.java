package org.skycrawl.search.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
	public String body(String requestBody)
	{
		// no need to unescape - request body can contain pretty much any character...
		return searchViewWithQuery(requestBody);
	}
	
	@GET
	@Path("/param")
	@Consumes("text/plain; charset=utf-8")
	@Produces("text/html; charset=utf-8")
	public String param(@QueryParam("query") String query)
	{
		// no need to unescape - framework does that for us...
		return searchViewWithQuery(query);
	}
	
	private String searchViewWithQuery(String unescapedQuery)
	{
		SearchView view = new SearchView();
		view.setSearchTerm(unescapedQuery);
		view.setSearchResults(DataMockup.search(view.getSearchTerm()));
		return RythmTemplates.viewSearchResultsForAjax(view);
	}
}

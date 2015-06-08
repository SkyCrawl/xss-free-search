package org.skycrawl.search.core.templating.views.search;

import java.util.List;

import org.skycrawl.search.core.templating.views.AbstractRythmView;

public class SearchView extends AbstractRythmView
{
	private String searchTerm;
	private List<SearchResultView> searchResults;
	
	public SearchView()
	{
		super();
	}
	
	public String getSearchTerm()
	{
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm)
	{
		this.searchTerm = searchTerm;
	}

	public List<SearchResultView> getSearchResults()
	{
		return searchResults;
	}
	public void setSearchResults(List<SearchResultView> searchResults)
	{
		this.searchResults = searchResults;
	}
}

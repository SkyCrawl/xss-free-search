package org.skycrawl.search.core.templating.views;

import java.util.List;

import org.skycrawl.search.commons.AppUtils;

public class PassbackView extends AbstractRythmView
{
	private static final long	serialVersionUID	= -6847219753608011121L;
	
	/*
	 * Remember that all declared view options/fields must have identical names and values.
	 */
	
	// @MVAddHas
	// @MVSanitize(filters = { EscapeHTMLAttributeFilter.class })
	private final String searchTerm = "searchTerm";
	private final String searchResults = "searchResults";
	
	public PassbackView()
	{
		super();
	}
	
	public String getSearchTerm()
	{
		return getItem(searchTerm);
	}
	public void setSearchTerm(String searchTerm)
	{
		setItem(this, this.searchTerm, searchTerm);
	}
	public Boolean hasSearchTerm()
	{
		return AppUtils.isObjectDefined(getSearchTerm());
	}

	public List<SearchResultView> getSearchResults()
	{
		return getItem(searchResults);
	}
	public void setSearchResults(List<SearchResultView> searchResults)
	{
		setItem(this, this.searchResults, searchResults);
	}
}

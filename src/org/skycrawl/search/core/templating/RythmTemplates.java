package org.skycrawl.search.core.templating;

import org.rythmengine.Rythm;
import org.skycrawl.search.core.templating.views.SettingsView;
import org.skycrawl.search.core.templating.views.search.SearchView;

public abstract class RythmTemplates
{
	//---------------------------------------------------------------
	// SEARCH PAGES
	
	public static String viewPageback(SearchView view)
	{
		return Rythm.render("pageback.rythm", view);
	}
	
	public static String viewFrameback(SearchView view)
	{
		return Rythm.render("frameback.rythm", view);
	}
	
	public static String viewSearchback(SearchView view)
	{
		return Rythm.render("searchback.rythm", view);
	}
	
	//---------------------------------------------------------------
	// OTHER PAGES AND COMPONENTS

	public static String viewPayloads()
	{
		return Rythm.render("components/maliciousPaylods.rythm");
	}
	
	public static String viewSettings(SettingsView view)
	{
		return Rythm.render("settings.rythm", view);
	}
	
	public static String viewSearchResultsForIFrame(SearchView view)
	{
		return Rythm.render("components/searchResultsWrapped.rythm", view);
	}
	
	public static String viewSearchResultsForAjax(SearchView view)
	{
		return Rythm.render("components/searchResults.rythm", view);
	}
}

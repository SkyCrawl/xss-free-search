package org.skycrawl.search.core.templating;

import org.rythmengine.Rythm;
import org.skycrawl.search.core.templating.views.SettingsView;
import org.skycrawl.search.core.templating.views.search.SearchView;

public abstract class RythmTemplates
{
	public static String viewPassback(SearchView view)
	{
		return Rythm.render("passback.rythm", view);
	}
	
	public static String viewFrameback(SearchView view)
	{
		return Rythm.render("frameback.rythm", view);
	}
	
	public static String viewSearchResults(SearchView view)
	{
		return Rythm.render("components/searchResultsWrapped.rythm", view, true);
	}
	
	public static String viewSettings(SettingsView view)
	{
		return Rythm.render("settings.rythm", view);
	}
}

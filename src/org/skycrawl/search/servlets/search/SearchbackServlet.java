package org.skycrawl.search.servlets.search;

import javax.servlet.annotation.WebServlet;

import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.core.templating.views.search.SearchView;
import org.skycrawl.search.servlets.AbstractSearchServlet;

@WebServlet("/searchback")
public class SearchbackServlet extends AbstractSearchServlet
{
	private static final long	serialVersionUID	= 4190325622871998579L;

	@Override
	protected String getViewOutput(SearchView view)
	{
		return RythmTemplates.viewSearchback(view);
	}
}

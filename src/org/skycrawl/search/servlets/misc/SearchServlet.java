package org.skycrawl.search.servlets.misc;

import javax.servlet.annotation.WebServlet;

import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.core.templating.views.search.SearchView;
import org.skycrawl.search.servlets.AbstractSearchServlet;

@WebServlet("/search")
public class SearchServlet extends AbstractSearchServlet
{
	private static final long	serialVersionUID	= -5690139745706290143L;
	
	@Override
	protected String getViewOutput(SearchView view)
	{
		return RythmTemplates.viewSearchResultsForIFrame(view);
	}
}

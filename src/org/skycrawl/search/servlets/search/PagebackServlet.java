package org.skycrawl.search.servlets.search;

import javax.servlet.annotation.WebServlet;

import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.core.templating.views.search.SearchView;
import org.skycrawl.search.servlets.AbstractSearchServlet;

@WebServlet("/pageback")
public class PagebackServlet extends AbstractSearchServlet
{
	private static final long	serialVersionUID	= 1083632543075462346L;

	@Override
	protected String getViewOutput(SearchView view)
	{
		return RythmTemplates.viewPageback(view);
	}
}

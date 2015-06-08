package org.skycrawl.search.servlets.search;

import javax.servlet.annotation.WebServlet;

import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.core.templating.views.search.SearchView;
import org.skycrawl.search.servlets.AbstractSearchServlet;

@WebServlet("/frameback")
public class FramebackServlet extends AbstractSearchServlet
{
	private static final long	serialVersionUID	= 4729561042077355414L;

	@Override
	protected String getViewOutput(SearchView view)
	{
		return RythmTemplates.viewFrameback(view);
	}
}

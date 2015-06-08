package org.skycrawl.search.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.skycrawl.search.core.DataMockup;
import org.skycrawl.search.core.templating.views.search.SearchView;

public abstract class AbstractSearchServlet extends AbstractServlet
{
	private static final long	serialVersionUID	= -7531697610824391170L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		super.doGet(request, response);
		
		String searchParam = request.getParameter("search");
		
		SearchView view = new SearchView();
		view.setSearchTerm(searchParam);
		view.setSearchResults(DataMockup.search(searchParam));
		
		response.getWriter().print(getViewOutput(view));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendError(HttpServletResponse.SC_NOT_FOUND, "Use GET method instead.");
	}
	
	protected abstract String getViewOutput(SearchView view);
}

package org.skycrawl.search.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.skycrawl.search.core.DataMockup;
import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.core.templating.views.PassbackView;

@WebServlet("/passback")
public class PassbackServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassbackServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PassbackView view = new PassbackView();
		view.setSearchTerm(request.getParameter("search"));
		if(view.hasSearchTerm())
		{
			view.setSearchResults(DataMockup.search(view.getSearchTerm()));
		}
		response.getWriter().print(RythmTemplates.viewPassback(view));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.sendError(HttpServletResponse.SC_NOT_FOUND, "Use GET method instead.");
	}
}

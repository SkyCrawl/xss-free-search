package org.skycrawl.search.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.skycrawl.search.commons.settings.Settings;
import org.skycrawl.search.core.templating.RythmTemplates;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SettingsServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().print(RythmTemplates.viewSettings(Settings.toView()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		if ("apply".equalsIgnoreCase(action))
		{
			Enumeration<String> paramNames = request.getParameterNames();
			while(paramNames.hasMoreElements())
			{
				String paramName = paramNames.nextElement();
				if(! "action".equalsIgnoreCase(paramName))
				{
					Settings.toView().applyChange(paramName, request.getParameter(paramName));
				}
			}
		}
		else if ("restore".equalsIgnoreCase(action))
		{
			Settings.toView().restoreDefaults();
		}
		doGet(request, response);
	}
}

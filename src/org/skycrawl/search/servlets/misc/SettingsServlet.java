package org.skycrawl.search.servlets.misc;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.skycrawl.search.commons.settings.Settings;
import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.servlets.AbstractServlet;

@WebServlet("/settings")
public class SettingsServlet extends AbstractServlet
{
	private static final long	serialVersionUID	= 6689221057847930345L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		super.doGet(request, response);
		response.getWriter().print(RythmTemplates.viewSettings(Settings.toView()));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements())
		{
			String paramName = paramNames.nextElement();
			Settings.toView().applyChange(paramName, request.getParameter(paramName));
		}
		doGet(request, response);
	}
}

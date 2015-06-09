package org.skycrawl.search.servlets.misc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.servlets.AbstractServlet;

@WebServlet("/payloads")
public class PayloadsServlet extends AbstractServlet
{
	private static final long	serialVersionUID	= 5811932783024264430L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		super.doGet(request, response);
		
		response.getWriter().print(RythmTemplates.viewPayloads());
	}
}

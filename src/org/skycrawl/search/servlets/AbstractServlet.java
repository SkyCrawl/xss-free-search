package org.skycrawl.search.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.net.MediaType;

public abstract class AbstractServlet extends HttpServlet
{
	private static final long	serialVersionUID	= -8484850198652836918L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType(getMimeType().toString());
	}
	
	protected MediaType getMimeType()
	{
		return MediaType.HTML_UTF_8;
	}
}

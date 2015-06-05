package org.skycrawl.search.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.skycrawl.search.commons.settings.Settings;

@WebFilter(filterName = "AddResponseHeadersFilter", description = "Sets HTTP response headers for all servlets.")
public class AddResponseHeadersFilter implements Filter
{
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Settings.applyHeadersToResponse(httpResponse);
		chain.doFilter(request, response);
	}
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
	}
}

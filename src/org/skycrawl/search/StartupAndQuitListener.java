package org.skycrawl.search;

import java.util.logging.Level;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.skycrawl.search.commons.IOUtils;
import org.skycrawl.search.commons.logging.Logger;

/**
 * Application life cycle event listener. Provides routines for startup/shutdown
 * of the web application.
 * 
 * @author SkyCrawl
 */
@WebListener
public class StartupAndQuitListener implements ServletContextListener
{
	/**
	 * Application startup event.
	 */
	@Override
	public void contextInitialized(ServletContextEvent event)
	{
		IOUtils.setAbsoluteBaseAppPath(event.getServletContext().getRealPath("/"));
		System.setProperty("org.owasp.esapi.resources", IOUtils.joinPathComponents(IOUtils.getAbsoluteWEBINFPath(), "esapi"));
		Logger.log(Level.INFO, String.format("Using template directory: %s", IOUtils.getAbsoluteBaseAppPath()));
	}

	/**
	 * Application shutdown event.
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
	}
}
package org.skycrawl.search;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.rythmengine.Rythm;
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
		// print some info
		Logger.log(Level.INFO, "Application starting up...");
		
		// init IOUtils
		IOUtils.setAbsoluteBaseAppPath(event.getServletContext().getRealPath("/"));
		
		// init ESAPI
		System.setProperty("org.owasp.esapi.resources", IOUtils.joinPathComponents(IOUtils.getAbsoluteWEBINFPath(), "esapi"));
		
		// init Rythm engine
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("home.template", IOUtils.getAbsoluteBaseAppPath());
        // map.put("home.tmp", IOUtils.joinPathComponents(IOUtils.getAbsoluteWEBINFPath(), "classes"));
        // map.put("home.precompiled", IOUtils.joinPathComponents(IOUtils.getAbsoluteWEBINFPath(), "classes"));
        map.put("engine.file_write", true);
        map.put("engine.mode", "prod"); // development mode causes an error (can not find "searchresults") on repeated launch - the above additional settings and a clean resolve it...
        map.put("feature.smart_escape", false);
        Rythm.init(map);
        
        // print some info
        Logger.log(Level.INFO, "Application started up successfully...");
		Logger.log(Level.INFO, String.format("Using template directory: %s", IOUtils.getAbsoluteBaseAppPath()));
	}

	/**
	 * Application shutdown event.
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		// print some info
        Logger.log(Level.INFO, "Application shutting down...");
		
		Rythm.shutdown();
		
		// print some info
        Logger.log(Level.INFO, "Application shut down successfully...");
	}
}
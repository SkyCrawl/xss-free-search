package org.skycrawl.search.commons.logging;

import java.util.logging.Level;

/**
 * Special logger wrapper to be used by the web application.
 * 
 * @author SkyCrawl
 */
public class Logger extends AbstractLogger
{
	private static final IMyLogger	innerLogger	= createPikaterLogger(java.util.logging.Logger.getLogger("CONSOLE"));

	public static IMyLogger getLogger()
	{
		return innerLogger;
	}

	public static void logThrowable(String message, Throwable t)
	{
		getLogger().logThrowable(message, t);
	}

	public static void log(Level logLevel, String message)
	{
		getLogger().log(logLevel, message);
	}

	public static void log(Level logLevel, String source, String message)
	{
		getLogger().log(logLevel, source, message);
	}
}
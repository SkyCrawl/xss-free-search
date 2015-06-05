package org.skycrawl.search.commons.logging;

import java.util.logging.Level;

/**
 * General/generic interface for all loggers of our application.
 * 
 * @author SkyCrawl
 */
public interface IMyLogger
{
	void log(Level logLevel, String source, String message);
	void logThrowable(String message, Throwable t);
	void log(Level logLevel, String message);
}
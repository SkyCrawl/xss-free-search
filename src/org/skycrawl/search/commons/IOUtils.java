package org.skycrawl.search.commons;

/**
 * Utility class handling some common tasks related to files and paths.
 * 
 * @author SkyCrawl
 */
public class IOUtils
{
	private static String	baseAbsAppPath	= null;

	/**
	 * This method must be called prior to using any other path-related methods from this class.
	 * 
	 * @param baseAbsAppPath absolute path to this application (the "src" folder's parent folder)
	 */
	public static void setAbsoluteBaseAppPath(String baseAbsAppPath)
	{
		IOUtils.baseAbsAppPath = baseAbsAppPath;
	}

	/**
	 * Gets the path set with {@link #setAbsoluteBaseAppPath(String)}. If null, throws an exception.
	 */
	public static String getAbsoluteBaseAppPath()
	{
		if (baseAbsAppPath == null)
		{
			throw new IllegalStateException("The base application path has not been set.");
		}
		return baseAbsAppPath;
	}

	/**
	 * {@link #setAbsoluteBaseAppPath(String)} needs to be called before using this method.
	 */
	public static String getAbsoluteWEBINFPath()
	{
		return joinPathComponents(getAbsoluteBaseAppPath(), "WEB-INF");
	}

	/**
	 * Abstract method to join string-defined paths. Automatically handles directory separation.
	 * 
	 * @param suffixPath may denote a directory or file but must NOT be an absolute path
	 */
	public static String joinPathComponents(String prefixPath, String suffixPath)
	{
		StringBuilder result = new StringBuilder();
		result.append(prefixPath);
		if (!prefixPath.endsWith(System.getProperty("file.separator")))
		{
			result.append(System.getProperty("file.separator"));
		}
		if (suffixPath.startsWith(System.getProperty("file.separator")))
		{
			throw new IllegalArgumentException("The suffix path must not be absolute.");
		}
		result.append(suffixPath);
		return result.toString();
	}
}

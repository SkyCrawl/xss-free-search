package org.skycrawl.search.core.templating.views;

public class SettingsView extends AbstractRythmView
{
	private static final long	serialVersionUID	= 5662568104530920233L;
	
	/*
	 * Remember that all declared view options/fields must have identical names and values.
	 */
	
	private final String escapeHTML = "escapeHTML";
	
	public SettingsView()
	{
		super();
		restoreDefaults();
	}
	
	public Boolean shouldEscapeHTML()
	{
		return getItem(escapeHTML);
	}
	public void setShouldEscapeHTML(Boolean enabled)
	{
		setItem(this, escapeHTML, enabled);
	}
	
	public String isDefined1(String input)
	{
		return "isDefined1";
	}
	public String isDefined2(String input)
	{
		return "isDefined2";
	}
	public String isDefined3(String input)
	{
		return "isDefined3";
	}
	
	//---------------------------------------------------
	// GENERAL API FOR EXTERNAL MANIPULATION
	
	public void restoreDefaults()
	{
		// by default, all sanitizers are disabled
		setShouldEscapeHTML(false);
		
		/*
		for(Class<? extends ISanitizationFilter> filterClass : ReflectionUtils.getSubtypesFromPackage(Package.getPackage("org.skycrawl.search"), ISanitizationFilter.class))
		{
			// by default, all sanitizers are disabled
			settings.setFilterEnabled(filterClass, false);
		}
		*/
	}
	
	public void applyChange(String item, String value)
	{
		if(escapeHTML.equals(item))
		{
			setShouldEscapeHTML(Boolean.parseBoolean(value));
		}
	}
	
	/*
	public boolean isFilterEnabled(Class<? extends ISanitizationFilter> filterClass)
	{
		Boolean result = getVar(filterClass.getSimpleName());
		return (result != null) && result;
	}
	public void setFilterEnabled(Class<? extends ISanitizationFilter> filterClass, boolean enabled)
	{
		setFilterEnabled(filterClass.getSimpleName(), enabled);
	}
	public void setFilterEnabled(String filterClassSimpleName, boolean enabled)
	{
		setVar(filterClassSimpleName, enabled);
	}
	*/
}

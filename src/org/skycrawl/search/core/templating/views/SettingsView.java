package org.skycrawl.search.core.templating.views;

import java.util.HashMap;
import java.util.Map;

public class SettingsView extends AbstractRythmView
{
	private final Map<String, Object> values;
	
	public static final String KEY_ESCAPE_HTML = "escapeHTML";
	public static final String KEY_ESCAPE_CSS = "escapeCSS";
	public static final String KEY_ESCAPE_JS = "escapeJS";
	public static final String KEY_ESCAPE_URL = "escapeURL";
	
	public SettingsView()
	{
		super();
		
		this.values = new HashMap<String,Object>();
		restoreDefaults();
	}
	
	public boolean shouldEscapeHTML()
	{
		return (boolean) values.get(KEY_ESCAPE_HTML);
	}
	public void setEscapeHTML(boolean escapeHTML)
	{
		values.put(KEY_ESCAPE_HTML, escapeHTML);
	}
	
	public boolean shouldEscapeCSS()
	{
		return (boolean) values.get(KEY_ESCAPE_CSS);
	}
	public void setEscapeCSS(boolean escapeCSS)
	{
		values.put(KEY_ESCAPE_CSS, escapeCSS);
	}
	
	public boolean shouldEscapeJS()
	{
		return (boolean) values.get(KEY_ESCAPE_JS);
	}
	public void setEscapeJS(boolean escapeJS)
	{
		values.put(KEY_ESCAPE_JS, escapeJS);
	}
	
	public boolean shouldEscapeURL()
	{
		return (boolean) values.get(KEY_ESCAPE_URL);
	}
	public void setEscapeURL(boolean escapeURL)
	{
		values.put(KEY_ESCAPE_URL, escapeURL);
	}
	
	//---------------------------------------------------
	// GENERAL API FOR EXTERNAL MANIPULATION
	
	public void restoreDefaults()
	{
		// by default, all sanitizers are disabled
		setEscapeHTML(false);
		setEscapeCSS(false);
		setEscapeJS(false);
		setEscapeURL(false);
	}
	
	public void applyChange(String item, String value)
	{
		if(values.containsKey(item))
		{
			values.put(item, Boolean.parseBoolean(value));
		}
	}
}

package org.skycrawl.search.core.templating;

import java.util.HashMap;
import java.util.Map;

import org.rythmengine.Rythm;
import org.skycrawl.search.commons.IOUtils;
import org.skycrawl.search.core.templating.views.PassbackView;
import org.skycrawl.search.core.templating.views.SettingsView;

public abstract class RythmTemplates
{
	static
	{
		// prepare rythm engine
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("home.template", IOUtils.getAbsoluteBaseAppPath());
        Rythm.init(map);
	}
	
	public static Map<String, Object> getCommonViewOptions()
	{
		// TODO:
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("_appName", "XSS My Love");
		return result;
	}
	
	public static String viewPassback(PassbackView view)
	{
		return Rythm.render("passback.rythm", view);
	}
	
	public static String viewSettings(SettingsView view)
	{
		return Rythm.render("settings.rythm", view);
	}
}

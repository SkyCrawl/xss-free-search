package org.skycrawl.search.commons.settings;

import javax.servlet.http.HttpServletResponse;

import org.skycrawl.search.core.templating.views.SettingsView;

public class Settings
{
	//------------------------------------------------------------------------
	// PRIVATE HEADER DEFINITIONS
	
	private static final String HEADER_X_XSS_PROTECTION = "0; mode=block";
	private static final String HEADER_CONTENT_SECURITY_POLICY = "child-src 'self'; unsafe-inline";
	
	//------------------------------------------------------------------------
	// PRIVATE SETTINGS DEFINITIONS
	
	private static final SettingsView settings = new SettingsView();
	
	//------------------------------------------------------------------------
	// GENERAL PUBLIC API
	
	public static void applyHeadersToResponse(HttpServletResponse response)
	{
		response.setHeader("X-XSS-Protection", HEADER_X_XSS_PROTECTION);
		response.setHeader("Content-Security-Policy", HEADER_CONTENT_SECURITY_POLICY);
	}
	
	//------------------------------------------------------------------------
	// VIEW REPRESENTATIONS
	
	public static SettingsView toView()
	{
		return settings;
	}
}

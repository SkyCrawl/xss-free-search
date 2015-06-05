package org.skycrawl.search.commons.sanitization.sanitizers;

import org.skycrawl.search.commons.EscapeUtils;
import org.skycrawl.search.commons.sanitization.ISanitizationFilter;
import org.skycrawl.search.commons.settings.Settings;

public class EscapeHTMLAttributeFilter implements ISanitizationFilter<String>
{
	@Override
	public boolean shouldBeApplied()
	{
		return Settings.toView().shouldEscapeHTML();
	}
	
	@Override
	public String sanitize(String input)
	{
		return EscapeUtils.escapeHTMLAttribute(input);
	}
}

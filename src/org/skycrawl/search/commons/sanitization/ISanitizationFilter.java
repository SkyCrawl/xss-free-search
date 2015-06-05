package org.skycrawl.search.commons.sanitization;

public interface ISanitizationFilter<O extends Object>
{
	boolean shouldBeApplied();
	O sanitize(O input);
}

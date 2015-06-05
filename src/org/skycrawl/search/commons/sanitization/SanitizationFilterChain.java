package org.skycrawl.search.commons.sanitization;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.skycrawl.search.commons.AppUtils;

public class SanitizationFilterChain<O extends Object> extends LinkedHashSet<ISanitizationFilter<O>>
{
	private static final long	serialVersionUID	= 9103234095509220435L;

	public SanitizationFilterChain()
	{
		super();
	}

	public SanitizationFilterChain(Collection<? extends ISanitizationFilter<O>> c)
	{
		super(c);
	}

	public O sanitize(O input)
	{
		if(AppUtils.isObjectDefined(input))
		{
			O result = input;
			for(ISanitizationFilter<O> filter : this)
			{
				if(filter.shouldBeApplied())
				{
					result = filter.sanitize(result);
				}
			}
			return result;
		}
		else
		{
			return input;
		}
	}
}

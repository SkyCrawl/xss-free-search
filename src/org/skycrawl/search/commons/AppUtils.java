package org.skycrawl.search.commons;

import java.util.Collection;

public abstract class AppUtils
{
	/**
	 * Checks whether the object is null and if it is not, tries to apply some semantic checks
	 * according to the object's type.
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isObjectDefined(Object value)
	{
		boolean result = value != null;
		if(result)
		{
			if(value instanceof String)
			{
				result = !((String) value).isEmpty();
			}
			else if(value instanceof Object[])
			{
				result = ((Object[]) value).length > 0;
			}
			else if(value instanceof Collection<?>)
			{
				result = !((Collection<?>) value).isEmpty();
			}
		}
		return result;
	}
	
	public static Boolean unbox(Boolean value)
	{
		return value == null ? false : value;
	}
}

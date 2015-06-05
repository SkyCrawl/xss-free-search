package org.skycrawl.search.core.templating.views;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.skycrawl.search.commons.AppUtils;
import org.skycrawl.search.commons.sanitization.ISanitizationFilter;
import org.skycrawl.search.commons.sanitization.SanitizationFilterChain;
import org.skycrawl.search.core.templating.RythmTemplates;
import org.skycrawl.search.core.templating.annotations.RVAddHas;
import org.skycrawl.search.core.templating.annotations.RVSanitize;
import org.skycrawl.search.core.templating.exceptions.RVRuntimeException;

public abstract class AbstractRythmView extends HashMap<String, Object>
{
	private static final long	serialVersionUID	= -2013806611967128094L;
	
	public AbstractRythmView()
	{
		super();
		
		// apply common options:
		putAll(RythmTemplates.getCommonViewOptions());
	}

	@SuppressWarnings("unchecked")
	protected <O extends Object> O getItem(String item)
	{
		return (O) get(item);
	}
	/*
	protected Boolean getHasItem(String item)
	{
		return (Boolean) get(toHasItem(item));
	}
	*/
	protected <V extends AbstractRythmView> void setItem(V child, String item, Object itemValue) throws RVRuntimeException
	{
		put(item, itemValue);
		// processMVAnnotations(child, item);
	}
	protected <V extends AbstractRythmView> void removeItem(V child, String item) throws RVRuntimeException
	{
		remove(item);
		// processMVAnnotations(child, item);
	}
	
	//---------------------------------------------------------------------
	// PRIVATE STUFF
	
	/**
	 * <p>Processes declared annotations of the given field of the given view instance.</p>
	 * <p>This method assumes that all options of child classes/views are declared as {@link String} fields that have identical
	 * names and values.</p>
	 * 
	 * @param child
	 * @param item
	 * @throws RVRuntimeException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private <V extends AbstractRythmView> void processMVAnnotations(V child, String item) throws RVRuntimeException
	{
		try
		{
			// if no such field exists (or the field's value is different from its name), raises an exception one way or another
			Field field = child.getClass().getDeclaredField(item);
			field.setAccessible(true);
			
			// do process annotations
			if(field.isAnnotationPresent(RVAddHas.class))
			{
				// avoid {@link #setItem(AbstractMustacheView, String, Object)} as it would create a cycle 
				put(toHasItem(item), (Boolean) AppUtils.isObjectDefined(getItem(item)));
			}
			if(field.isAnnotationPresent(RVSanitize.class))
			{
				RVSanitize sanitizationDirective = field.getAnnotation(RVSanitize.class);
				SanitizationFilterChain<Object> sanitizationFilterChain = new SanitizationFilterChain<Object>();
				for(Class<? extends ISanitizationFilter<? extends Object>> filterClass : sanitizationDirective.filters())
				{
					sanitizationFilterChain.add((ISanitizationFilter<Object>) filterClass.newInstance());
				}
				
				// avoid {@link #setItem(AbstractMustacheView, String, Object)} as it would create a cycle
				put(item, sanitizationFilterChain.sanitize(getItem(item)));
			}
		}
		catch (Exception e)
		{
			throw new RVRuntimeException(e);
		}
	}
	
	private static String toHasItem(String item)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("has");
		sb.append(Character.toUpperCase(item.charAt(0)));
		sb.append(item.substring(1));
		return sb.toString();
	}
}

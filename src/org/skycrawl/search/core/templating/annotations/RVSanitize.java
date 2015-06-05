package org.skycrawl.search.core.templating.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.skycrawl.search.commons.sanitization.ISanitizationFilter;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface RVSanitize
{
	Class<? extends ISanitizationFilter<? extends Object>>[] filters();
}

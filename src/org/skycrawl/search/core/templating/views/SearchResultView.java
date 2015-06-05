package org.skycrawl.search.core.templating.views;

import org.skycrawl.search.commons.AppUtils;

public class SearchResultView extends AbstractRythmView
{
	private static final long	serialVersionUID	= -2903202537923089412L;
	
	/*
	 * Remember that all declared view options/fields must have identical names and values.
	 */
	
	private final String title = "title";
	private final String url = "url";
	private final String content = "content";
	private final String shortContent = "shortContent";
	
	public SearchResultView()
	{
		super();
	}
	
	public String getTitle()
	{
		return getItem(title);
	}
	public void setTitle(String title)
	{
		setItem(this, this.title, title);
	}
	
	public String getUrl()
	{
		return getItem(url);
	}
	public void setUrl(String url)
	{
		setItem(this, this.url, url);
	}
	
	public String getContent()
	{
		return getItem(content);
	}
	public void setContent(String content)
	{
		setItem(this, this.content, content);
		if(AppUtils.isObjectDefined(content))
		{
			String shortContent = content.substring(0, Math.min(content.length(), 150));
			shortContent = shortContent.length() < content.length() ? shortContent + "..." : shortContent;
			setItem(this, this.shortContent, shortContent);
		}
		else
		{
			setItem(this, this.shortContent, null);
		}
	}
}

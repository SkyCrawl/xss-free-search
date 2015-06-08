package org.skycrawl.search.core.templating.views.search;

import org.skycrawl.search.commons.AppUtils;
import org.skycrawl.search.core.templating.views.AbstractRythmView;

public class SearchResultView extends AbstractRythmView
{
	private String title;
	private String url;
	private String content;
	
	public SearchResultView()
	{
		super();
	}
	
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getUrl()
	{
		return this.url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getContent()
	{
		return this.content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	
	//--------------------------------------------------
	// ADD-ON STUFF

	public String getShortContent()
	{
		if(AppUtils.isObjectDefined(content))
		{
			String shortContent = content.substring(0, Math.min(content.length(), 150));
			return shortContent.length() < content.length() ? shortContent + "..." : shortContent;
		}
		else
		{
			return null;
		}
	}
}

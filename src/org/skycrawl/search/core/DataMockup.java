package org.skycrawl.search.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.skycrawl.search.commons.AppUtils;
import org.skycrawl.search.core.templating.views.search.SearchResultView;

public abstract class DataMockup
{
	//-----------------------------------------------------------------------------------------
	// THE "PAGES"
	
	private static String red = "Red is the color at the end of the spectrum of visible light next to orange and opposite violet. It is evoked by light with a predominant wavelength of roughly 620–740 nm. Red is one of the additive primary colors of light, along with green and blue, which in RGB color systems are combined to create all the colors on a computer monitor or television screen. It is also one of the subtractive primary colors, along with yellow and blue, of the RYB color space and traditional color wheel used by painters and artists.";
	private static String black = "Black is the darkest color, the result of the absence of or complete absorption of light. It is the opposite of white (the combined spectrum of color or light). It is one of the four primary colors in the CMYK color model, along with cyan, yellow, and magenta, used in color printing to produce all the other colors.";
	private static String blue = "Blue is the colour between violet and green on the optical spectrum of visible light. Human eyes perceive blue when observing light with a wavelength between 450 and 495 nanometres. Pure blue, in the middle, has a wavelength of 470 nanometres. In painting and traditional colour theory, blue is one of the three primary colours of pigments, along with red and yellow, which can be mixed to form a wide gamut of colours.";
	private static String white = "White is an achromatic color, literally a \"color without color\", composed of a mixture of all frequencies of the light of the visible spectrum. It is one of the most common colors in nature, the color of sunlight, snow, milk, chalk, limestone and other common minerals. In many cultures white represents or signifies purity, innocence, and light, and is the symbolic opposite of black, or darkness. According to surveys in Europe and the United States, white is the color most often associated with perfection, the good, honesty, cleanliness, the beginning, the new, neutrality, and exactitude.";
	private static String green = "Green is the color between blue and yellow on the spectrum of visible light. It is evoked by light with a predominant wavelength of roughly 495–570 nm. In the subtractive color system, used in painting and color printing, it is created by a combination of yellow and blue, or yellow and cyan; in the RGB color model, used on television and computer screens, it is one of the additive primary colors, along with red and blue, which are mixed in different combinations to create all other colors.";
	private static String yellow = "Yellow is the color of gold, butter, and ripe lemons. In the spectrum of visible light, and in the traditional color wheel used by painters, yellow is found between green and orange. It is a primary color in subtractive color, used in color printing, along with cyan, magenta, and black. Blue is the colour between violet and green on the optical spectrum of visible light. Human eyes perceive blue when observing light with a wavelength between 450 and 495 nanometres. Pure blue, in the middle, has a wavelength of 470 nanometres. In painting and traditional colour theory, blue is one of the three primary colours of pigments, along with red and yellow, which can be mixed to form a wide gamut of colours.";
	
	//-----------------------------------------------------------------------------------------
	// THE DATA
	
	private static final Map<String, SearchResultView> data = new HashMap<String, SearchResultView>();
	static
	{
		SearchResultView item1 = new SearchResultView();
		item1.setTitle("Red, black, blue");
		item1.setUrl("http://www.rbb-colors.org");
		item1.setContent(String.format("%s\n\n%s\n\n%s", red, black, blue));
		
		SearchResultView item2 = new SearchResultView();
		item2.setTitle("Red, black, white");
		item2.setUrl("http://www.rbw-colors.org");
		item2.setContent(String.format("%s\n\n%s\n\n%s", red, black, white));
		
		SearchResultView item3 = new SearchResultView();
		item3.setTitle("Green, white");
		item3.setUrl("http://www.gw-colors.org");
		item3.setContent(String.format("%s\n\n%s", green, white));
		
		SearchResultView item4 = new SearchResultView();
		item4.setTitle("Yellow, blue");
		item4.setUrl("http://www.yb-colors.org");
		item4.setContent(String.format("%s\n\n%s", yellow, blue));
		
		SearchResultView item5 = new SearchResultView();
		item5.setTitle("Green, yellow");
		item5.setUrl("http://www.gy-colors.org");
		item5.setContent(String.format("%s\n\n%s", green, yellow));
		
		indexItems(item1, item2, item3, item4, item5);
	}
	
	private static void indexItems(SearchResultView... items)
	{
		for(SearchResultView item : items)
		{
			if(data.containsKey(item.getTitle()))
			{
				throw new IllegalStateException();
			}
			else
			{
				data.put(item.getTitle(), item);
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------
	// THE SEARCH
	
	public static List<SearchResultView> search(String searchTerm)
	{
		List<SearchResultView> searchResult = new ArrayList<SearchResultView>();
		if(AppUtils.isObjectDefined(searchTerm))
		{
			for(Entry<String, SearchResultView> entry : data.entrySet())
			{
				if(entry.getKey().toLowerCase().contains(searchTerm.toLowerCase()))
				{
					searchResult.add(entry.getValue());
				}
			}
		}
		return searchResult;
	}
}

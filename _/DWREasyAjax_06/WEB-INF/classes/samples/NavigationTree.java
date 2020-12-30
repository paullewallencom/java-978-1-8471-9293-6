package samples;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class NavigationTree {
	private String[] rootLevel={"Northern Hemisphere","Southern Hemisphere"};

	private Map<String,List<String>> level_1=new Hashtable<String,List<String>>();
	private Map<String,List<String>> level_2=new Hashtable<String,List<String>>();
	
	private String[] ncap={"Helsinki","Stockholm","Oslo"};
	private String[] scap={"Wellington","Canberra","Port Louis"};
	
	public NavigationTree()
	{
		List<String> countries=new Vector<String>();
		//set northern hemisphere
		countries.add("Finland");
		countries.add("Sweden");
		countries.add("Norway");
		level_1.put(rootLevel[0], countries);
		for(int i=0;i<countries.size();i++)
		{
			Vector<String> capitals=new Vector<String>();
			capitals.add(ncap[i]);
			level_2.put(countries.get(i), capitals);
		}
		
		countries=new Vector<String>();
		countries.add("New Zealand");
		countries.add("Australia");
		countries.add("Mauritius");
		level_1.put(rootLevel[1], countries);
		for(int i=0;i<countries.size();i++)
		{
			Vector<String> capitals=new Vector<String>();
			capitals.add(scap[i]);
			level_2.put(countries.get(i), capitals);
		}
	}
	
	public String[] getRootElements()
	{
		return rootLevel; 
	}
	
	public boolean hasChildren(String element)
	{
		return (level_1.containsKey(element) || level_2.containsKey(element)); 
	}
	
	public List<String> getChildren(String element)
	{
		List<String> children=new Vector<String>();
		if(level_1.containsKey(element))
		{
			return level_1.get(element);
		}
		if(level_2.containsKey(element))
		{
			return level_2.get(element);
		}
		return children;
	}
	
	public String getContent(String element)
	{
		String[] desc={"A great place to be.","Nice place to visit.","Good nightlife.","Excellent restaurants.","Unforgettable"};
		Random rnd=new Random();
		return "The capital is "+element+". "+desc[rnd.nextInt(desc.length)];
	}
}

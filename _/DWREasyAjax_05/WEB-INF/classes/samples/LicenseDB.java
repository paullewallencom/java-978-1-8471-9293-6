package samples;

import java.util.List;
import java.util.Vector;

public class LicenseDB{

	private DBUtils dbUtils=new DBUtils();
	
	public LicenseDB()
	{
		dbUtils.initFileDB("licenses.csv");
	}
	
	public List<String> getLicensesStartingWith(String startLetters)
	{	
		List<String> list=new Vector<String>();
		List<String> licenses=dbUtils.getCSVStrings(startLetters);
		for(String license : licenses)
		{
			list.add(license.split(",")[0]);
		}
		return list;
	}
	
	public String getLicenseContentUrl(String licenseName)
	{
		List<String> licenses=dbUtils.getCSVStrings(licenseName);
		if(licenses.size()>0)
		{
			return licenses.get(0).split(",")[1];
		}
		return "";
	}
}

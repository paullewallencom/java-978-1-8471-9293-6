package samples;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class CountryDB {

	private DBUtils dbUtils = new DBUtils();
	private String fileName = "countries.csv";

	public CountryDB() {
		dbUtils.initFileDB(fileName);
	}

	public String[] getCountryData(String ccode) {
		List<String> countries = dbUtils.getCSVStrings(null);
		for (String country : countries) {
			if (country.indexOf("," + ccode + ",") > -1) {
				return country.split(",");
			}
		}
		return new String[0];
	}

	public List<List<String>> getCountries(String startLetter) {

		List<List<String>> allCountryData = new Vector<List<String>>();
		List<String> countryData = dbUtils.getCSVStrings(startLetter);
		for (String country : countryData) {
			String[] data = country.split(",");
			allCountryData.add(Arrays.asList(data));
		}
		return allCountryData;
	}

	public String[] saveCountryNotes(String ccode, String notes) {
		List<String> countries = dbUtils.getCSVStrings(null);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileName));
			for (String country : countries) {
				if (country.indexOf("," + ccode + ",") > -1) {
					if (country.split(",").length == 4) {
						// no existing notes
						country = country + "," + notes;
					} else {
						if (notes.length() == 0) {
							country = country.substring(0, country
									.lastIndexOf(","));
						} else {
							country = country.substring(0, country
									.lastIndexOf(","))
									+ "," + notes;
						}

					}
				}
				pw.println(country);
			}
			pw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String[] rv = new String[2];
		rv[0] = ccode;
		rv[1] = notes;
		return rv;
	}

}

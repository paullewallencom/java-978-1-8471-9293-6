package samples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;

public class DBUtils {

	private String fileName=null;
	public void initFileDB(String fileName)
	{
		this.fileName=fileName;
		// copy csv file to bin-directory, for easy
		// file access
		File countriesFile = new File(fileName);
		if (!countriesFile.exists()) {
			try {
				List<String> countries = getCSVStrings(null);
				PrintWriter pw;
				pw = new PrintWriter(new FileWriter(countriesFile));
				for (String country : countries) {
					pw.println(country);
				}
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	protected List<String> getCSVStrings(String letter) {
		List<String> csvData = new Vector<String>();
		try {
			File csvFile = new File(fileName);
			BufferedReader br = null;
			if(csvFile.exists())
			{
				br=new BufferedReader(new FileReader(csvFile));
			}
			else
			{
				InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream("samples/"+fileName);
				br=new BufferedReader(new InputStreamReader(is));
				br.readLine();
			}
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if (letter == null
						|| (letter != null && line.startsWith(letter))) {
					csvData.add(line);
				}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return csvData;
	}
}

package samples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CountryDerbyDB {

	public CountryDerbyDB() {

	}

	private Connection getConnection() {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/CountryDataSource");
			Connection con = ds.getConnection();
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	private void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<List<String>> getCountries(String startLetter) {
		List<List<String>> allCountryData = new Vector<List<String>>();
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select short_name,long_name,code,capital,notes from country_data where short_name like ?");
			pstmt.setString(1, startLetter + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				List<String> countryData = new Vector<String>();
				for (int i = 1; i <= 5; i++) {
					if (i == 5) {
						String notes = rs.getString(i);
						if (notes.length() == 0) {
							notes = "&nbsp;";
						}
						countryData.add(notes);
					} else {
						countryData.add(rs.getString(i));
					}
				}
				allCountryData.add(countryData);
			}
			closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allCountryData;
	}

	public String[] getCountryData(String ccode) {
		List<String> countryData = new Vector<String>();
		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select short_name,long_name,code,capital,notes from country_data where code=?");
			pstmt.setString(1, ccode);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				for (int i = 1; i <= 5; i++) {
					if (i == 5) {
						String notes = rs.getString(i);
						if (notes.length() == 0) {
							notes = "&nbsp;";
						}
						countryData.add(notes);
					} else {
						countryData.add(rs.getString(i));
					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(con);
		String[] cdata = new String[5];
		return countryData.toArray(cdata);
	}

	public String[] saveCountryNotes(String ccode, String notes) {

		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update country_data set notes=? where code=?");
			pstmt.setString(1, notes);
			pstmt.setString(2, ccode);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection(con);
		String[] rv = new String[2];
		rv[0] = ccode;
		rv[1] = notes;
		return rv;
	}

}

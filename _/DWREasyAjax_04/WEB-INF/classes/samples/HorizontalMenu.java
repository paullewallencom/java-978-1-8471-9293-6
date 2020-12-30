package samples;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class HorizontalMenu {
	public HorizontalMenu() {
	}

	public List<String> getMenuItems() throws IOException {
		List<String> menuItems = new Vector<String>();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(
				"samples/dwrapplication.properties");
		Properties appProps = new Properties();
		appProps.load(is);
		is.close();
		for (int menuCount = 1; true; menuCount++) {
			String menuItem = appProps.getProperty("menu." + menuCount);
			if (menuItem == null) {
				break;
			}
			menuItems.add(menuItem);
		}
		return menuItems;
	}

}

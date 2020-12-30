package samples;

import java.util.List;
import java.util.Vector;

public class MapScroller {

	private int[] imagesInRowInZLevel = { 10, 20 };
	private String imageName = "tempe-mareotis-zlevel-";

	public List<String> getMapImages(int zoomLevel, int mapPositionIndex) {
		List<String> images = new Vector<String>();
		String imageName = this.imageName + zoomLevel + "-";
		for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
			for (int i = 0; i < 4; i++) {
				int index = mapPositionIndex + i;
				images.add(imageName + index + ".jpg");
			}
			mapPositionIndex = mapPositionIndex
					+ imagesInRowInZLevel[zoomLevel];
		}
		return images;

	}
}

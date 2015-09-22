package test.com.instaSuggest.poc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import junit.framework.TestCase;
import net.semanticmetadata.lire.imageanalysis.CEDD;
import net.semanticmetadata.lire.utils.FileUtils;

import org.junit.Test;

public class TestCEDDDistance extends TestCase {

	private String testFilesPath = "C:\\Sumit\\Git_Repo_Luna\\230814\\InstaSuggest\\resource\\images\\";

	@Test
	public void testCEDD() throws IOException {
		CEDD tempCedd = new CEDD();
		BufferedImage img = ImageIO.read(new File(testFilesPath + "img08.JPG"));
		tempCedd.extract(img);
		ArrayList<File> files = FileUtils.getAllImageFiles(new File(
				testFilesPath), false);
		for (File file : files) {
			System.out.printf("-=-=-= Running test for image (%s)%n ",
					file.getName());
			CEDD cedd = new CEDD();
			BufferedImage image = ImageIO.read(file);
			cedd.extract(image);
			System.out.println("Histogram : "
					+ Arrays.toString(cedd.getDoubleHistogram()));
			System.out.printf("Feature Name %s%n : ", cedd.getFeatureName());
			System.out.printf("Field Name %s%n : ", cedd.getFieldName());
			System.out.printf("String rep %s%n : ",
					cedd.getStringRepresentation());
			System.out.printf("Distance : %f%n", cedd.getDistance(tempCedd));
			System.out.println("-=-=-= Test Ended -=-=-=-=");
		}
	}
}

package test.com.suggesthashtag.instaapi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

import junit.framework.TestCase;
import net.semanticmetadata.lire.imageanalysis.CEDD;
import net.semanticmetadata.lire.utils.FileUtils;

import org.junit.Ignore;
import org.junit.Test;

public class TestCEDDDistance extends TestCase {

	private String testFilesPath = "C:\\Sumit\\Git_Repo_Luna\\230814\\InstaSuggest\\resource\\images\\";

	@Ignore
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
			String strRep = cedd.getStringRepresentation();
			System.out.printf("String rep %s%n : ", strRep);
			strRep = strRep.replace("cedd 144", "");
			int sum = 0;
			StringTokenizer st = new StringTokenizer(strRep);
			while (st.hasMoreTokens()) {
				sum ^= Integer.parseInt(st.nextToken().trim());
			}
			System.out.printf("Sum : %d%n", sum);
			System.out.printf("Distance : %f%n", cedd.getDistance(tempCedd));
			System.out.println("-=-=-= Test Ended -=-=-=-=");
		}
	}

	@Test
	public void testCEDDReverse() throws IOException {
		String[] ceddRep = {
				"cedd 1 4 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 4 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 2 0 0 0 1 0 2 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 6 4 0 0 1 2 0 3 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 3 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
				"cedd 1 1 2 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 5 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 2 6 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 1 7 3 0 0 1 2 0 2 0 0 0 0 0 0 0 0 0 1 0 2 0 0 0 1 4 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 4 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
				"cedd 2 1 1 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 1 4 1 0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 2 6 1 0 0 0 2 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 2 7 2 1 0 2 2 0 3 0 0 0 0 0 0 0 0 0 1 0 2 0 0 0 0 3 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 4 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
				"cedd 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 3 1 0 0 0 0 2 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 1 5 1 1 0 1 1 0 1 0 0 0 0 0 0 0 0 0 2 0 2 0 0 0 0 7 3 0 0 1 1 0 2 0 0 0 0 0 0 0 0 0 3 1 4 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0" };
		CEDD tempCedd = new CEDD();
		BufferedImage img = ImageIO.read(new File(testFilesPath + "img08.JPG"));
		tempCedd.extract(img);
		String tempStrRep = tempCedd.getStringRepresentation();
		System.out.printf("Test 2 begins %s%n ", tempStrRep);
		for (String str : ceddRep) {
			CEDD cedd = new CEDD();
			cedd.setStringRepresentation(str);
			System.out.printf("Distance : %f%n", cedd.getDistance(tempCedd));
		}

	}

	@Test
	public void testCEDDSum() throws IOException {
		String[] ceddRep = {
				"1 4 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 4 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 7 2 0 0 0 1 0 2 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 6 4 0 0 1 2 0 3 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 3 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
				"1 1 2 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 5 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 2 6 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 1 7 3 0 0 1 2 0 2 0 0 0 0 0 0 0 0 0 1 0 2 0 0 0 1 4 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 4 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
				"2 1 1 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 1 4 1 0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 2 6 1 0 0 0 2 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 2 7 2 1 0 2 2 0 3 0 0 0 0 0 0 0 0 0 1 0 2 0 0 0 0 3 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 4 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0",
				"0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 3 1 0 0 0 0 2 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 1 5 1 1 0 1 1 0 1 0 0 0 0 0 0 0 0 0 2 0 2 0 0 0 0 7 3 0 0 1 1 0 2 0 0 0 0 0 0 0 0 0 3 1 4 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0" };
		System.out.printf("-=--=-= Starting testCEDDSum -=-=-= %n");
		for (String str : ceddRep) {
			System.out.printf("Index str %s%n", str);
			int sum = 0;
			StringTokenizer st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken().trim());
			}
		}

	}
}

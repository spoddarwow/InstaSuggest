package com.instaSuggest.poc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

//import net.semanticmetadata.lire.imageanalysis.CEDD;

import sampleApp.main.java.net.semanticmetadata.lire.imageanalysis.CEDD;

import com.drew.imaging.ImageProcessingException;

public class ReadImageWithCedd {

	public static void main(String[] args) throws IOException,
			ImageProcessingException {
		CEDD c = new CEDD();
		BufferedImage img = ImageIO
				.read(new File(
						"C:\\Sumit\\Git_Repo_Luna\\230814\\InstaSuggest\\resource\\iphone6-plus-box-silver-2014.jpeg"));
		c.extract(img);
		String s = Arrays.toString(c.getDoubleHistogram());
		System.out.println("s = " + s);
		byte[] b = c.getByteArrayRepresentation();
		CEDD d = new CEDD();
		d.setByteArrayRepresentation(b);
		System.out.println(d.getDistance(c));

	}

}

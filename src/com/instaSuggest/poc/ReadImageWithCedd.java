package com.instaSuggest.poc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

//import net.semanticmetadata.lire.imageanalysis.CEDD;

import net.semanticmetadata.lire.imageanalysis.CEDD;

import com.drew.imaging.ImageProcessingException;

public class ReadImageWithCedd {

	public static void main(String[] args) throws IOException,
			ImageProcessingException {
		CEDD c = new CEDD();
		BufferedImage img = ImageIO
				.read(new File(
						"/Users/sumitpoddar/git/InstaSuggest/resource/iphone6-plus-box-silver-2014.jpeg"));
		c.extract(img);
		String s = Arrays.toString(c.getDoubleHistogram());
		System.out.println("s = " + s);
		byte[] b = c.getByteArrayRepresentation();
		CEDD d = new CEDD();
		img = ImageIO
				.read(new File(
						"/Users/sumitpoddar/git/InstaSuggest/resource/icon_connections.jpg"));
		d.extract(img);
		//d.setByteArrayRepresentation(b);
		System.out.println(d.getDistance(c));
		System.out.println("-=-=-=-");
		d = new CEDD();
		img = ImageIO
				.read(new File(
						"/Users/sumitpoddar/git/InstaSuggest/resource/valcano.jpg"));
		d.extract(img);
		//d.setByteArrayRepresentation(b);
		System.out.println(d.getDistance(c));
		System.out.println("-=-=-=-");
		d = new CEDD();
		img = ImageIO
				.read(new File(
						"/Users/sumitpoddar/git/InstaSuggest/resource/iphone6_silver.JPG"));
		d.extract(img);
		//d.setByteArrayRepresentation(b);
		System.out.println(d.getDistance(c));

	}

}

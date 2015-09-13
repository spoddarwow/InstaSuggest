package com.instaSuggest.poc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImageWithBufferedImage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	BufferedImage image = ImageIO.read(new File(
				"/Users/sumitpoddar/git/InstaSuggest/resource/iphone6-plus-box-silver-2014.jpeg"));
	System.out.println(image.getRaster());
	}

}

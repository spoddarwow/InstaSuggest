package com.instaSuggest.poc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImageWithBufferedImage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(new File(
				"C:\\Sumit\\Git_Repo_Luna\\230814\\InstaSuggest\\resource\\iphone6-plus-box-silver-2014.jpeg").exists());
		
		BufferedImage image = ImageIO.read(new File(
				"C:\\Sumit\\Git_Repo_Luna\\230814\\InstaSuggest\\resource\\iphone6-plus-box-silver-2014.jpeg"));
		System.out.println(image.getRaster());
	}

}

package com.instaSuggest.poc;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;

public class ReadImageWithBufferImage {

	public static void main(String[] args) throws IOException, ImageProcessingException{
		Metadata metaData = ImageMetadataReader.readMetadata(new File(
				"/Users/sumitpoddar/git/InstaSuggest/resource/902184_0_9999_med_v1_m56577569855077244.png"));
		Iterable<Directory> directoryItr = metaData.getDirectories();//getDirectoriesOfType( ExifDirectoryBase.class );
		Iterator<Directory> dItr = directoryItr.iterator();
		Directory directory = null;
		while(dItr.hasNext()){
			directory = dItr.next(); 
			if( directory != null )
	        {
	            // Read the date
	            Date date = directory.getDate( ExifDirectoryBase.TAG_DATETIME );
	            if(date != null){
	            DateFormat df = DateFormat.getDateInstance();
	            df.format( date );
	            int year = df.getCalendar().get( Calendar.YEAR );
	            int month = df.getCalendar().get( Calendar.MONTH ) + 1;

	            System.out.println( "Year: " + year + ", Month: " + month );

	            System.out.println( "Date: " + date );
	            }
	            System.out.println( "Tags" );
	            Collection<Tag> tags = directory.getTags();
	            for(Tag tag : tags)
	            {
	                System.out.println( "\t" + tag.getTagName() + " = " + tag.getDescription() );

	            }
	        }
			System.out.println("-=-=-=-=-=-=");
		}
        
	}

}

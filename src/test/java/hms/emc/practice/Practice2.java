package hms.emc.practice;

import org.testng.annotations.Test;

import com.tyss.genericUtilities.annotationConfiguration.AnnotationConfiguration;

import annotations.Report;


public class Practice2 extends AnnotationConfiguration
{
	@Report(author = "Gaurav")
	@Test
	public void instagram()
	{
		seleniumutility.applicationUrl("https://www.instagram.com");
	}
}

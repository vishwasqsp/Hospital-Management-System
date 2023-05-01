package hms.emc.practice;

import org.testng.annotations.Test;

import com.tyss.genericUtilities.annotationConfiguration.AnnotationConfiguration;

import annotations.Report;


public class Practice1 extends AnnotationConfiguration
{
	@Report(author = "Vishwas")
	@Test
	public void facebook()
	{
		seleniumutility.applicationUrl("https://www.facebook.com");
	}
}


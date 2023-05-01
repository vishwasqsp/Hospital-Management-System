package hms.emc.practice;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtilities.annotationConfiguration.AnnotationConfiguration;

import annotations.Report;


public class Practice3 extends AnnotationConfiguration
{
	@Report(author = "Amruth")
	@Test
	public void gmail()
	{
		seleniumutility.applicationUrl("https://www.gmail.com");
	}
}

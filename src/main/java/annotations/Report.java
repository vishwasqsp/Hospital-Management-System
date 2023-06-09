package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
/**
 * This interface is used to declare Author and Category for the Report
 * @author User
 *
 */
public @interface Report 
{
	public String author();
	public String[] category() default "regression";
}

package job_agency.job_agency.beans;

import org.jfree.util.Log;

public class JobExternBean {

	public String reformat(String body){

		try{
			String[] title = body.split("title\":\"");
			int titleEndIndex = title[1].indexOf("\"");
			String joboffer = "Titel: " + title[1].substring(0, titleEndIndex).replaceAll("\\\\","");
			String[] location = title[1].split("location\":\"");
			int locationEndIndex = location[1].indexOf("\"");
			joboffer += "\nOrt: " + location[1].substring(0, locationEndIndex).replaceAll("\\\\","");
			String[] url = location[1].split("\"url\":\"");
			int urlEndIndex = url[1].indexOf("\"");
			joboffer += "\nURL: " + url[1].substring(0, urlEndIndex).replaceAll("\\\\","");
			String[] company = url[1].split("\"name\":\"");
			int companyEndIndex = company[1].indexOf("\"");
			joboffer += "\nFirma: " + company[1].substring(0, companyEndIndex).replaceAll("\\\\","");

			return joboffer;
		} catch(Exception e)
		{	Log.info("error in reformat");
		return "";
		}
	}

}

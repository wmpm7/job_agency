package job_agency.job_agency.beans;

import org.jfree.util.Log;

public class JobExternBean {

	public String reformat(String body){
		String[] arr = body.split("\\},\\{");
		StringBuilder joboffer = new StringBuilder();
		String[] title;
		int titleEndIndex;
		String[] location;
		int locationEndIndex;
		String[] url;
		int urlEndIndex;
		String[] company;
		int companyEndIndex;
		try{
			for (String str:arr){
				title = str.split("title\":\"");
				titleEndIndex = title[1].indexOf("\"");
				joboffer.append("Titel: " + title[1].substring(0, titleEndIndex).replaceAll("\\\\",""));
				location = title[1].split("location\":\"");
				locationEndIndex = location[1].indexOf("\"");
				joboffer.append("\nOrt: " + location[1].substring(0, locationEndIndex).replaceAll("\\\\",""));
				url = location[1].split("\"url\":\"");
				urlEndIndex = url[1].indexOf("\"");
				joboffer.append("\nURL: " + url[1].substring(0, urlEndIndex).replaceAll("\\\\",""));
				company = url[1].split("\"name\":\"");
				companyEndIndex = company[1].indexOf("\"");
				joboffer.append("\nFirma: " + company[1].substring(0, companyEndIndex).replaceAll("\\\\",""));
				joboffer.append("\n\n");
				//joboffer.append("\r\n");
	
			}
			return joboffer.toString();
		} catch(Exception e)
		{	Log.info("error in reformat");
		return "";
		}
	}

}

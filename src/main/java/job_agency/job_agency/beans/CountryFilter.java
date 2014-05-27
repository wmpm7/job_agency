package job_agency.job_agency.beans;

public class CountryFilter {
	public boolean filter (Questionnaire qu){
		if (qu.person.getAddress().getCountry().equals("AUT")){
			return true;
		}
		return false;
	}
}

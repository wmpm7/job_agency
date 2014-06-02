package job_agency.job_agency.beans;

import job_agency.job_agency.models.Questionnaire;

public class CountryFilter {
	public boolean filter (Questionnaire qu){
		if (qu.person.getAddress().getCountry().equals("AUT")){
			return true;
		}
		return false;
	}
}

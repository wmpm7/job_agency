package job_agency.job_agency.beans;

import javax.xml.bind.annotation.XmlRootElement;

import job_agency.job_agency.models.Person;
import job_agency.job_agency.models.Questions;

@XmlRootElement(name = "questionnaire")
public class Questionnaire {
	public Person person;
	public Questions questions;
	
	public boolean isAut(){
		if(this.person.getAddress().getCountry().equals("AUT")){
			return true;
		}
		return false;
	}
}

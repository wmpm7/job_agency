package job_agency.job_agency.models;

import javax.xml.bind.annotation.XmlRootElement;

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

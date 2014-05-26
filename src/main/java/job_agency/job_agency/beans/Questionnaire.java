package job_agency.job_agency.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "questionnaire")
public class Questionnaire {
	public Person person;
	public Questions questions;
}

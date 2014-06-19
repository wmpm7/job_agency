package job_agency.job_agency.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "joboffer")
public class Joboffer {
	private String title;
	private Address address;
	private String phone;
	private String email;
	private String jobdescription;
	private String salary;
	private String keyWord;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	
	
}

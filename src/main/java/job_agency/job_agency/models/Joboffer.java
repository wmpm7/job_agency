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
	private String keyword;
	private String newsletter;
	
    public String getNewsletter() {
		return newsletter;
	}
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void setNewsletter(String newsletter){
		this.newsletter=newsletter;
	}
	
	
	
}

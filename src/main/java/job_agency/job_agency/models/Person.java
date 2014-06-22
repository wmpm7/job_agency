package job_agency.job_agency.models;



public class Person{
	private String user;
    private String firstName;
    private String lastName;
    private String sex;
    private Birthday birthday;
    private Address address;
    private Education highesteducation;
    private String email;
	private String location;
    private String interest;
    private String newsletter;
    
    

    public String getNewsletter() {
		return newsletter;
	}

	public String getUser() {
		return user;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSex() {
		return sex;
	}

	public Birthday getBirthday() {
		return birthday;
	}

	public Address getAddress() {
		return address;
	}

	public Education getHighesteducation() {
		return highesteducation;
	}

	public String getEmail() {
		return email;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setHighesteducation(Education highesteducation){
		this.highesteducation=highesteducation;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    
    
    public String getLocation() {
		return location;
	}

	public String getInterest() {
		return interest;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	public void setNewsletter(String newsletter){
		this.newsletter=newsletter;
		System.out.println(this.toString());
	}
	
	

	@Override
	public String toString() {
		return "Person [user=" + user + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", sex=" + sex + ", birthday="
				+ birthday + ", address=" + address + ", highesteducation="
				+ highesteducation + ", email=" + email + ", location="
				+ location + ", interest=" + interest + ", newsletter=" + newsletter + "]";
	}

	
	
}
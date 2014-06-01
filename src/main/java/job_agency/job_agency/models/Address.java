package job_agency.job_agency.models;

public class Address {
    private String postalcode;
    private String city;
    private String country;
    
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public boolean isAut(){
		if(this.country.equals("AUT")){
			return true;
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [postalcode=" + postalcode + ", city=" + city
				+ ", country=" + country + "]";
	}
    
    
}

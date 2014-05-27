package job_agency.job_agency.processors;

import job_agency.job_agency.beans.Joboffer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InsertJobofferProcessor implements Processor  {

	@Override
	public void process(Exchange arg0) throws Exception {
		 Joboffer offer = arg0.getIn().getBody(Joboffer.class);
		 String sqlstmt = "";
		 
		 sqlstmt = "insert into Joboffer " + 
					"(title,postalcode,city,country,phone,email,jobdescription,salary) " + 
					"values ('"
					+ offer.getTitle() + "','"
					+ offer.getAddress().getPostalcode() + "','"
					+ offer.getAddress().getCity() + "','"
					+ offer.getAddress().getCountry() + "','"
					+ offer.getPhone() + "','"
					+ offer.getEmail() + "','"
					+ offer.getJobdescription() + "','"
					+ offer.getSalary()
					+ "')";
		 
		 arg0.getIn().setBody(sqlstmt);
	}

}

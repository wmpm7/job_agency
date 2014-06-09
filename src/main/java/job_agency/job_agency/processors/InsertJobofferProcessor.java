package job_agency.job_agency.processors;

import job_agency.job_agency.models.Joboffer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class InsertJobofferProcessor implements Processor  {

	@Override
	public void process(Exchange arg0) throws Exception {
		 Joboffer offer = arg0.getIn().getBody(Joboffer.class);
		 StringBuilder sqlstmt;
		 
		 sqlstmt = new StringBuilder("insert into Joboffer ");
		 sqlstmt.append("(title,postalcode,city,country,phone,email,jobdescription,salary) ");
		 sqlstmt.append("values ('");
		 sqlstmt.append(offer.getTitle()).append("','");
		 sqlstmt.append(offer.getAddress().getPostalcode()).append("','");
		 sqlstmt.append(offer.getAddress().getCity()).append("','");
		 sqlstmt.append(offer.getAddress().getCountry()).append("','");
		 sqlstmt.append(offer.getPhone()).append("','");
		 sqlstmt.append(offer.getEmail()).append("','");
		 sqlstmt.append(offer.getJobdescription()).append("','");
		 sqlstmt.append(offer.getSalary());
		 sqlstmt.append("')");
		 
		 arg0.getIn().setBody(sqlstmt.toString());
	}

}

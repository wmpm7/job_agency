package job_agency.job_agency.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import job_agency.job_agency.models.Address;
import job_agency.job_agency.models.Joboffer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class getallJobofferProcessor implements Processor{

	@Override
	public void process(Exchange arg0) throws Exception {
		
		List data = arg0.getIn().getBody(List.class);
		ArrayList<Joboffer> al =new ArrayList<Joboffer>();
		
		for(int i =0; i<data.size();i++)
		{
			Map row = (Map)data.get(i);
			Joboffer j = new Joboffer();
			Address a = new Address();
			a.setCity((String) row.get("CITY"));
			a.setCountry((String) row.get("COUNTRY"));
			a.setPostalcode((String) row.get("POSTALCODE"));
			
			
			j.setAddress(a);
			j.setEmail((String) row.get("EMAIL"));
			j.setJobdescription((String) row.get("JOBDESCRIPTION"));
			j.setPhone((String) row.get("PHONE"));
			j.setSalary((String) row.get("SALARY"));
			j.setTitle((String) row.get("TITLE"));
			
			al.add(j);
		}
		

		arg0.getIn().setBody("Anzahl der Joboffers: "+al.size());
		
	}

}

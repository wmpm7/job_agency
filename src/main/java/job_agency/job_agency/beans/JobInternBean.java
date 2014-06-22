package job_agency.job_agency.beans;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import job_agency.job_agency.models.Address;
import job_agency.job_agency.models.Joboffer;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobInternBean 
{

	private static final Logger LOG = LoggerFactory.getLogger(JobInternBean.class);
	private ArrayList<Joboffer> jobs;

	public JobInternBean() 
	{
		this.jobs = new ArrayList<Joboffer>();
	}

	public void addToList(Exchange arg0) throws Exception {

		this.jobs.clear();
		
		LOG.info("Body: " + arg0.toString());
		List<?> data = arg0.getIn().getBody(List.class);

		for(int i =0; i<data.size();i++)
		{
			Map<?, ?> row = (Map<?, ?>)data.get(i);

			if (row.containsKey("TITLE"))
			{
				Joboffer job = buildJob(row);
				jobs.add(job);
				LOG.info(job.getKeyword());
			}
		}
	}

	public String getTitleList()
	{
		StringBuilder s=new StringBuilder("Offers from internal DB: \n");
		
		for(int i=0; i<jobs.size(); i++)
		{
			s.append("\n");
			s.append("Titel: " + jobs.get(i).getTitle() + "\n");
			s.append("Beschreibung: " + jobs.get(i).getJobdescription() + "\n");
			s.append("Ort: " +jobs.get(i).getAddress().getPostalcode() + " " + jobs.get(i).getAddress().getCity() + "\n");
			s.append("E-Mail: " + jobs.get(i).getEmail() + "\n");
		}
		return s.toString();
	}

	private Joboffer buildJob(Map<?, ?> row) {
		Address a = new Address();
		Joboffer j = new Joboffer();

		a.setCity((String) row.get("CITY"));
		a.setCountry((String) row.get("COUNTRY"));
		a.setPostalcode((String) row.get("POSTALCODE"));

		j.setTitle((String) row.get("TITLE"));
		j.setAddress(a);
		j.setPhone((String) row.get("PHONE"));
		j.setEmail((String) row.get("EMAIL"));
		j.setJobdescription((String) row.get("JOBDESCRIPTION"));
		j.setSalary((String) row.get("SALARY"));
		j.setKeyword((String) row.get("KEYWORD"));
		return j;
	}
}

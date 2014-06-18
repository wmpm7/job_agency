package job_agency.job_agency.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import job_agency.job_agency.models.Address;
import job_agency.job_agency.models.Birthday;
import job_agency.job_agency.models.Education;
import job_agency.job_agency.models.Person;
import job_agency.job_agency.models.Statistics;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkBean 
{

	private static final Logger LOG = LoggerFactory.getLogger(CalcStatisticBean.class);
	private ArrayList<Person> persons;


	public LinkBean() 
	{
		this.persons = new ArrayList<Person>();
	}

	public void addToList(Exchange arg0) throws Exception {

		this.persons.clear();
		
		LOG.info("Body: " + arg0.toString());
		List<?> data = arg0.getIn().getBody(List.class);

		for(int i =0; i<data.size();i++)
		{
			Map<?, ?> row = (Map<?, ?>)data.get(i);

			if (row.containsKey("USERNAME"))
			{
				Person person = buildPerson(row);
				persons.add(person);
			}
		}
		

	}
	
	public void formatlink(Exchange exchange)
	{
		
		for(Person p : persons)
		{
		    exchange.getIn().setHeader("recipient",
		    		"http://www.karriere.at/api/job/list?key=d1fe2f00164ddb3223728ac6f79cd7f5&keyword="+ p.getInterest() +"&location="+p.getLocation());
		    
		    LOG.info("***********************************" + "http://www.karriere.at/api/job/list?key=d1fe2f00164ddb3223728ac6f79cd7f5&keyword="+ p.getInterest() +"&location="+p.getLocation());
		}
	}
	


	private Person buildPerson(Map<?, ?> row) {
		Person p = new Person();
		Address a = new Address();
		Birthday b = new Birthday();
		Education e = new Education();

		a.setCity((String) row.get("CITY"));
		a.setCountry((String) row.get("COUNTRY"));
		a.setPostalcode((String) row.get("POSTALCODE"));
		p.setAddress(a);

		String birthday = row.get("BIRTHDAY").toString();
		String[] parts = birthday.split("-");
		String year = parts[0]; // jahr
		String month = parts[1]; // monat
		String day = parts[2]; // tag

		Calendar dob = Calendar.getInstance();
		dob.set( Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day) );
		//dob.setTime(dateOfBirth);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR)){age--;}

		b.setDay(Integer.parseInt(day));
		b.setMonth(Integer.parseInt(month));
		b.setYear(Integer.parseInt(year));
		b.setAge(age);

		p.setBirthday(b);

		e.setFather((String) row.get("EDUCATIONFATHER"));
		e.setMother((String) row.get("EDUCATIONMOTHER"));
		e.setSelf((String) row.get("EDUCATIONSELF"));
		p.setHighesteducation(e);


		p.setEmail((String) row.get("EMAIL"));
		p.setFirstName((String) row.get("FIRSTNAME"));
		p.setLastName((String) row.get("LASTNAME"));
		p.setSex((String) row.get("SEX"));
		p.setUser((String) row.get("USERNAME"));
		p.setLocation((String) row.get("LOCATION"));
		p.setInterest((String) row.get("INTEREST"));



		return p;
	}
}

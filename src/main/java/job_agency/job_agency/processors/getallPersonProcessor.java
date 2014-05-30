package job_agency.job_agency.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import job_agency.job_agency.models.Address;
import job_agency.job_agency.models.Birthday;
import job_agency.job_agency.models.Education;
import job_agency.job_agency.models.Person;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class getallPersonProcessor implements Processor{

	@Override
	public void process(Exchange arg0) throws Exception {
		
		List data = arg0.getIn().getBody(List.class);
		ArrayList<Person> al =new ArrayList<Person>();
		
		for(int i =0; i<data.size();i++)
		{
			Map row = (Map)data.get(i);
			
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
			
			b.setDay(Integer.parseInt(day));
			b.setMonth(Integer.parseInt(month));
			b.setYear(Integer.parseInt(year));
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
			
			al.add(p);
		}
		
		
		arg0.getIn().setBody("Anzahl der Personen: "+al.size());
		
	}

}

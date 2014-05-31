package job_agency.job_agency.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import job_agency.job_agency.models.Address;
import job_agency.job_agency.models.Birthday;
import job_agency.job_agency.models.Education;
import job_agency.job_agency.models.Joboffer;
import job_agency.job_agency.models.Person;
import job_agency.job_agency.models.Statistics;

import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalcStatisticBean 
{

	private static final Logger LOG = LoggerFactory.getLogger(CalcStatisticBean.class);
	private ArrayList<Joboffer> jobs;
	private ArrayList<Person> persons;

	private double maleCounter = 0;
	private double femaleCounter = 0;

	@BeanInject("Statistics")
	Statistics stat;

	public CalcStatisticBean() 
	{
		this.jobs = new ArrayList<Joboffer>();
		this.persons = new ArrayList<Person>();
	}

	public void addToList(Exchange arg0) throws Exception {

		this.jobs.clear();
		this.persons.clear();
		
		LOG.debug("Body: " + arg0.toString());
		List<?> data = arg0.getIn().getBody(List.class);

		for(int i =0; i<data.size();i++)
		{
			Map<?, ?> row = (Map<?, ?>)data.get(i);

			if (row.containsKey("TITLE"))
			{
				Joboffer job = buildJob(row);
				jobs.add(job);
			}
			else if (row.containsKey("USERNAME"))
			{
				Person person = buildPerson(row);
				persons.add(person);
			}
		}

		//		arg0.getIn().setBody("Anzahl der Joboffers: "+al.size());
		stat.setMaleCounter(maleCounter);
		stat.setFemaleCounter(femaleCounter);

		this.maleCounter = 0;
		this.femaleCounter = 0;
	}

	public Statistics calc ()
	{
		LOG.debug("_____________m:" + stat.getMaleCounter() + "_______________");
		LOG.debug("_____________f:" + stat.getFemaleCounter() + "_______________");


		stat.setPercentMale(stat.getMaleCounter() / stat.getNumberOfPeople());
		stat.setPercentFemale(stat.getFemaleCounter() / stat.getNumberOfPeople());

		double ageCount = 0;
		for(Person elem : this.persons)
		{
			ageCount = ageCount + elem.getBirthday().getAge();
		}
		stat.setMeanAge(ageCount / stat.getNumberOfPeople());
		

		return stat;
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

		if (p.getSex().equals("m"))
		{
			maleCounter = maleCounter + 1;
		}
		else
		{
			femaleCounter = femaleCounter + 1;
		}

		return p;
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
		return j;
	}

	public String makeUpperCase(String body) {
		String transformedBody = body.toUpperCase();
		return transformedBody;
	}
}

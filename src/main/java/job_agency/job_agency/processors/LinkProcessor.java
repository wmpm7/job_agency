package job_agency.job_agency.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import job_agency.job_agency.models.Joboffer;
import job_agency.job_agency.models.Person;
import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkProcessor implements Processor{

	private static final Logger LOG = LoggerFactory.getLogger(LinkProcessor.class);
	private ArrayList<Person> persons;
	
	
	public LinkProcessor() 
	{
		this.persons = new ArrayList<Person>();
	}
	

	@Override
	public void process(Exchange exchange) throws Exception {

	    String what;
	    String where;
	    
	    Questionnaire qu = exchange.getIn().getBody(Questionnaire.class);
	    
	    what = qu.person.getInterest();
	    where = qu.person.getLocation();

	    //exchange.getIn().setHeader("recipient","http://www.karriere.at/api/job/list?key=d1fe2f00164ddb3223728ac6f79cd7f5&keyword=PHP&location=Wien");
	    
	    
	    exchange.getIn().setHeader("recipient",
	    		"http://www.karriere.at/api/job/list?key=d1fe2f00164ddb3223728ac6f79cd7f5&keyword="+ what +"&location="+where);
	    
	    
	}
	
	
	
	

	

}

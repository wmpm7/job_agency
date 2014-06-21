package job_agency.job_agency.processors;

import java.util.ArrayList;

import job_agency.job_agency.models.Person;
import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetTitleProcessor implements Processor{

	private static final Logger LOG = LoggerFactory.getLogger(GetTitleProcessor.class);
	private ArrayList<Person> persons;
	
	
	public GetTitleProcessor() 
	{
		this.persons = new ArrayList<Person>();
	}
	

	@Override
	public void process(Exchange exchange) throws Exception {
	    
	    Questionnaire qu = exchange.getIn().getBody(Questionnaire.class);
	    
	    String key = qu.person.getInterest();

	    //exchange.getIn().setHeader("recipient","http://www.karriere.at/api/job/list?key=d1fe2f00164ddb3223728ac6f79cd7f5&keyword=PHP&location=Wien");
	 	    
	    String sql = "select * from joboffer where keyword like '" + key + "'";//" + key + "'";
	    LOG.info(sql);
	    LOG.info(key);
	    exchange.getIn().setBody(sql);// where keyword = 'Java'");//"+ key.toLowerCase() + "'");
	    
	    
	}
}

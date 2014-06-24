package job_agency.job_agency.processors;

import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LinkProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {

	    String what;
	    String where;
	    
	    Questionnaire qu = exchange.getIn().getBody(Questionnaire.class);
	    
	    what = qu.person.getInterest();
	    where = qu.person.getLocation();
	    
	    exchange.getIn().setHeader("recipient",
	    		"http://www.karriere.at/api/job/list?key=d1fe2f00164ddb3223728ac6f79cd7f5&keyword="+ what +"&location="+where);
	}
	
	
	
	

	

}

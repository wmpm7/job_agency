package job_agency.job_agency.processors;

import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CreateDirectoryProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String who;
	    
	    Questionnaire qu = exchange.getIn().getBody(Questionnaire.class);
	    
	    who = qu.person.getUser();

	    exchange.getIn().setHeader("CamelFileName", "external_offers_" + who + ".txt");
		
	}

}

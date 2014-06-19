package job_agency.job_agency.processors;

import job_agency.job_agency.models.Questionnaire;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailProcessor implements Processor{

	private static final Logger LOG = LoggerFactory.getLogger(EmailProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {

	    String email = "";
	    
	    Questionnaire qu = exchange.getIn().getBody(Questionnaire.class);
	    email = qu.person.getEmail();


	    LOG.debug(qu.person.toString());
	    
	    exchange.getIn().setHeader("subject", "Result job questionnaire");
	    
	    exchange.getIn().setHeader("recipient",
	    		"smtps://wmpm.group7@smtp.gmail.com:465?password={{emailPassword}}&username={{emailUsername}}"   //port 25 or port 465
	    		+ "&mail.smtp.starttls.enable=true"
	    		+ "&to=" + email);
	}
}

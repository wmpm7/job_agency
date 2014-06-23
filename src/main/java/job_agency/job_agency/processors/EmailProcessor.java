package job_agency.job_agency.processors;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailProcessor implements Processor{

	private static final Logger LOG = LoggerFactory.getLogger(EmailProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {

	    String email = "";
	    
	    //Questionnaire qu = exchange.getIn().getBody(Questionnaire.class);
	    //email = qu.person.getEmail();


	    //LOG.debug(qu.person.toString());
	    
	    exchange.getIn().setHeader("subject", "Your job offers");
	    
	    exchange.getIn().setHeader("recipient",
	    		"smtps://group7.wmpm@smtp.gmail.com:465?password={{emailPassword}}&username={{emailUsername}}"   //port 25 or port 465
	    		+ "&mail.smtp.starttls.enable=true"
	    		+ "&to=" + email);
	    //exchange.getIn().setBody(new DataHandler(new FileDataSource("target/fromApi/finish/all_offers")));
	    //exchange.getIn().addAttachment("all_offers", new DataHandler(new FileDataSource("target/fromApi/finish/all_offers")));
	}
}

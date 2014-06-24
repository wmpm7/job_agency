package job_agency.job_agency.processors;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class EmailProcessor implements Processor{

	//private static final Logger LOG = LoggerFactory.getLogger(EmailProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {

	    String email = (String)exchange.getIn().getHeader("recipient");

	    exchange.getIn().setHeader("subject", "Your job offers");
	    
	    exchange.getIn().setHeader("recipient",
	    		"smtps://group7.wmpm@smtp.gmail.com:465?password={{emailPassword}}&username={{emailUsername}}"   //port 25 or port 465
	    		+ "&mail.smtp.starttls.enable=true"
	    		+ "&to=" + email);
	}
}
